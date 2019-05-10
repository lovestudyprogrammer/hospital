package com.hospital.utils;

public enum DateTye {
    FOURDATE("4","08 : 00 - 08 : 03"),
    FIVEDATE("5","08 : 03 - 08 : 06"),
    SIXDATE("6","08 : 06 - 08 : 09"),
    SEVENDATE("7","08 : 09 - 08 : 12"),
    EIGHTDATE("8","08 : 12 - 08 : 15"),
    NINEDATE("9","08 : 15 - 08 : 18"),
    TENDATE("10","08 : 18 - 08 : 21"),
    ELEVENDATE("11","08 : 21 - 08 : 24"),
    TWELVEDATE("12","08 : 24 - 08 : 28"),
    THIRTEENDATE("13","08 : 28 - 08 : 31"),
    FOURTEENDATE("14","08 : 31 - 08 : 34"),
    FIFTEENDATE("15","08 : 34 - 08 : 37"),
    SIXTEENDATE("16","08 : 37 - 08 : 40"),
    SEVENTEENDATE("17","08 : 40 - 08 : 43"),
    EIGHTEENDATE("18","08 : 43 - 08 : 46"),
    NINETEENDATE("19","08 : 46 - 08 : 49"),
    TWENTYDATE("20","08 : 49 - 08 : 52"),
    TWENTYONEDATE("21","08 : 52 - 08 : 56"),
    TWENTYTWODATE("22","08 : 56 - 08 : 59"),
    TWENTYTHREEDATE("23","08 : 59 - 09 : 02"),
    TWENTYFOURDATE("24","09 : 02 - 09 : 05"),
    TWENTYFIVEDATE("25","09 : 05 - 09 : 08"),
    TWENTYSIXDATE("26","09 : 08 - 09 : 11"),
    TWENTYSEVENDATE("27","09 : 11 - 09 : 14"),
    TWENTYEIGHTDATE("28","09 : 14 - 09 : 17"),
    TWENTYNINEDATE("29","09 : 17 - 09 : 21"),
    THIRTYDATE("30","09 : 21 - 09 : 24"),
    THIRTYONEDATE("31","09 : 24 - 09 : 27"),
    THIRTYTWODATE("32","09 : 27 - 09 : 30"),
    THIRTYTHREEDATE("33","09 : 30 - 09 : 33"),
    THIRTYFOURDATE("34","09 : 33 - 09 : 36"),
    THIRTYFIVEDATE("35","09 : 36 - 09 : 39"),
    THIRTYSIXDATE("36","09 : 39 - 09 : 42"),
    THIRTYSEVENDATE("37","09 : 42 - 09 : 45"),
    THIRTYEIGHTDATE("38","09 : 45 - 09 : 49"),
    THIRTYNINEDATE("39","09 : 49 - 09 : 52"),
    FOURTYDATE("40","09 : 52 - 09 : 55"),
    FOURTYONEDATE("41","09 : 55 - 09 : 58"),
    FOURTYTWODATE("42","09 : 58 - 10 : 01"),
    FOURTYTHREEDATE("43","10 : 01 - 10 : 04"),
    FOURTYFOURDATE("44","10 : 04 - 10 : 07"),
    FOURTYFIVEDATE("45","10 : 07 - 10 : 10"),
    FOURTYSIXDATE("46","10 : 10 - 10 : 14"),
    FOURTYSEVENDATE("47","10 : 14 - 10 : 17"),
    FOURTYEIGHTDATE("48","10 : 17 - 10 : 20"),
    FOURTYNINEDATE("49","10 : 20 - 10 : 23"),
    FIFTYDATE("50","10 : 23 - 10 : 26"),
    FIFTYONEDATE("51","10 : 26 - 10 : 29"),
    FIFTYTWODATE("52","10 : 29 - 10 : 32"),
    FIFTYTHREEDATE("53","10 : 32 - 10 : 35");

    private String tbNumber;
    private String time;

    DateTye(String tbNumber, String time) {
        this.tbNumber = tbNumber;
        this.time = time;
    }

    public String getTbNumber() {
        return tbNumber;
    }

    public void setTbNumber(String tbNumber) {
        this.tbNumber = tbNumber;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public static String getDateTypeByNumber(String number){
        DateTye[] states=DateTye.values();
        for (DateTye state : states) {
            if(state.getTbNumber().equals(number)){
                return state.getTime();
            }
        }
        return null;
    }
}
