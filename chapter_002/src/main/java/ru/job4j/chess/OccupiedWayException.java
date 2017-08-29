package ru.job4j.chess;

/**
 * Created by hed1n on 23.08.2017.
 */
public class OccupiedWayException extends Exception {
    public OccupiedWayException(String owe) {
        super(owe);
    }
}
