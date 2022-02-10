package tz.server.entity;

import org.postgis.MultiPolygon;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;


@Entity
@Table(name = "rdogovor")
public class Dogovor implements Serializable {

    @Id
    @Column(name = "dogovor_id")
    private UUID dogovorId;

    @Column(name = "dog_no")
    private String dogNo;

    @Column(name = "dog_date")
    private Timestamp dogDate;

    @Column(name = "update_time")
    private Timestamp updateTime;

    @Column(name = "coordinates")
    private String coordinates;

    @Column(name = "geom")
    private MultiPolygon geom;

    public UUID getDogovorId() {
        return dogovorId;
    }

    public void setDogovorId(UUID dogovorId) {
        this.dogovorId = dogovorId;
    }

    public String getDogNo() {
        return dogNo;
    }

    public void setDogNo(String dogNo) {
        this.dogNo = dogNo;
    }

    public Timestamp getDogDate() {
        return dogDate;
    }

    public void setDogDate(Timestamp dogDate) {
        this.dogDate = dogDate;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coodrinates) {
        this.coordinates = coodrinates;
    }

    public MultiPolygon getGeom() {
        return geom;
    }

    public void setGeom(MultiPolygon geom) {
        this.geom = geom;
    }
}

