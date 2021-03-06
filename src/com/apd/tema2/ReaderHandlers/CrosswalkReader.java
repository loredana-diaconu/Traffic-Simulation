package com.apd.tema2.ReaderHandlers;

import com.apd.tema2.Main;
import com.apd.tema2.entities.Pedestrians;
import com.apd.tema2.entities.ReaderHandler;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Citeste date specifice intersectiei crosswalk.
 */
public class CrosswalkReader implements ReaderHandler {
    @Override
    public void handle(String handlerType, BufferedReader br) throws IOException {
        String[] line = br.readLine().split(" ");
        int time = Integer.parseInt(line[0]);
        int no = Integer.parseInt(line[1]);
        Main.pedestrians = new Pedestrians(time, no);
    }
}
