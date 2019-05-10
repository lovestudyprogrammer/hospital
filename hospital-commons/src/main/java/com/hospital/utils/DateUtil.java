package com.hospital.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateUtil {

    /**
     * 短格式日期格式化
     */
    private static final SimpleDateFormat SHORT_YEAR_FORMATOR = new SimpleDateFormat("yy-MM-dd");
    /**
     * 标准日期格式化
     */
    public static final SimpleDateFormat CUSTOM_DAY_FORMATOR = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * 标准日期时间格式化
     */
    private static final SimpleDateFormat CUSTOM_DAYTIME_FORMATOR = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    /**
     * 通过身份证号码获取出生日期、性别、年龄
     *
     * @param certificateNo
     * @return 返回的出生日期格式：1990-01-01   性别格式：F-女，M-男
     */
    public static Map<String, String> getBirAgeSex(String certificateNo) {
        String birthday = "";
        String age = "";
        String sexCode = "";

        int year = Calendar.getInstance().get(Calendar.YEAR);
        char[] number = certificateNo.toCharArray();
        boolean flag = true;
        if (number.length == 15) {
            for (int x = 0; x < number.length; x++) {
                if (!flag) return new HashMap<String, String>();
                //判断字符是否为数字，是返回true，否返回false
                flag = Character.isDigit(number[x]);
            }
        } else if (number.length == 18) {
            for (int x = 0; x < number.length - 1; x++) {
                if (!flag) return new HashMap<String, String>();
                flag = Character.isDigit(number[x]);
            }

        }
        if (flag && certificateNo.length() == 15) {
            birthday = "19" + certificateNo.substring(6, 8) + "-"
                    + certificateNo.substring(8, 10) + "-"
                    + certificateNo.substring(10, 12);
            sexCode = Integer.parseInt(certificateNo.substring(certificateNo.length() - 3, certificateNo.length())) % 2 == 0 ? "F" : "M";
            age = (year - Integer.parseInt("19" + certificateNo.substring(6, 8))) + "";
        } else if (flag && certificateNo.length() == 18) {
            birthday = certificateNo.substring(6, 10) + "-"
                    + certificateNo.substring(10, 12) + "-"
                    + certificateNo.substring(12, 14);
            sexCode = Integer.parseInt(certificateNo.substring(certificateNo.length() - 4, certificateNo.length() - 1)) % 2 == 0 ? "F" : "M";
            age = (year - Integer.parseInt(certificateNo.substring(6, 10))) + "";
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("birthday", birthday);
        map.put("age", age);
        map.put("sexCode", sexCode);
        return map;
    }

    /**
     * 获得指定日期的后一天     *     * @param specifiedDay 指定日期     * @return 后一天
     */
    public static Date getSpecifiedDayAfter(String specifiedDay) {
        return getDate(specifiedDay, 1);
    }

    private static Date getDate(String specifiedDay, int diffDays) {
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(SHORT_YEAR_FORMATOR.parse(specifiedDay));
            c.set(Calendar.DATE, c.get(Calendar.DATE) + diffDays);
            return CUSTOM_DAY_FORMATOR.parse(CUSTOM_DAY_FORMATOR.format(c.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 比较日期
     *
     * @param dateStr1
     * @param dateStr2
     * @return
     */
    public static int compareDate(String dateStr1, String dateStr2) {
        Date date1 = parseDate(dateStr1);
        Date date2 = parseDate(dateStr2);
        if (date1.getTime() > date2.getTime())
            return -1;
        else if (date1.getTime() < date2.getTime())
            return 1;
        else
            return 0;
    }

    /**
     * 格式化字符串为日期
     *
     * @param date
     * @param format
     * @return
     */
    public static Date parseDate(String date, String format) {
        try {
            return new SimpleDateFormat(format).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date parseDate(String date) { return parseDate(date, DATE_FORMAT);}
    public static Date parseDateTime(String date) {
        return parseDate(date, DATETIME_FORMAT);
    }
}
