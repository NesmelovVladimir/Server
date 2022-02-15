package tz.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tz.server.entity.Robject;
import tz.server.service.RobjectService;

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
        robjectService.saveGeom(newRobject.getObjectId(), newRobject.getGeom());
        return robjectService.save(robject);
    }
}
