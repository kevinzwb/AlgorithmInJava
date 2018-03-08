package com.algorithms.chapter03.exe0301;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;

import java.util.HashMap;
import java.util.HashSet;


public class exe311 {
    public static void main(String[] args) {
        Queue<String> gradeSet = new Queue<>();

        System.out.println("Please input the grade {A+,A,A-,B+,A,A-,A+,A,A-,}:");
        while(!StdIn.isEmpty()) {
            gradeSet.enqueue(StdIn.readString());
        }

        double sum = 0;
        GPA gpa = new GPA();
        for(String grade:gradeSet){
            sum += gpa.transTable.get(grade);
        }

        double GPA = sum/gradeSet.size();
        System.out.println(GPA);
    }
}


class GPA{
    static HashMap<String,Double> transTable = new HashMap();

    public GPA() {
        transTable.put("A+",4.33);
        transTable.put("A", 4.00);
        transTable.put("A-",3.67);
        transTable.put("B+",3.33);
        transTable.put("B", 3.00);
        transTable.put("B-",2.67);
        transTable.put("C+",2.33);
        transTable.put("C", 2.00);
        transTable.put("C-",1.67);
        transTable.put("D", 1.00);
        transTable.put("F", 0.00);
    }


}