package org.academiadecodigo.bootcamp.Grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    private Rectangle rectangle;
    private static int cellsize = 80;
    private static int padding = 10;
    private static int width = 1280;
    private static int height = 720;
    private int cols = width / cellsize;
    private int rows = height / cellsize;
    //private int cols = x * cellsize;
    //private int rows = y * cellsize;

    public Grid(){
        rectangle = new Rectangle(padding, padding, width, height);
        rectangle.setColor(Color.BLACK);
        rectangle.draw();
    }

    public static int getCellSize() {
        return cellsize;
    }

    public static int getPadding() {
        return padding;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    /*public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }*/

    public GridPosition makeGridPosition(int col, int row) {
        return new GridPosition(col, row, this);
    }

}
