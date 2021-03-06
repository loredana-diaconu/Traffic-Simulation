package com.apd.tema2.IntersectionHandlers;

import com.apd.tema2.Main;
import com.apd.tema2.entities.Car;
import com.apd.tema2.entities.IntersectionHandler;

import static java.lang.Thread.sleep;

/**
 * Descrie modul in care se comporta o masina in intersectia simple_max_x_car_roundabout.
 */
public class SimpleMaxXCarRoundabout implements IntersectionHandler {
    @Override
    public void handle(Car car) {
        // Masina ajunge la intersectie dupa un timp predefinit
        try {
            sleep(car.getWaitingTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int id = car.getId();
        int lane = car.getStartDirection();
        System.out.println("Car " + id + " has reached the roundabout from lane " + lane);
        try {
            // Este folosit cate un semafor pentru fiecare banda, care permite maxim x masini pe banda
            Main.intersection.getSemaphores()[lane].acquire();
            System.out.println("Car " + id + " has entered the roundabout from lane " + lane);
            // Masina sta un timp in intersectie
            Thread.sleep(Main.intersection.getTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Masina paraseste intersectia
        System.out.println("Car " + id + " has exited the roundabout after " + Main.intersection.getTime() / 1000 + " seconds");
        Main.intersection.getSemaphores()[lane].release();
    }
}
