package ru.job4j.chess;

/**
 * Created by hed1n on 23.08.2017.
 */
public class Board {
    //Массив фигур на доске.
    //private static Figure[] figures = new Figure[2];
    //private int index = 0;

    //Добавляем фигуру.
    /*public void addFigure(Figure figure) {
        figures[index++] = figure;
    }*/

    //Берём фигуру.
    /*public Figure getFigure(int position) {
        return figures[position];
    }*/

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

    public static void main(String[] args) {
        //Board board = new Board();
        //Figure firstBishop = new Bishop(new Cell());
        //board.addFigure(firstBishop);

        //Создаём доску.
        Board board = new Board();

        //Создаём слона, которым ходим.
        //board.addFigure(new Bishop(new Cell(2)));
        //figures[0] = new Bishop(new Cell(2));
        Figure figureBishop = new Bishop(new Cell(2));

        //Создаём слона, на которого нападаем.
        //board.addFigure(new Bishop(new Cell(38)));
        //figures[1] = new Bishop(new Cell(38));
        Figure testBishop = new Bishop(new Cell(38));

        //Инициализируем остальные поля как пустые.
        for (int i = 0; i < Cell.getChessBoard().length; i++) {
            if (Cell.getChessBoard()[i] == null) {
                Cell.setCell(i, new Cell());
            }
        }

        //Делаем ход слоном.
        //Figure figureBishop = board.getFigure(0);
        do {

        } while (true);
    }
}
