package com.apd.tema2.intersections;

import com.apd.tema2.Main;

import java.util.concurrent.CyclicBarrier;

/**
 * Functionalitati specifice intersectiei simple_strict_x_roundabout.
 */
public class StrictXRoundaboutIntersection extends MaxXRoundaboutIntersection {
    CyclicBarrier barrier1;
    CyclicBarrier barrier2;

    /**
     * Creeaza bariera pentru toate masinile
     */
    public void setBarrier1() {
        barrier1 = new CyclicBarrier(Main.carsNo);
    }

    /**
     * Creeaza o bariera pentru n*x masini
     * @param n = numarul de benzi, x masini pe fiecare banda
     */
    public void setBarrier2(int n) {
        barrier2 = new CyclicBarrier(x * n);
    }

    public CyclicBarrier getBarrier1() {
        return barrier1;
    }

    public CyclicBarrier getBarrier2() {
        return barrier2;
    }
}
