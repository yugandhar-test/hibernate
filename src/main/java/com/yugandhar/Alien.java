package com.yugandhar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

//pojo
@Entity
public class Alien {

    @Id
    private int id;
    private String name;
    private String color;

    @OneToOne
    private Spaceships spaceships;

    public Spaceships getSpaceships() {
        return spaceships;
    }

    public void setSpaceships(Spaceships spaceships) {
        this.spaceships = spaceships;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}