package com.hospital.pojo;

import com.alibaba.fastjson.annotation.JSONField;

public class Department {
    @JSONField(name = "OID")
    private Integer OID;
    @JSONField(name = "OName")
    private String OName;
    @JSONField(name = "detail")
    private String detail;
    @JSONField(name = "DepID")
    private String depID;

    public Integer getOID() {
        return OID;
    }

    public void setOID(Integer OID) {
        this.OID = OID;
    }

    public String getOName() {
        return OName;
    }

    public void setOName(String OName) {
        this.OName = OName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }
}

