package org.academiadecodigo.bootcamp.Grid;

public class GridPosition {
    private int col;
    private int row;
    private Grid grid;

    public GridPosition(int col, int row, Grid grid) {
        this.col = col;
        this.row = row;
        this.grid = grid;
    }

    public void setPos(int col, int row){
        this.col = col;
        this.row = row;
    }

    public int getCol(){
        return col;
    }

    public int getRow(){
        return row;
    }
}
