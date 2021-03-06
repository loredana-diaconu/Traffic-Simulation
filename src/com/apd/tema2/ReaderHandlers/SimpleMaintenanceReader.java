package com.apd.tema2.ReaderHandlers;

import com.apd.tema2.Main;
import com.apd.tema2.entities.ReaderHandler;
import com.apd.tema2.factory.IntersectionFactory;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Citeste date specifice intersectiei simple_maintenance.
 */
public class SimpleMaintenanceReader implements ReaderHandler {
    @Override
    public void handle(String handlerType, BufferedReader br) throws IOException {
        String[] line = br.readLine().split(" ");
        int x = Integer.parseInt(line[0]);
        Main.intersection = IntersectionFactory.getIntersection("simple_maintenance");
        Main.intersection.setX(x);
        // Bariera pentru x masini (nu este nevoie sa fie cate x pt fiecare banda, cazurile sunt
        // tratate separat)
        Main.intersection.setBarrier2(1);
    }
}
