package com.apd.tema2.ReaderHandlers;

import com.apd.tema2.Main;
import com.apd.tema2.entities.ReaderHandler;
import com.apd.tema2.factory.IntersectionFactory;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Citeste date specifice intersectiei simple_strict_x_car_roundabout.
 */
public class SimpleStrictXCarRoundaboutReader implements ReaderHandler {
    @Override
    public void handle(String handlerType, BufferedReader br) throws IOException {
        String[] line = br.readLine().split(" ");
        int noLanes = Integer.parseInt(line[0]);  // nr benzi
        int time = Integer.parseInt(line[1]);  // t
        int x = Integer.parseInt(line[2]);
        Main.intersection = IntersectionFactory.getIntersection("simple_strict_x_car_roundabout");
        Main.intersection.setX(x);
        // Este nevoie de n semafoare care sa permita cate x masini
        Main.intersection.setSemaphores(noLanes);
        Main.intersection.setTime(time);
        // Este nevoie de o bariera pentru toate masinile
        Main.intersection.setBarrier1();
        // Este nevoie de o bariera care sa permita n*x masini intr-un chunk (cate x masini pe fiecare banda)
        Main.intersection.setBarrier2(noLanes);
    }
}
