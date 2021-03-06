package com.apd.tema2.intersections;

public class SimpleMaintenance extends StrictXRoundaboutIntersection {
    static final Object lock = new Object();
    int passed0 = 0;
    int passed1 = 0;
    int allowed = 0;

    public Object getLock() {
        return lock;
    }

    public int getPassed0() {
        return passed0;
    }

    public int getPassed1() {
        return  passed1;
    }

    public int getAllowed() {
        return allowed;
    }

    public void incrementPassed0() {
        passed0++;
    }

    public void incrementPassed1() {
        passed1++;
    }

    public void setPassed0(int value) {
        passed0 = value;
    }

    public void setPassed1(int value) {
        passed1 = value;
    }

    public void setAllowed(int value) {
        allowed = value;
    }
}
