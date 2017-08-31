package ru.job4j.chess;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**.
 * Class for board and bishop testing
 * @author Mikhail Vlasov
 * @since 8.29.2017
 * @version 1
 */
public class BoardTest {
    /**.
     * Tests bishop movement.
     * @throws ImpossibleMoveException exception.
     * @throws OccupiedWayException exception.
     * @throws FigureNotFoundException exception.
     */
    @Test
    public void whenMoveBishopThenTheBishopInNewCell() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Board board = new Board();
        //Создаём слона, которым ходим.
        Figure figureBishop = new Bishop(new Cell(2));
        assertThat(board.move(Cell.getCell(2), Cell.getCell(38)), is(true));
    }

    /**.
     * Tests FigureNotFoundException.
     * @throws ImpossibleMoveException exception.
     * @throws OccupiedWayException exception.
     * @throws FigureNotFoundException exception.
     */
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

    /**.
     * Tests OccupiedWayException.
     * @throws ImpossibleMoveException exception.
     * @throws OccupiedWayException exception.
     * @throws FigureNotFoundException exception.
     */
    @Test
    public void whenTryingToMoveBishopByOccupiedWayThenException() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Board board = new Board();
        //Создаём слона, которым ходим.
        Figure figureBishop = new Bishop(new Cell(2));
        //Создаём тестового слона, через которого пытаемся перепрыгнуть.
        Figure testBishop = new Bishop(new Cell(38));
        try {
            board.move(Cell.getCell(2), Cell.getCell(47));
        } catch (Throwable throwable) {
            assertThat(throwable.getMessage(), is("На пути стоят фигуры."));
        }
    }

    /**.
     * Tests ImpossibleMoveException.
     * @throws ImpossibleMoveException exception.
     * @throws OccupiedWayException exception.
     * @throws FigureNotFoundException exception.
     */
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
