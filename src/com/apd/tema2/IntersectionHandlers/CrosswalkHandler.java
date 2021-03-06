package com.apd.tema2.IntersectionHandlers;

import com.apd.tema2.Main;
import com.apd.tema2.entities.Car;
import com.apd.tema2.entities.IntersectionHandler;

/**
 * Descrie modul in care se comporta o masina in intersectia crosswalk.
 */
public class CrosswalkHandler implements IntersectionHandler {
    @Override
    public void handle(Car car) {
        int id = car.getId();
        while (!Main.pedestrians.isFinished()) {
            // Cat timp inca mai pot sa treaca pietoni.
            if (Main.pedestrians.isPass()) {
                // Daca in acel moment trec pietoni, semaforul pentru masina se face rosu
                // (daca nu era deja)
                if (!car.prevColor.equals("red")) {
                    System.out.println("Car " + id + " has now red light");
                }
                // Retin ultima culoare a semaforului
                car.prevColor = "red";
            } else {
                // Daca nu trec pietoni, semaforul se face verde
                if (!car.prevColor.equals("green")) {
                    System.out.println("Car " + id + " has now green light");
                }
                // Retin ultima culoare
                car.prevColor = "green";
            }
        }
        if (!car.prevColor.equals("green")) {
            // La final, dupa ce au trecut toti pietonii, trebuie sa treaca toate masinile
            System.out.println("Car " + id + " has now green light");
        }
    }
}
