package com.algorithms.exe0102;

import edu.princeton.cs.algs4.StdOut;

public class exe1212Transaction {

    private final String who;
    private final Date when;
    private final double amount;

    public exe1212Transaction(String who, Date when, double amount) {
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public exe1212Transaction(String transction){
        String[] paras = transction.split(" ");
        this.who = paras[0];
        this.when = new Date(paras[1]);
        this.amount= Double.parseDouble((paras[2]));
    }

    public String getWho() {
        return who;
    }

    public Date getWhen() {
        return when;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return getWho() + " made a transcation of value " + getAmount() + " at " + getWhen();
    }

    @Override
    public boolean equals(Object x) {
        if (this == x) return true;
        if ( x == null) return false;
        if (this.getClass() != x.getClass()) return false;

        exe1212Transaction that = (exe1212Transaction) x;
        if (this.who != that.who) return false;
        if (!this.when.equals(that.when)) return false;
        if (this.amount != that.amount) return false;
        return true;
    }

    public static void main(String[] args) {
        exe1212Transaction transactionA = new exe1212Transaction("kevin",new Date(02,12,2045),2000.0);
        exe1212Transaction transactionB = new exe1212Transaction("jack",new Date(03,15,2015),4000.0);
        exe1212Transaction transactionC = new exe1212Transaction("lili",new Date(05,02,2025),8000.0);
        exe1212Transaction transactionD = transactionA;

        StdOut.println(transactionA);
        StdOut.println(transactionB);
        StdOut.println(transactionC);
        StdOut.println(transactionD);

        StdOut.println(transactionA.equals(transactionA));
        StdOut.println(transactionA.equals(transactionB));
        StdOut.println(transactionB.equals(transactionC));
        StdOut.println(transactionD.equals(transactionA));

        exe1212Transaction transactionF = new exe1212Transaction("Turing 5/22/1939 11.99");
        exe1212Transaction transactionG = new exe1212Transaction("Alan 12/22/2017 1199");
        StdOut.println(transactionF);
        StdOut.println(transactionG);
    }
}

class Date{
    private final int month;
    private final int day;
    private final int year;

    public Date(int m, int d, int y){
        month =m;
        day = d;
        year= y;
    }

    public Date(String date){
        String[] paras = date.split("/");
        month = Integer.parseInt((paras[0]));
        day = Integer.parseInt((paras[1]));
        year = Integer.parseInt((paras[2]));
    }

    public int getMonth(){
        return month;
    }

    public int getDay(){
        return day;
    }

    public int getYear(){
        return year;
    }

    @Override
    public String toString() {
        return getMonth() + "-" + getDay() + "-" + getYear();
    }

    @Override
    public boolean equals(Object x){
        if (this == x) return true;
        if ( x == null) return false;
        if (this.getClass() != x.getClass()) return false;

        Date that = (Date) x;
        if (this.day != that.day) return false;
        if (this.month != that.month) return false;
        if (this.year != that.year) return false;
        return true;
    }
}