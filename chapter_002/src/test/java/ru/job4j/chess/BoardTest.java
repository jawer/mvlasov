package ru.job4j.chess;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by hed1n on 29.08.2017.
 */
public class BoardTest {
    @Test
    public void whenMoveBishopThenTheBishopInNewCell() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Board board = new Board();
        //Создаём слона, которым ходим.
        Figure figureBishop = new Bishop(new Cell(2));
        assertThat(board.move(Cell.getCell(2), Cell.getCell(38)), is(true));
    }

    @Test
    public void whenTryingToMoveFromEmptyCellThenException() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Board board = new Board();
        //Создаём слона, которым ходим.
        Figure figureBishop = new Bishop(new Cell(2));
        try {
            board.move(Cell.getCell(1), Cell.getCell(38));
        } catch (Throwable throwable) {
            assertThat(throwable.getMessage(), is("В заданной ячейке нет фигуры."));
        }
    }

    @Test
    public void whenTryingToMoveBishopByOccupiedWayThenException() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Board board = new Board();
        //Создаём слона, которым ходим.
        Figure figureBishop = new Bishop(new Cell(2));
        //Создаём тестового слона, через которого пытаемся перепрыгнуть.
        Figure TestBishop = new Bishop(new Cell(38));
        try {
            board.move(Cell.getCell(2), Cell.getCell(47));
        } catch (Throwable throwable) {
            assertThat(throwable.getMessage(), is("На пути стоят фигуры."));
        }
    }

    @Test
    public void whenTryingToMoveBishopToIncorrectCellThenException() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Board board = new Board();
        //Создаём слона, которым ходим.
        Figure figureBishop = new Bishop(new Cell(2));
        try {
            board.move(Cell.getCell(2), Cell.getCell(37));
        } catch (Throwable throwable) {
            assertThat(throwable.getMessage(), is("Фигура туда пойти не может."));
        }
    }
}
