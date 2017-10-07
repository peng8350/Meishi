package com.peng.meishi.entity;

/**
 * Created by peng on 16-10-15.
 */
public class NearInfo {
    private int id;
    private String name;
    private int type;
    private float scope;
    private String place;
    private int lon;
    private int lat;

    public NearInfo(int id, String name, int type, float scope, String place, int lon, int lat) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.scope = scope;
        this.place = place;
        this.lon = lon;
        this.lat = lat;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public float getScope() {
        return scope;
    }

    public void setScope(float scope) {
        this.scope = scope;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getLon() {
        return lon;
    }

    public void setLon(int lon) {
        this.lon = lon;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }
}
