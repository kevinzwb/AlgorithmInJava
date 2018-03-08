package com.algorithms.chapter01.exe0105;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class HashLFUCache {

//    private static final int initCap = CacheConfig.LFU_CACHE_SIZE;
    private static final int initCap = 0;
    private ConcurrentHashMap<Integer,LinkedHashSet<String>> frequencyMap = new ConcurrentHashMap<>(); // k:num,v:timeLinkedHashSet
    private ConcurrentHashMap<String,Item> valueMap = new ConcurrentHashMap<>(); // k:key,v:int[value,Item]

    public Item get(String key) {
        if(!valueMap.containsKey(key)){
            return null;
        }
        Item item = valueMap.get(key);
        updateFrequencyMap(key,item.getFrequency());
        item.setFrequency(item.getFrequency()+1);
        return item;
    }

    public void put(Item item) {
        String key = item.getKey();

        if(valueMap.size()==initCap){
            // System.out.println("remove!");
            removeFromCache();
        }
        item.setFrequency(1);
        valueMap.put(key,item);
        addFrequencyMap(key);
    }


    private void updateFrequencyMap(String key, int num){
        LinkedHashSet<String> timeLinkedList =  frequencyMap.get(num);
        timeLinkedList.remove(key);
        if(timeLinkedList.size()==0){
            frequencyMap.remove(num);
        }
        if(!frequencyMap.containsKey(num+1)){
            timeLinkedList = new LinkedHashSet<>();
            frequencyMap.put(num+1,timeLinkedList);
        }else{
            timeLinkedList = frequencyMap.get(num+1);
        }
        timeLinkedList.add(key);
    }

    //新的key被put后，将valueHashMap中的num设成1，并在numTreeMap.get(1)中放入该key
    private void addFrequencyMap(String key){
        LinkedHashSet<String> timeLinkedList;
        if(!frequencyMap.containsKey(1)){
            timeLinkedList = new LinkedHashSet<>();
            frequencyMap.put(1,timeLinkedList);
        }else{
            timeLinkedList = frequencyMap.get(1);
        }
        timeLinkedList.add(key);
    }


    private void removeFromCache(){
        int entryKey;
        if (!frequencyMap.containsKey(1)){ entryKey = findMimKey(frequencyMap.keySet()); }
        else{ entryKey = 1; }

        LinkedHashSet<String> timeLinkedList = frequencyMap.get(entryKey);
        String key = timeLinkedList.iterator().next();
        timeLinkedList.remove(key);
        valueMap.remove(key);
        if(timeLinkedList.size()==0){
            frequencyMap.remove(entryKey);
        }
    }

    private int findMimKey(Set<Integer> keySet) {
        Object[] keys = keySet.toArray();
        Arrays.sort(keys);
        return (int) keys[0];
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(11, 33);
//        map.put(1, 33);
        map.put(4, 42);
        map.put(24, 42);
        map.put(13, 33);
        map.put(14, 42);
        map.put(63, 33);
        map.put(54, 42);
        map.put(123, 33);
        map.put(44, 42);
        map.put(15, 3);
        Set<Integer> key = map.keySet();
        Object[] keys = key.toArray();
        Arrays.sort(keys);
        int entry = (int) keys[0];
        System.out.println(entry);

    }
}

class Item {

    private String key;
    private Object data;
    private long lastTime;
    private int frequency;

    public Item() {
        super();
    }

    public Item(String key, Object data) {
        super();
        this.key = key;
        this.data = data;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public long getLastTime() {
        return lastTime;
    }

    public void setLastTime(long lastTime) {
        this.lastTime = lastTime;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }


}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */