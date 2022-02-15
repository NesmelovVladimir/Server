package tz.server.entity;

import org.postgis.MultiPolygon;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.UUID;


@Entity
@Table(name = "robject")
public class Robject implements Serializable {

    @Id
    @Column(name = "object_id")
    private UUID objectId;

    @Column(name = "coordinates")
    private String coordinates;

    @Column(name = "geom")
    private String geom;

    public UUID getObjectId() {
        return objectId;
    }

    public void setObjectId(UUID objectId) {
        this.objectId = objectId;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coodrinates) {
        this.coordinates = coodrinates;
    }

    public String getGeom() {
            return geom;
    }

    public void setGeometry(MultiPolygon geom) {
        this.geom = geom.toString();
    }
}

