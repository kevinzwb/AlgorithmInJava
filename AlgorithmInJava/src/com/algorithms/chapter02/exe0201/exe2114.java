package com.algorithms.chapter02.exe0201;

import java.util.ArrayList;
import java.util.Collections;

public class exe2114 {
    public static void main(String[] args) {
        Poker poker  = new Poker();
        poker.print();
        poker.sort();
        poker.print();
    }

    private static class Poker{

        private ArrayList<String> cards = new ArrayList<>();

        Poker(){
            String[] color = {"A","B","C","D"};

            for (String c:color){
                for (int i = 0; i < 13; i++) {
                    cards.add(c + "-" + i);
                }
            }
            Collections.shuffle(cards);
        }

        public void sort(){
            ArrayList<String> results = new ArrayList<>();
            while (cards.size() > 1){
                for (int j = 0; j < cards.size() ; j++) {
                    if (check()) swap(0,1);
                    String tmp = cards.remove(0);
                    cards.add(tmp);
                }
                String tmp = cards.remove(0);
                results.add(tmp);
            }
            String tmp = cards.remove(0);
            results.add(tmp);
            cards = results;
        }

    public boolean check(){
        String[] first  = cards.get(0).split("-");
        String[] second = cards.get(1).split("-");

        if (first[0].compareTo(second[0]) > 0)
            return true;
        else if (first[0].compareTo(second[0]) == 0)
            return Integer.valueOf(first[1]) > Integer.valueOf(second[1]) ? true : false;
        else return false;
    }

        public void swap(int i,int j){
            String tmp = cards.get(i);
            cards.set(i,cards.get(j));
            cards.set(j,tmp);
        }


        public void print(){
            for (String res : cards){
                System.out.print(res + " ");
            }
            System.out.println();
        }
    }
}

