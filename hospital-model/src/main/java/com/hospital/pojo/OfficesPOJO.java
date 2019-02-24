package com.hospital.pojo;

import java.util.List;

public class OfficesPOJO {
    private String DepID;
    private String DepName;
    private List<Department> Offices;

    public String getDepID() {
        return DepID;
    }

    public void setDepID(String depID) {
        DepID = depID;
    }

    public String getDepName() {
        return DepName;
    }

    public void setDepName(String depName) {
        DepName = depName;
    }

    public List<Department> getOffices() {
        return Offices;
    }

    public void setOffices(List<Department> offices) {
        Offices = offices;
    }
}
