package tz.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tz.server.entity.Dogovor;
import tz.server.service.DogovorService;

import java.util.List;
import java.util.UUID;

@RestController
public class Controller {

    @Autowired
    private DogovorService dogovorService;

    @GetMapping(value = "/")
    public List<Dogovor> readAll() {
        return dogovorService.readAll();
    }
    @PutMapping("/{dogovorId}")
    Dogovor dogovor(@RequestBody Dogovor newDogovor, @PathVariable UUID dogovorId) {
        Dogovor dogovor;
        dogovor = dogovorService.findByDogovorId(dogovorId);
        dogovor.setDogNo(newDogovor.getDogNo());
        dogovor.setGeom(newDogovor.getGeom());
        return dogovorService.save(dogovor);
    }
}
