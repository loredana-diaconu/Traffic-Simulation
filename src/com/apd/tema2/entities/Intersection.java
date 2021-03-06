package com.apd.tema2.entities;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * Utilizata pentru a uniformiza tipul de date ce ajuta la definirea unei intersectii / a unui task.
 * Implementarile acesteia vor contine variabile specifice task-ului, respectiv mecanisme de sincronizare.
 */
public interface Intersection {
    void setSemaphores(int noCars);

    void setTime(int t);

    Semaphore[] getSemaphores();

    int getTime();

    void setX(int x);

    void setBarrier1();

    void setBarrier2(int maxCars);

    CyclicBarrier getBarrier1();

    CyclicBarrier getBarrier2();

    void setQueue(int noLowPriority);

    ArrayBlockingQueue<Car> getQueue();

    Object getLock();

    void enter();

    void leave();

    int getInIntersection();

    int getPassed0();

    int getPassed1();

    int getAllowed();

    void setPassed0(int value);

    void setPassed1(int value);

    void setAllowed(int value);

    void incrementPassed0();

    void incrementPassed1();

    int getX();
}
