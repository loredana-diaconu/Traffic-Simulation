package com.apd.tema2.ReaderHandlers;

import com.apd.tema2.Main;
import com.apd.tema2.entities.ReaderHandler;
import com.apd.tema2.factory.IntersectionFactory;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Citeste date specifice intersectiei priority_intersection.
 */
public class PriorityIntersectionReader implements ReaderHandler {
    @Override
    public void handle(String handlerType, BufferedReader br) throws IOException {
        String[] line = br.readLine().split(" ");
        // nr de masini fara prioritate
        int noLowPriority = Integer.parseInt(line[1]);
        Main.intersection = IntersectionFactory.getIntersection("priority_intersection");
        // o coada pentru masinile fara prioritate care asigura ordinea
        Main.intersection.setQueue(noLowPriority);
    }
}
