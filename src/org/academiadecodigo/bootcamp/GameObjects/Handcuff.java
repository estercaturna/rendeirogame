package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.Grid.Grid;

public class Handcuff extends GameObject {
    public Handcuff(Grid grid, String filePath){
        super(grid ,filePath);
    }

    @Override
    public void moveDown(){
        super.moveDown();
    }

    @Override
    public int randomX(){
        return super.randomX();
    }

}
