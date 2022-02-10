package tz.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tz.server.entity.Dogovor;

import java.util.List;
import java.util.UUID;

public interface DogovorRepository extends JpaRepository<Dogovor, UUID> {
    List<Dogovor> findAll();

    Dogovor findByDogovorId(UUID dogovorId);

    Dogovor save(Dogovor dogovor);
}
