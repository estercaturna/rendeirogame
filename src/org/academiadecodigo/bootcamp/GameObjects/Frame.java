package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.GameObjects.GameObject;
import org.academiadecodigo.bootcamp.GameObjects.GameObjectType;
import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.bootcamp.Grid.GridPosition;

public class Frame extends GameObject {

    public Frame(Grid grid, String filePath){
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
