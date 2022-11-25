package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.bootcamp.Grid.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

abstract public class GameObject extends Picture {
    private Picture picture;
    private String filePath;
    private Grid grid;
    private int delay = 1 + (int) Math.random()* 4;


    public int getDelay() {
        return delay;
    }

    public GameObject(Grid grid, String filePath){
        this.filePath = filePath;
        this.grid = grid;
        picture = new Picture(randomX() + randomX(), 10, filePath);
        picture.draw();
    }

    public void moveDown() {
       int  numRandom = (int)(Math.random()*10) +5;
        if (picture.getHeight() <= grid.getHeight() - picture.getY()){
            picture.delete();
            picture.translate(0, 10);
            picture.draw();
        } else {
            picture.delete();
            picture = new Picture(randomX() + randomX(), 10, filePath);
            picture.draw();
        }

    }
    public int randomX(){
        int randomNumber = ((int) (1 + Math.random() * 14) * 80) / 2;
        return randomNumber;
    }

    public int getX(){
        return picture.getX();
    }

    public int getY(){
        return picture.getY();
    }

    public int getHeigh(){
        return picture.getHeight();
    }

    public int getWidth(){
        return picture.getWidth();
    }

    public void delete(){
        picture.delete();
    }

    public Picture getPicture(){
        return picture;
    }

    public void catchFrame(){
        picture.translate(0, 50);
    }
}
