package tz.server.controller;

import org.postgis.MultiPolygon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String password;

    @GetMapping(value = "/")
    public List<Robject> readAll() {
        return robjectService.readAll();
    }

    @PutMapping("/{objectId}")
    Robject robject(@RequestBody Robject newRobject, @PathVariable UUID objectId) throws Exception {
        Robject robject;
        robject = robjectService.findByObjectId(objectId);
        MultiPolygon geom = new MultiPolygon(newRobject.getGeom());
        updateGeometry(objectId, geom);
        return robjectService.save(robject);
    }

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
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
