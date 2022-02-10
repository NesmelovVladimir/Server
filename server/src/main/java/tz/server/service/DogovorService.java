package tz.server.service;

import tz.server.entity.Dogovor;

import java.util.List;
import java.util.UUID;

public interface DogovorService {
    List<Dogovor> readAll();

    Dogovor findByDogovorId(UUID dogovorID);

    Dogovor save(Dogovor dogovor);
}
