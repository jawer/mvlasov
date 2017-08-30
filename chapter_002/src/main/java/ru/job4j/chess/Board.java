package ru.job4j.chess;

/**
 * Created by hed1n on 23.08.2017.
 */
public class Board {
    public Board () {
        //Создаём слона, которым ходим.
        //Figure figureBishop = new Bishop(new Cell(2));

        //Создаём слона, на которого нападаем.
        //Figure testBishop = new Bishop(new Cell(38));

        //Инициализируем остальные поля как пустые.
        for (int i = 0; i < Cell.getChessBoard().length; i++) {
            if (Cell.getChessBoard()[i] == null) {
                Cell.setCell(i, new Cell());
            }
        }

        //Помечаем ячейки у края поля.
        Cell.setEdgeCells();
    }

   /* Метод должен проверить
   - Что в заданной ячейки есть фигура. если нет. то выкинуть исключение
   - Если фигура есть. Проверить может ли она так двигаться. Если нет то упадет исключение
   - Проверить что полученный путь. не занят фигурами. Если занят выкинуть исключение
   - Если все отлично. Записать в ячейку новое новое положение Figure figure.clone(Cell dist)
   */
    boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        if(!source.isOccupied()) {
            throw new FigureNotFoundException("В заданной ячейке нет фигуры.");
        } else if(true) {
            //Здесь может выпасть исключение ImpossibleMoveException.
            Cell[] getWay = source.getFigureByCell().way(dist);
            for(Cell cell : getWay) {
                if(cell.isOccupied()) {
                    throw new OccupiedWayException("На пути стоят фигуры.");
                }
            }
        } else {
            source.getFigureByCell().clone(dist);
            source.clear();
        }
        return true;
    }

    public static void main(String[] args) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        //Создаём доску.
        Board board = new Board();
        Figure figureBishop = new Bishop(new Cell(2));
        Figure TestBishop = new Bishop(new Cell(38));
        //Делаем ход слоном.
        board.move(Cell.getCell(2), Cell.getCell(47));
    }
}
