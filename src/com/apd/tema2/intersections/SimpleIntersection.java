package com.apd.tema2.intersections;

import com.apd.tema2.entities.Car;
import com.apd.tema2.entities.Intersection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * Descrie un model de intersectie. Variabilele si mecanismele de sincronizare
 * vor fi implementate particular fiecarui task.
 */
public class SimpleIntersection implements Intersection {
    int x;
    int time;
    Semaphore []semaphores;
    static final Object lock = new Object();
    ArrayBlockingQueue<Car> queue;

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setSemaphores(int noCars) {
    }

    @Override
    public void setTime(int t) {
        time = t;
    }

    @Override
    public Semaphore[] getSemaphores() {
        return semaphores;
    }

    @Override
    public int getTime() {
        return time;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setBarrier1() {

    }

    @Override
    public void setBarrier2(int maxCars) {

    }

    @Override
    public CyclicBarrier getBarrier1() {
        return null;
    }

    @Override
    public CyclicBarrier getBarrier2() {
        return null;
    }

    @Override
    public void setQueue(int capacity) {
        queue = new ArrayBlockingQueue<>(capacity);
    }

    @Override
    public ArrayBlockingQueue<Car> getQueue() {
        return queue;
    }

    @Override
    public Object getLock() {
        return lock;
    }

    @Override
    public void enter() {

    }

    @Override
    public void leave() {

    }

    @Override
    public int getInIntersection() {
        return 0;
    }

    @Override
    public int getPassed0() {
        return 0;
    }

    @Override
    public int getPassed1() {
        return 0;
    }

    @Override
    public int getAllowed() {
        return 0;
    }

    @Override
    public void setPassed0(int value) {

    }

    @Override
    public void setPassed1(int value) {

    }

    @Override
    public void setAllowed(int value) {

    }

    @Override
    public void incrementPassed0() {

    }

    @Override
    public void incrementPassed1() {

    }
}
