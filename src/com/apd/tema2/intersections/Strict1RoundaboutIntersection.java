package com.apd.tema2.intersections;

/**
 * Functionalitati specifice intersectiei simple_strict_1_car_roundabout.
 */
public class Strict1RoundaboutIntersection extends MaxXRoundaboutIntersection {

    /**
     * Caz particular al MaxXRoundaboutIntersection, cu x = 1.
     * Este permisa doar o masina pe fiecare banda
     */
    public Strict1RoundaboutIntersection() {
        super();
        x = 1;
    }
}
