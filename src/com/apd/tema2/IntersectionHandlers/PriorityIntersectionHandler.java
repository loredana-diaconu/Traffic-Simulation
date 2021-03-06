package com.apd.tema2.IntersectionHandlers;

import com.apd.tema2.Main;
import com.apd.tema2.entities.Car;
import com.apd.tema2.entities.IntersectionHandler;
import com.apd.tema2.utils.Constants;

import static java.lang.Thread.sleep;

/**
 * Descrie modul in care se comporta o masina in intersectia priority_intersection.
 */
public class PriorityIntersectionHandler implements IntersectionHandler {
    @Override
    public void handle(Car car) {
        try {
            // Masinii ii ia un timp sa ajunga la intersectie
            sleep(car.getWaitingTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int id = car.getId();
        if (car.getPriority() > 1) {
            // Daca masina are prioritate
            synchronized (Main.intersection.getLock()) {
                // Creste numarul de masini din intersectie
                Main.intersection.enter();
            }
            System.out.println("Car " + id + " with high priority has entered the intersection");
            try {
                // Masinilor cu prioritate le ia un timp sa treaca prin intersectie
                sleep(Constants.PRIORITY_INTERSECTION_PASSING);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Masina iese din intersectie
            System.out.println("Car " + id + " with high priority has exited the intersection");
            synchronized (Main.intersection.getLock()) {
                // Scade numarul de masini din intersectie. Sunt anuntate toate masinile.
                Main.intersection.leave();
                Main.intersection.getLock().notifyAll();
            }
        } else {
            // Daca masina nu are prioritate, asteapta
            System.out.println("Car " + id + " with low priority is trying to enter the intersection...");
            try {
                // Este folosit un singur queue (nr 0) pentru a retine ordinea masinilor care asteapta
                // Masina sta la coada
                Main.intersection.getQueue().put(car);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Main.intersection.getLock()) {
                while (Main.intersection.getInIntersection() != 0) {
                    // Cat timp intersectia nu este goala, masina asteapta
                    try {
                        Main.intersection.getLock().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    // Odata ce intersectia este libera, este scoasa cate o masina din coada
                    int next = Main.intersection.getQueue().take().getId();
                    System.out.println("Car " + next + " with low priority has entered the intersection");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
