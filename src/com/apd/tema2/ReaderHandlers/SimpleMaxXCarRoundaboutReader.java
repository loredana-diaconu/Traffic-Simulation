package com.apd.tema2.ReaderHandlers;

import com.apd.tema2.Main;
import com.apd.tema2.entities.ReaderHandler;
import com.apd.tema2.factory.IntersectionFactory;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Citeste date specifice intersectiei simple_max_x_car_roundabout.
 */
public class SimpleMaxXCarRoundaboutReader implements ReaderHandler {
    @Override
    public void handle(String handlerType, BufferedReader br) throws IOException {
        String[] line = br.readLine().split(" ");
        int maxCars = Integer.parseInt(line[0]);  // n
        int time = Integer.parseInt(line[1]);  // t
        int x = Integer.parseInt(line[2]);
        Main.intersection = IntersectionFactory.getIntersection("simple_max_x_car_roundabout");
        Main.intersection.setX(x);
        // Este nevoie de n semafoare care sa permita cate x masini
        Main.intersection.setSemaphores(maxCars);
        Main.intersection.setTime(time);
    }
}
