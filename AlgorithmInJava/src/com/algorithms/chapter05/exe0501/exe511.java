package com.algorithms.chapter05.exe0501;

import edu.princeton.cs.algs4.Stack;

import java.io.*;
import java.util.*;

public class exe511 {
    public static void main(String[] args) throws IOException {
        String file = "/home/wenbo/Dataset/algs4-data/ip.csv";
        BufferedReader inputStream = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file))));

        String line;
        int maxLength = 0;
        Stack<String> websites = new Stack<>();
//        TreeSet<String> webs = new TreeSet<>();
        while ((line = inputStream.readLine()) != null){
            String[] content = line.split(",");
            websites.push(content[0]);
            if (maxLength < content[0].length())
                maxLength = content[0].length();
        }

        int N = websites.size();
        String[] a = new String[N];
        for (int i = 0; i < N; i++) a[i] = websites.pop();

//        sort(a);
    }



    public static void sort(String[] items,int w){
        int N = items.length;
        int R = 256;
        String[] aux = new String[N];

        for (int d = w-1; d >= 0 ; d--) {
            TreeMap<Character,Integer> frequencyCounter = new TreeMap<>();

            for (String item:items){
                Character key = item.charAt(d);
                if(frequencyCounter.containsKey(item.charAt(d)))
                    frequencyCounter.put(key,frequencyCounter.get(key)+1);
                else
                    frequencyCounter.put(key,1);
            }

            TreeMap<Object, Object> indexCounter = new TreeMap<>();
            for (Map.Entry entry:frequencyCounter.entrySet())
                indexCounter.put(entry.getKey(),entry.getValue());

        }
    }
}

