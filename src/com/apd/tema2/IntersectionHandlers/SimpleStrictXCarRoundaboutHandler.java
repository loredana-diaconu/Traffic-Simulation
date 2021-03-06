package com.apd.tema2.IntersectionHandlers;

import com.apd.tema2.Main;
import com.apd.tema2.entities.Car;
import com.apd.tema2.entities.IntersectionHandler;

import java.util.concurrent.BrokenBarrierException;

/**
 * Descrie modul in care se comporta o masina in intersectia simple_strict_x_car_roundabout.
 */
public class SimpleStrictXCarRoundaboutHandler implements IntersectionHandler {
    @Override
    public void handle(Car car) {
        int id = car.getId();
        int lane = car.getStartDirection();
        // Masina asteapta sa intre in intersectie
        System.out.println("Car " + id + " has reached the roundabout, now waiting...");
        try {
            // Trebuie sa ajunga toate masinile
            Main.intersection.getBarrier1().await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        try {
            // Cate un semafor pentru fiecare banda, maxim x masini pot fi selectate sa intre
            Main.intersection.getSemaphores()[lane].acquire();
            System.out.println("Car " + id + " was selected to enter the roundabout from lane " + lane);
            // Bariera prin care ne asiguram ca intra fix x masini pe fiecare banda
            // In total noLanes * x masini
            Main.intersection.getBarrier2().await();
            System.out.println("Car " + id + " has entered the roundabout from lane " + lane);
            // Masina sta un timp in intersectie
            Thread.sleep(Main.intersection.getTime());
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        try {
            // Ne asiguram ca au intrat toate cele x masini pe fiecare banda
            Main.intersection.getBarrier2().await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        // Masina iese din intersectie
        System.out.println("Car " + id + " has exited the roundabout after " + Main.intersection.getTime() / 1000 + " seconds");
        try {
            // Ne asiguram ca au iesit toate
            Main.intersection.getBarrier2().await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        Main.intersection.getSemaphores()[lane].release();
    }
}
