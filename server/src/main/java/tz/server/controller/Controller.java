package tz.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tz.server.entity.Dogovor;
import tz.server.service.DogovorService;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private DogovorService dogovorService;

    @GetMapping(value = "/")
    public List<Dogovor> readAll() {
        return dogovorService.readAll();
    }
}
