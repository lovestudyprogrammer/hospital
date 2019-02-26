package com.hospital.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class DoctorsPOJO {
    @JSONField(name = "Char")
    private String Char;
    @JSONField(name = "Doctors")
    private List<Doctor> Doctors;

    public String getChar() {
        return Char;
    }

    public void setChar(String aChar) {
        Char = aChar;
    }

    public List<Doctor> getDoctors() {
        return Doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        Doctors = doctors;
    }
}
