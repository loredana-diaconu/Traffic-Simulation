package com.apd.tema2.ReaderHandlers;

import com.apd.tema2.Main;
import com.apd.tema2.entities.ReaderHandler;
import com.apd.tema2.factory.IntersectionFactory;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Citeste date specifice intersectiei railroad.
 */
public class RailroadReader implements ReaderHandler {
    @Override
    public void handle(String handlerType, BufferedReader br) throws IOException {
        Main.intersection = IntersectionFactory.getIntersection("railroad");
        // Coada pentru a pastra ordinea masinilor
        Main.intersection.setQueue(Main.carsNo);
        // Bariera pentru toate masinile
        Main.intersection.setBarrier1();
    }
}
