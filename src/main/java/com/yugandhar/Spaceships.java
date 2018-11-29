package com.yugandhar;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Spaceships {

    @Id
    private int shipId;

    public Spaceships() {
    }

    public Spaceships(int shipId, String shipName) {
        this.shipId = shipId;
        this.shipName = shipName;
    }

    private String shipName;

    public int getShipId() {
        return shipId;
    }

    public void setShipId(int shipId) {
        this.shipId = shipId;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }
}
