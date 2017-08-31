package ru.job4j.chess;

/**.
 * Abstract class Figure
 * @author Mikhail Vlasov
 * @since 8.23.2017
 * @version 1
 */
public abstract class Figure {
    /**.
     * Figure position using Cell object.
     */
    private final Cell position;

    /**.
     * Constructor for Figure.
     * @param position of the figure.
     */
    public Figure(Cell position) {
        //Инициализируем ячейку как занятую, когда фигура создана.
        position.setOccupied();
        //Фигура знает в какой ячейке она стоит.
        this.position = position;
        //И сообщаем ячейке какую фигуру в неёё поставили.
        position.setFigure(this);
    }

    /**.
     * Getter for Figure position variable.
     * @return Cell cell.
     */
    public Cell getPostn() {
        return position;
    }

    /**.
     * Figure way calculation.
     * dist задают ячейку куда следует пойти.
     * Если фигура может туда пойти, то вернуть массив ячеек.
     * Если фигура туда пойти не может, то выбросить исключение ImposibleMoveException.
     * @param dist where figure is going to.
     * @return Cell[] of the cells.
     * @throws ImpossibleMoveException exception.
     */
    abstract Cell[] way(Cell dist) throws ImpossibleMoveException;

    /**.
     * Clones figure into new cell.
     * Клонируем в ячейку новое положение фигуры.
     * @param dist destination.
     * @return Figure figure.
     */
    abstract Figure clone(Cell dist);
}
