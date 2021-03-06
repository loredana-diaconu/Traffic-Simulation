package com.apd.tema2.factory;

import com.apd.tema2.IntersectionHandlers.*;
import com.apd.tema2.entities.*;

/**
 * Clasa Factory ce returneaza implementari ale InterfaceHandler.
 */
public class IntersectionHandlerFactory {

    public static IntersectionHandler getHandler(String handlerType) {
        // simple semaphore intersection
        // max random N cars roundabout (s time to exit each of them)
        // roundabout with exactly one car from each lane simultaneously
        // roundabout with exactly X cars from each lane simultaneously
        // roundabout with at most X cars from each lane simultaneously
        // entering a road without any priority
        // crosswalk activated on at least a number of people (s time to finish all of
        // them)
        // road in maintenance - 2 ways 1 lane each, X cars at a time
        // road in maintenance - 1 way, M out of N lanes are blocked, X cars at a time
        // railroad blockage for s seconds for all the cars
        // unmarked intersection
        // cars racing
        return switch (handlerType) {
            case "simple_semaphore" -> new SimpleSemaphoreHandler();
            case "simple_n_roundabout" -> new SimpleNRoundaboutHandler();
            case "simple_strict_1_car_roundabout" -> new SimpleStrict1CarRoundaboutHandler();
            case "simple_strict_x_car_roundabout" -> new SimpleStrictXCarRoundaboutHandler();
            case "simple_max_x_car_roundabout" -> new SimpleMaxXCarRoundabout();
            case "priority_intersection" -> new PriorityIntersectionHandler();
            case "crosswalk" -> new CrosswalkHandler();
            case "simple_maintenance" -> new SimpleMaintenanceHandler();
            case "complex_maintenance" -> new ComplexMaintenanceHandler();
            case "railroad" -> new RailroadHandler();
            default -> null;
        };
    }
}
