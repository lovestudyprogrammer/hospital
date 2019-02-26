package com.hospital.pojo;

import com.alibaba.fastjson.annotation.JSONField;

public class Doctor {
    @JSONField(name = "DID")
    private Integer DId;
    @JSONField(name = "DName")
    private String DName;
    private String sex;
    private String phone;
    @JSONField(name = "DImage")
    private String DImage;
    private Integer age;
    @JSONField(name = "OfficeID")
    private Integer OId;
    @JSONField(name = "OfficeName")
    private String OName;
    @JSONField(name = "Position")
    private String position;

    public Integer getDId() {
        return DId;
    }

    public void setDId(Integer DId) {
        this.DId = DId;
    }

    public String getDName() {
        return DName;
    }

    public void setDName(String DName) {
        this.DName = DName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDImage() {
        return DImage;
    }

    public void setDImage(String DImage) {
        this.DImage = DImage;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getOId() {
        return OId;
    }

    public void setOId(Integer OId) {
        this.OId = OId;
    }

    public String getOName() {
        return OName;
    }

    public void setOName(String OName) {
        this.OName = OName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
