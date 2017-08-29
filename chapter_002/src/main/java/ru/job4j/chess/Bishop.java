package ru.job4j.chess;

/**
 * Created by hed1n on 23.08.2017.
 */
public class Bishop extends Figure {
    private int[] bishopWayPattern = {9, 7, -7, -9};

    public Bishop(Cell position) {
        super(position);
    }

    public Cell getPosition() {
        return position;
    }

    //dist задают ячейку куда следует пойти.
    //Если фигура может туда пойти, то вернуть массив ячеек.
    //Если фигура туда пойти не может, то выбросить исключение ImpossibleMoveException.
    Cell[] way(Cell dist) throws ImpossibleMoveException {
        int destination = dist.getCellPosition();
        int startPoint = this.getPosition().getCellPosition();
        //Проверяем стоит ли заданная ячейка на пути слона.
        for (int i : bishopWayPattern) {
            if ((destination - startPoint)% i == 0) {
                //Если стоит, то создаём мвссив ячеек стоящих на пути.
                int j = (destination - startPoint)/i - 1;
                Cell[] subCells = new Cell[j];
                Cell[] cells = Cell.getChessBoard();
                for (int k = 0; k < j; k++) {
                    subCells[k] = cells[startPoint + i * (k + 1)];
                }
                return subCells;
            }
        }
        throw new ImpossibleMoveException("Фигура туда пойти не может.");
    }

    //Создаём в ячейке назначения копию фигуры.
    public Figure clone(Cell dist) {
        return new Bishop(dist);
    }
}
