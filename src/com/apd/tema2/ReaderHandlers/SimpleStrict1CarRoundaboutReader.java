package com.apd.tema2.ReaderHandlers;

import com.apd.tema2.Main;
import com.apd.tema2.entities.ReaderHandler;
import com.apd.tema2.factory.IntersectionFactory;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Citeste date specifice intersectiei simple_strict_1_car_roundabout.
 */
public class SimpleStrict1CarRoundaboutReader implements ReaderHandler {
    @Override
    public void handle(String handlerType, BufferedReader br) throws IOException {
        String[] line = br.readLine().split(" ");
        int maxCars = Integer.parseInt(line[0]);  // n
        int time = Integer.parseInt(line[1]);  // t
        Main.intersection = IntersectionFactory.getIntersection("simple_strict_1_car_roundabout");
        Main.intersection.setTime(time);
        // Este nevoie de n semafoare care sa permita cate o masina
        Main.intersection.setSemaphores(maxCars);
    }
}
