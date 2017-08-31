package ru.job4j.chess;

/**.
 * Board описывает шахматную доску.
 * @author Mikhail Vlasov
 * @since 8.23.2017
 * @version 1
 */
public class Board {
    /**.
     * Constructor for Board.
     */
    public Board() {
        //Инициализируем поля как пустые.
        for (int i = 0; i < Cell.getChessBoard().length; i++) {
            if (Cell.getChessBoard()[i] == null) {
                Cell.setCell(i, new Cell());
            }
        }

        //Помечаем ячейки у края поля.
        Cell.setEdgeCells();
    }

    /**.
     * Метод должен проверить:
     * Что в заданной ячейки есть фигура. Если фигуры нет, то выкинуть исключение.
     * Если фигура есть. Проверить может ли она так двигаться. Если нет то упадет исключение.
     * Проверить что полученный путь не занят фигурами. Если занят, то выкинуть исключение.
     * Если все отлично, то записать в ячейку новое новое положение Figure figure.clone(Cell dist).
     * @param source cell where figure moving from.
     * @param dist cell where figure moving to.
     * @return boolean true if everything ok.
     * @throws ImpossibleMoveException exception.
     * @throws OccupiedWayException exception.
     * @throws FigureNotFoundException exception.
     */
    boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        if (!source.isOccupied()) {
            throw new FigureNotFoundException("В заданной ячейке нет фигуры.");
        } else {
            //Здесь может выпасть исключение ImpossibleMoveException.
            Cell[] getWay = source.getFigureByCell().way(dist);
            for (Cell cell : getWay) {
                if (cell.isOccupied()) {
                    throw new OccupiedWayException("На пути стоят фигуры.");
                }
            }
        }
        source.getFigureByCell().clone(dist);
        source.clear();
        return true;
    }
}
