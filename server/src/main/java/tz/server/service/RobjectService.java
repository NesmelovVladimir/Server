package tz.server.service;

import tz.server.entity.Robject;

import java.util.List;
import java.util.UUID;

public interface RobjectService {
    List<Robject> readAll();

    Robject findByObjectId(UUID objectId);

    Robject save(Robject robject);
}
