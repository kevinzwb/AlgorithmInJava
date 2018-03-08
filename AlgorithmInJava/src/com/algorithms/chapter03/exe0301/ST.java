package com.algorithms.chapter03.exe0301;

public interface ST<Key extends Comparable<Key>,Value> {

    // 创建一张有序符号表


    //将键值对存入表中
    void put(Key key,Value val);

    //获取键key的对应值value
    Value get(Key key);

    // 从表中删去键key
    void delete(Key key);

    // 键key是否存在表中
    boolean contains(Key key);

    // 表是否为空
    boolean isEmpty();

    // 表中的键值对数量
    int size();

    // 最小的键
    Key min();

    // 最大的键
    Key max();

    // 小于等于key的最大键
    Key floor(Key key);

    // 大于等于key的最小键
    Key ceiling(Key key);

    // 小于key的键的数量
    int rank(Key key);

    // 排名为k的键
    Key select(int k);

    // 删除最小的键
    void deleteMin();

    //删除最大的键
    void deleteMax();

    // [lo.hi]之间的键的数量
    int size(Key lo,Key hi);

    // [lo.hi]之间的键,并排序
    Iterable<Key> keys(Key lo, Key hi);

    //表中所有键的集合,并排序
    Iterable<Key> keys();

}
