package com.algorithms.chapter02.exe0201;

import java.util.*;

public class exe2113 {
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
            for (int i = 0; i < cards.size(); i++) {
                for (int j = i; j < cards.size() - 1; j++) {
                    if (check(i,j)) swap(i,j);

                }
            }
        }

        public boolean check(int i,int j){
            String[] first  = cards.get(i).split("-");
            String[] second = cards.get(j).split("-");

            return first[0].compareTo(second[0]) > 0 ? true : false;

        }

//    public boolean check(int i,int j){
//        String[] first  = cards.get(i).split("-");
//        String[] second = cards.get(j).split("-");
//
//        if (first[0].compareTo(second[0]) > 0)
//            return true;
//        else if (first[0].compareTo(second[0]) == 0)
//            return Integer.valueOf(first[1]) > Integer.valueOf(first[2]) ? true : false;
//        else return false;
//    }

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



