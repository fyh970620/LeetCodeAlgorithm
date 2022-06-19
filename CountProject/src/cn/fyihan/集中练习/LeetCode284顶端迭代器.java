package com.lagou.exam;

import java.util.Iterator;

public class LeetCode284顶端迭代器  implements Iterator<Integer> {

    private Iterator<Integer> iterator;

    private Integer nextNum;

    public LeetCode284顶端迭代器(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        this.nextNum = iterator.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextNum;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer rtNum = nextNum;
        if (iterator.hasNext()) {
            nextNum = iterator.next();
        } else {
            nextNum = null;
        }
        return rtNum;
    }

    @Override
    public boolean hasNext() {
        return nextNum == null ? false : true;
    }
}
