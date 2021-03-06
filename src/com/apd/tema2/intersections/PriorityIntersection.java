package com.apd.tema2.intersections;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Functionalitati specifice intersectiei priority_intersection.
 */
public class PriorityIntersection extends SimpleIntersection {
    public int inIntersection = 0;
    //ArrayBlockingQueue<Integer> queue;

//    public void setQueue(int noLowPriority) {
//        queue = new ArrayBlockingQueue<>(noLowPriority);
//    }

//    public ArrayBlockingQueue<Integer> getQueue(int which) {
//        return queue;
//    }

    public void enter() {
        inIntersection++;
    }

    public void leave() {
        inIntersection--;
    }

    public int getInIntersection() {
        return inIntersection;
    }
}
