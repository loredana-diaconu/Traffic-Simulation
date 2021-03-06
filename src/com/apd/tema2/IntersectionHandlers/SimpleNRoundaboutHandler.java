package com.apd.tema2.IntersectionHandlers;

import com.apd.tema2.Main;
import com.apd.tema2.entities.Car;
import com.apd.tema2.entities.IntersectionHandler;

/**
 * Descrie modul in care se comporta o masina in intersectia simple_n_roundabout.
 */
public class SimpleNRoundaboutHandler implements IntersectionHandler {
    @Override
    public void handle(Car car) {
        int id = car.getId();
        // Masina a ajuns la intersectie
        System.out.println("Car " + id + " has reached the roundabout, now waiting...");
        try {
            // Este utilizat un singur semafor (0), care permite maxim n masini
            Main.intersection.getSemaphores()[0].acquire();
            System.out.println("Car " + id + " has entered the roundabout");
            // Masina sta un timp t in intersectie
            Thread.sleep(Main.intersection.getTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Masina iese din intersectie
        System.out.println("Car " + id + " has exited the roundabout after " + Main.intersection.getTime() / 1000 + " seconds");
        Main.intersection.getSemaphores()[0].release();
    }
}
