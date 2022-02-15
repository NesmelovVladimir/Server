package tz.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import tz.server.entity.Robject;

import java.util.List;
import java.util.UUID;

public interface RobjectRepository extends JpaRepository<Robject, UUID> {

    @Query(value = "select u.object_id,u.coordinates,st_astext(u.geom) as geom from robject u where u.coordinates is not null limit 100", nativeQuery = true)
    List<Robject> findAll();

    @Modifying
    @Transactional
    @Query(value = "update robject SET geom=ST_GeomFromText(:geom, 4326) WHERE object_id= :objectId ", nativeQuery = true)
    void saveGeom(@Param("objectId") UUID objectId, @Param("geom") String geom);

    Robject findByObjectId(UUID objectId);

    Robject save(Robject robject);
}
