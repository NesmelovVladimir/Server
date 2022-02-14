package tz.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tz.server.entity.Robject;

import java.util.List;
import java.util.UUID;

public interface RobjectRepository extends JpaRepository<Robject, UUID> {

    @Query(value = "select u.object_id,u.coordinates,st_astext(u.geom) as geom from robject u where u.coordinates is not null", nativeQuery = true)
    List<Robject> findAll();

    Robject findByObjectId(UUID objectId);

    Robject save(Robject robject);
}
