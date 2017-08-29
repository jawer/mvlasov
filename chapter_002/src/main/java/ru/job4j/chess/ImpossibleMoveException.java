package ru.job4j.chess;

/**
 * Created by hed1n on 23.08.2017.
 * Exception, когда фигура не может стать в ячейку.
 */
public class ImpossibleMoveException extends Exception {
    public ImpossibleMoveException(String ime) {
        super(ime);
    }
}
