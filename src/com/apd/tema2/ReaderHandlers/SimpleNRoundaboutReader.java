package com.apd.tema2.ReaderHandlers;

import com.apd.tema2.Main;
import com.apd.tema2.entities.ReaderHandler;
import com.apd.tema2.factory.IntersectionFactory;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Citeste date specifice intersectiei simple_n_roundabout.
 */
public class SimpleNRoundaboutReader implements ReaderHandler {
    @Override
    public void handle(String handlerType, BufferedReader br) throws IOException {
        String[] line = br.readLine().split(" ");
        // n si t
        int maxCars = Integer.parseInt(line[0]);
        int time = Integer.parseInt(line[1]);
        Main.intersection = IntersectionFactory.getIntersection("simple_n_roundabout");
        Main.intersection.setTime(time);
        // Este nevoie de un semafor care sa permita n masini
        Main.intersection.setSemaphores(maxCars);
    }
}
