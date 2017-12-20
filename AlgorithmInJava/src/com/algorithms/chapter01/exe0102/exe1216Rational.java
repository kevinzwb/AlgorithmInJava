package com.algorithms.chapter01.exe0102;

import edu.princeton.cs.algs4.StdOut;

public class exe1216Rational {
    private int numerator;
    private int denominator;

    public exe1216Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public exe1216Rational plus(exe1216Rational b){
        int newNumerator = (this.numerator * b.denominator) + (b.numerator * this.denominator);
        int newDenominator = this.denominator * b.denominator;
        return reduction(newNumerator,newDenominator);
    }

    public exe1216Rational minus(exe1216Rational b){
        int newNumerator = (this.numerator * b.denominator) - (b.numerator * this.denominator);
        int newDenominator = this.denominator * b.denominator;
        return reduction(newNumerator,newDenominator);
    }

    public exe1216Rational times(exe1216Rational b){
        int newNumerator = this.numerator * b.numerator;
        int newDenominator = this.denominator * b.denominator;
        return reduction(newNumerator,newDenominator);
    }

    public exe1216Rational divides(exe1216Rational b){
        int newNumerator = this.numerator * b.denominator;
        int newDenominator = this.denominator * b.numerator;
        return reduction(newNumerator,newDenominator);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return this.numerator + " : " + this.denominator;
    }

    private static int euclid(int first, int second) {
        if (first <= 0 || second <= 0) {
            throw new IllegalArgumentException();
        }
        if(first < second)
        {
            int temp = second;
            second = first;
            first =temp;
        }
        int temp = first % second;
        if (temp == 0) {
            return second;
        } else {
            return euclid(second, temp);
        }
    }

    private static exe1216Rational reduction(int numerator,int denominator){
        int commonFactor = euclid(numerator,denominator);
        if(commonFactor > 1) {
            numerator = numerator / commonFactor;
            denominator = denominator / commonFactor;
        }
        return new exe1216Rational(numerator,denominator);
    }



    public static void main(String[] args) {
        exe1216Rational fractionA = new exe1216Rational(100, 10);
        StdOut.println(fractionA);
        exe1216Rational fractionB = new exe1216Rational(10, 10);
        StdOut.println(fractionA.plus(fractionB));
        StdOut.println(fractionA.minus(fractionB));
        StdOut.println(fractionA.times(fractionB));
        StdOut.println(fractionA.divides(fractionB));
        StdOut.println("test");
    }


}
