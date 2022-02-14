package tz.server.controller;

import org.postgis.MultiPolygon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tz.server.entity.Robject;
import tz.server.service.RobjectService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@RestController
public class Controller {

    @Autowired
    private RobjectService robjectService;

    @GetMapping(value = "/")
    public List<Robject> readAll() {
        return robjectService.readAll();
    }

    @PutMapping("/{objectId}")
    Robject robject(@RequestBody Robject newRobject, @PathVariable UUID objectId) {
        Robject robject;
        robject = robjectService.findByObjectId(objectId);
        updateGeometry(objectId, newRobject.getGeom());
        return robjectService.save(robject);
    }

    public Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/TEST", "postgres", "sp");

        //"--spring.datasource.url", "--spring.datasource.username", "--spring.datasource.password");
    }

    public void updateGeometry(UUID objectId, MultiPolygon geom) {

        String SQL = String.format("update robject SET geom=ST_GeomFromText('%1$s', 4326) " +
                "WHERE object_id= '%2$s' ", geom.toString(), objectId.toString());

        try (Connection conn = connect();
             PreparedStatement prepareStatement = conn.prepareStatement(SQL)) {

            prepareStatement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }
    }
}
