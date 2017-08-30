package ru.job4j.chess;

/**
 * Created by hed1n on 23.08.2017.
 * Cell описывает ячейки шахматной доски.
 */
public class Cell {
    //Свойство ячейки шахматной доски: занята или пуста.
    private boolean isOccupied;
    //Массив ячеек шахматной доски.
    private static Cell[] chessBoard = new Cell[64];
    //Пока не прошли колекцию map создаём массив наименований ячеек шахматной доски для соотненсения ключ-значение.
    /*private static String[] chessBoardId = new String[]{"a1","b1","c1","d1","e1","f1","g1","h1",
                                                        "a2","b2","c2","d2","e2","f2","g2","h2",
                                                        "a3","b3","c3","d3","e3","f3","g3","h3",
                                                        "a4","b4","c4","d4","e4","f4","g4","h4",
                                                        "a5","b5","c5","d5","e5","f5","g5","h5",
                                                        "a6","b6","c6","d6","e6","f6","g6","h6",
                                                        "a7","b7","c7","d7","e7","f7","g7","h7",
                                                        "a8","b8","c8","d8","e8","f8","g8","h8"};*/
    private static int[] cellsAtTheEdge = {0, 1, 2, 3, 4, 5, 6, 7, 8, 15, 16, 23, 24, 31, 32, 39, 40, 47, 48, 55, 56, 57, 58, 59, 60, 61, 62, 63};
    //Фигура стоящая в ячейке.
    private Figure figure;

    //Флаг сигнализирующий, что ячейка граничит с краем поля.
    private boolean isCellAtTheEdge = false;

    //Пустой конструктор.
    public Cell() {
        isOccupied = false;
    }

    //Конструктор постановки фигуры в ячейку.
    public Cell(int position) {
        chessBoard[position] = this;
        isOccupied = true;
    }

    void setOccupied() {
        isOccupied = true;
    }

    void setEmpty() {
        isOccupied = false;
    }

    boolean isOccupied() {
        return isOccupied;
    }

    boolean isCellAtTheEdge() {
        return isCellAtTheEdge;
    }

    void setCellsAtTheEdge() {
        isCellAtTheEdge = true;
    }

    //Получаем ячейку по номеру.
    public static Cell getCell(int i) {
        return chessBoard[i];
    }

    //Ставим фигуру в ячейку и делаем её занятой.
    static void setCell(int position, Cell cell) {
        cell.setEmpty();
        chessBoard[position] = cell;
        //chessBoard[position].setOccupied();
    }

    //Получаем массив ячеек доски.
    static Cell[] getChessBoard() {
        return chessBoard;
    }

    //Получаем позицию на шахматной доске по ячейке.
    public int getCellPosition() {
        for(int i = 0; i < chessBoard.length; i++) {
            if(chessBoard[i] == this) {
                return i;
            }
        }
        return -1;
    }

    //Задаём фигуру стоящую в клетке.
    void setFigure(Figure figure) {
        this.figure = figure;
    }

    //Возвращаем фигуру стоящую в клетке.
    public Figure getFigureByCell() throws FigureNotFoundException {
        return this.figure;
    }

    //Очищаем ячейку, если фигура ушла.
    void clear() {
        figure = null;
        setEmpty();
    }

    //Помечаем ячейки у края поля.
    static void setEdgeCells() {
        for(Cell cell : chessBoard) {
            for(int i : cellsAtTheEdge) {
                if(cell.getCellPosition() == i) {
                    cell.setCellsAtTheEdge();
                }
            }
        }
    }
}
