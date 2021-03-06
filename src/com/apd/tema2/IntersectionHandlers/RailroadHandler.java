package com.apd.tema2.IntersectionHandlers;

import com.apd.tema2.Main;
import com.apd.tema2.entities.Car;
import com.apd.tema2.entities.IntersectionHandler;

import java.util.concurrent.BrokenBarrierException;

/**
 * Descrie modul in care se comporta o masina in intersectia railroad.
 */
public class RailroadHandler implements IntersectionHandler {
    @Override
    public void handle(Car car) {
        int id = car.getId();
        int side = car.getStartDirection();
        synchronized (Main.intersection.getLock()) {
            // Masina asteapta la bariera
            System.out.println("Car " + id + " from side number " + side + " has stopped by the railroad");
            try {
                // Retine ordinea masinilor in asteptare in cozi (q0 pt id, q1 pentru sens)
                Main.intersection.getQueue().put(car);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            // Trebuie sa se stranga toate masinile la bariera
            Main.intersection.getBarrier1().await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        if (id == 0) {
            // Masina 0 anunta ca trenul a trecut
            System.out.println("The train has passed, cars can now proceed");
        }
        try {
            // Toate masinile trebuie sa stie acest lucru
            Main.intersection.getBarrier1().await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        synchronized (Main.intersection.getLock()) {
            try {
                // Sunt scoase pe rand din coada masinile
                Car c = Main.intersection.getQueue().take();
                int next = c.getId();
                int nextSide = c.getStartDirection();
                System.out.println("Car " + next + " from side number " + nextSide + " has started driving");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
