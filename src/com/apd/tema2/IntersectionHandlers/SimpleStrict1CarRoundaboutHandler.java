package com.apd.tema2.IntersectionHandlers;

import com.apd.tema2.Main;
import com.apd.tema2.entities.Car;
import com.apd.tema2.entities.IntersectionHandler;

/**
 * Descrie modul in care se comporta o masina in intersectia simple_strict_1_car_roundabout.
 */
public class SimpleStrict1CarRoundaboutHandler implements IntersectionHandler {
    @Override
    public void handle(Car car) {
        int id = car.getId();
        int lane = car.getStartDirection();
        // Masina ajunge la intersectie
        System.out.println("Car " + id + " has reached the roundabout");
        try {
            // Este utilizat cate un semafor pentru fiecare banda.
            // Este permisa maxim o masina pe fiecare.
            Main.intersection.getSemaphores()[lane].acquire();
            System.out.println("Car " + id + " has entered the roundabout from lane " + lane);
            // Masina sta un timp in intersectie
            Thread.sleep(Main.intersection.getTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Masina iese din intersectie si elibereaza semaforul corespunzator benzii.
        System.out.println("Car " + id + " has exited the roundabout after " + Main.intersection.getTime() / 1000 + " seconds");
        Main.intersection.getSemaphores()[lane].release();
    }
}
