package com.algorithms.chapter01.exe0104;

import java.util.Arrays;

public class exe1411 {
}

class StaticSETofInts{
    private int[] a;
    public StaticSETofInts(int[] keys){
        a = new int[keys.length];
        for (int i = 0; i < keys.length; i++){
            a[i] = keys[i];
        }
        Arrays.sort(a);
    }

    public boolean cocntains(int key){
        return rank(key) != -1;
    }

    public int rank(int key){
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    public int howMany(int key){
        int position = rank(key);
        if (position > 0){
            int count = 1;
            int index = 1;
            while (a[position + index] == a[position]) count++;
            index = 1;
            while (a[position - index] == a[position]) count++;
            return count;
        }
        return position;
    }
}
