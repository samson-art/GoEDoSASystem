package ru.mephi.entity;

import java.io.Serializable;

/**
 * Created by artemsamsonov on 27.11.15.
 */
public abstract class Entity implements Serializable {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Entity() {
    }
}
