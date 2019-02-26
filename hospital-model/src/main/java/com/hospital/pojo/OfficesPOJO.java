package com.hospital.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class OfficesPOJO {
    @JSONField(name = "DepID")
    private String depID;
    @JSONField(name = "DepName")
    private String depName;
    @JSONField(name = "Offices")
    private List<Department> offices;

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public List<Department> getOffices() {
        return offices;
    }

    public void setOffices(List<Department> offices) {
        this.offices = offices;
    }
}
