package com.apd.tema2.intersections;

import com.apd.tema2.entities.Intersection;

import java.util.concurrent.Semaphore;

public class RoundaboutIntersection implements Intersection {
    public Semaphore semaphore;
    public int time;

    public void setSemaphore(int noCars) {
        semaphore = new Semaphore(noCars);
    }

    public void setTime(int t) {
        time = t;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public int getTime() {
        return time;
    }
}
