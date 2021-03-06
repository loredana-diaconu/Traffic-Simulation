package com.apd.tema2.IntersectionHandlers;

import com.apd.tema2.Main;
import com.apd.tema2.entities.Car;
import com.apd.tema2.entities.IntersectionHandler;

/**
 * Descrie modul in care se comporta o masina in intersectia simple_maintenance.
 */
public class SimpleMaintenanceHandler implements IntersectionHandler {
    @Override
    public void handle(Car car) {
        int id = car.getId();
        int side = car.getStartDirection();
        System.out.println("Car " + id + " from side number " + side + " has reached the bottleneck");
        if (side == 0) {
            // Daca masina vine din sensul 0
            synchronized (Main.intersection.getLock()) {
                while (Main.intersection.getAllowed() == 1) {
                    // Daca sunt permise doar masini din sensul 1, asteapta
                    try {
                        Main.intersection.getLock().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // Daca sunt permise masini din sensul 0
                // Creste numarul de masini din sensul 0
                Main.intersection.incrementPassed0();
                System.out.println("Car " + id + " from side number " + side + " has passed the bottleneck");
                if (Main.intersection.getPassed0() == Main.intersection.getX()) {
                    // Cand se ajunge la maximul de x masini din sensul 0, vor fi acum permise doar
                    // masinile din sensul 1
                    Main.intersection.setAllowed(1);
                    // Se reseteaza numaratoarea pentru masinile din sensul 0
                    Main.intersection.setPassed0(0);
                }
                // Anunta toate masinile
                Main.intersection.getLock().notifyAll();
            }
        } else {
            synchronized (Main.intersection.getLock()) {
                // Daca masinile vin din sensul 1
                // Comportamentul este identic
                while (Main.intersection.getAllowed() == 0) {
                    try {
                        Main.intersection.getLock().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Main.intersection.incrementPassed1();
                System.out.println("Car " + id + " from side number " + side + " has passed the bottleneck");
                if (Main.intersection.getPassed1() == Main.intersection.getX()) {
                    Main.intersection.setAllowed(0);
                    Main.intersection.setPassed1(0);
                }
                Main.intersection.getLock().notifyAll();
            }
        }
    }
}
