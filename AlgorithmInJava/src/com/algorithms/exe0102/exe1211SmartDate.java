package com.algorithms.exe0102;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Set;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class exe1211SmartDate {
    private final int month;
    private final int day;
    private final int year;

    public exe1211SmartDate(int m,int d, int y)
    {
        month = m;
        day = d;
        year = y;

        if (!rangeInDefined(m,1,12) && !rangeInDefined(m,1970,3000))
            throw  new RuntimeException("Error year or month");
        else{
            int[] bigmonth = { 1,3,5,7,8,10,12};
            if (Arrays.asList(bigmonth).contains(month)) {
                if (!rangeInDefined(m, 1, 31))
                    throw new RuntimeException("Error day");;
            }
            else if(month == 2){
                if (!rangeInDefined(m, 1, 29))
                    throw new RuntimeException("Error day");;
            }
            else{
                if (!rangeInDefined(m, 1, 30))
                    throw new RuntimeException("Error day");;
            }
        }
    }

    public static boolean rangeInDefined(int current, int min, int max)
    {
        return Math.max(min, current) == Math.min(current, max);
    }

    public int month(){
        return month;
    }

    public int day(){
        return day;
    }

    public int year(){
        return year;
    }

    public int datyofTheWeek() {


        Calendar cal = new GregorianCalendar();

        cal.set(year,month-1,day);


        StdOut.println(" " + year+month+day);
        StdOut.println(cal.getTime());

        return cal.get(Calendar.DAY_OF_WEEK);

    }


    public String toString(){
        return month() + "-" + day() + "-" + year();
    }

    public boolean equals(Object x){
        if (this == x) return true;
        if ( x == null) return false;
        if (this.getClass() != x.getClass()) return false;

        exe1211SmartDate that = (exe1211SmartDate) x;
        if (this.day != that.day) return false;
        if (this.month != that.month) return false;
        if (this.year != that.year) return false;
        return true;
    }

    public static void main(String[] args) {
        exe1211SmartDate date = new exe1211SmartDate(12,20,2017);
        StdOut.println(date.datyofTheWeek());
    }
}
