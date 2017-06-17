package dev.study.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Util {

    //포맺형식이 없는 메서드.
    public static String getCurrentDate(){
        return getCurrentDate("yyyy-MM-dd HH:mm:ss");
    }

    //포맺형식이 있는 메서드
    public static String getCurrentDate(String format){
        Calendar today = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(today.getTime());
    }
    
    public static void main(String[] args) {
    	System.out.println(getCurrentDate());
	}

}
