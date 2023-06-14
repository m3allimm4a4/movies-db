package com.beshara.moviesdbapi.models.dbo;

public class Creator {
    private long id;
    private String name;

    public Creator() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Creator{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
