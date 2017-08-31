package ru.job4j.chess;

/**.
 * class Bishop extends Figure
 * @author Mikhail Vlasov
 * @since 8.23.2017
 * @version 1
 */
public class Bishop extends Figure {
    /**.
     * Way points for bishop.
     * Или паттерн того, как может ходить слон по одномерной доске.
     */
    private int[] bishopWayPattern = {9, 7, -7, -9};

    /**.
     * Constructor for Bishop.
     * @param position of the figure.
     */
    public Bishop(Cell position) {
        super(position);
    }

    /**.
     * Getter for Cell position.
     * @return Cell position.
     */
    public Cell getPosition() {
        return super.getPostn();
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
    Cell[] way(Cell dist) throws ImpossibleMoveException {
        int destination = dist.getCellPosition();
        int startPoint = this.getPosition().getCellPosition();
        //Проверяем стоит ли заданная ячейка на пути слона.
        for (int i : bishopWayPattern) {
            int summ = startPoint + i;
            do {
                if (destination == summ) {
                    //Если стоит, то создаём мвссив ячеек стоящих на пути.
                    int j = (destination - startPoint) / i - 1;
                    Cell[] subCells = new Cell[j];
                    Cell[] cells = Cell.getChessBoard();
                    for (int k = 0; k < j; k++) {
                        subCells[k] = cells[startPoint + i * (k + 1)];
                    }
                    return subCells;
                }
                if (Cell.getCell(summ).isCellAtTheEdge()) {
                    break;
                }
                summ += i;
            } while (summ >= 0 && summ <= destination);
        }
        throw new ImpossibleMoveException("Фигура туда пойти не может.");
    }

    /**.
     * Clones figure into new cell.
     * Создаём в ячейке назначения копию фигуры.
     * @param dist destination.
     * @return Figure figure.
     */
    public Figure clone(Cell dist) {
        return new Bishop(dist);
    }
}
