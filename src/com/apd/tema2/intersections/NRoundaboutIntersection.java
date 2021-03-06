package com.apd.tema2.intersections;

import java.util.concurrent.Semaphore;

/**
 * Functionalitati specifice intersectiei simple_n_roundabout.
 */
public class NRoundaboutIntersection extends Strict1RoundaboutIntersection {

    /**
     * Caz particular al functiei din Strict1RoundaboutIntersection.
     * Este nevoie de un singur semafor, care sa permita n masini.
     */
    public void setSemaphores(int n) {
        semaphores = new Semaphore[1];
        semaphores[0] = new Semaphore(n);
    }
}
