package ru.job4j.chess;

/**
 * Created by hed1n on 23.08.2017.
 */
public abstract class Figure {
    protected final Cell position;

    public Figure(Cell position) {
        //Инициализируем ячейку как занятую, когда фигура создана.
        position.setOccupied();
        //Фигура знает в какой ячейке она стоит.
        this.position = position;
        //И сообщаем ячейке какую фигуру в неёё поставили.
        position.setFigure(this);
    }

    //dist задают ячейку куда следует пойти.
    //Если фигура может туда пойти, то вернуть массив ячеек.
    //Если фигура туда пойти не может, то выбросить исключение ImposibleMoveException.
    abstract Cell[] way(Cell dist) throws ImpossibleMoveException;

    //Клонируем в ячейку новое положение фигуры.
    abstract Figure clone(Cell dist);
}
