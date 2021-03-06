package com.apd.tema2.IntersectionHandlers;

import com.apd.tema2.entities.Car;
import com.apd.tema2.entities.IntersectionHandler;

/**
 * Descrie modul in care se comporta o masina in intersectia simple_semaphore.
 */
public class SimpleSemaphoreHandler implements IntersectionHandler {
    @Override
    public void handle(Car car) {
        int id = car.getId();
        int time = car.getWaitingTime();
        // Masina ajunge la semafor
        System.out.println("Car " + id + " has reached the semaphore, now waiting...");
        try {
            // Masina asteapta la semafor
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Masina pleaca
        System.out.println("Car " + id + " has waited enough, now driving...");
    }
}
