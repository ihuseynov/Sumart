package com.only.aquahack.Models;

/**
 * Created by only_ on 7/3/2020.
 */

public class Device {

    private int id;
    private String location;
    private String code;
    private String type;
    private double debt;
    private String last_sync;


    public Device(int id, String location, String code, String type, double debt, String last_sync) {
        this.id = id;
        this.location = location;
        this.code = code;
        this.type = type;
        this.debt = debt;
        this.last_sync = last_sync;
    }


    public  Device(){}


    public void setId(int id) {
        this.id = id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public void setLast_sync(String last_sync) {
        this.last_sync = last_sync;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public double getDebt() {
        return debt;
    }

    public String getLast_sync() {
        return last_sync;
    }
}
