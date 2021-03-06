package com.apd.tema2.intersections;

import java.util.concurrent.Semaphore;

/**
 * Functionalitati specifice intersectiei simple_max_x_car_roundabout
 */
public class MaxXRoundaboutIntersection extends SimpleIntersection {

    /**
     * Creeaza n semafoare, care permit cate x masini.
     */
    @Override
    public void setSemaphores(int n) {
        semaphores = new Semaphore[n];
        for (int i = 0; i < n; i++) {
            semaphores[i] = new Semaphore(x);
        }
    }
}
