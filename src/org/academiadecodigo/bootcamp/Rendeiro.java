package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.GameObjects.GameObject;
import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Rendeiro implements KeyboardHandler {
    private Game game;
    private Rendeiro rendeiro;
    private Position position;
    private Picture rendeiroPicture;
    private Picture framePicture;
    private Grid grid;
    private boolean canMove;

    public Rendeiro(Grid grid){
        this.grid = grid;
        this.position = new Position((grid.getWidth() / 2) - 60, grid.getHeight() - 160);
        this.rendeiroPicture = new Picture(position.getX(), position.getY(),"resources/images/joao.png");
        enableController();
        moveLeft();
    }

    // Moving RIGHT
    public void moveRight(){
        if((rendeiroPicture.getX() + rendeiroPicture.getWidth() + 20 <= grid.getWidth()) && canMove){
            rendeiroPicture.delete();
            rendeiroPicture.translate(30,0);
            rendeiroPicture.draw();
        }
        canMove = true;
    }

    public void moveLeft(){
        if((rendeiroPicture.getX() - 40 >= 0) && canMove){
            rendeiroPicture.delete();
            rendeiroPicture.translate(-30,0);
            rendeiroPicture.draw();
        }
        canMove = true;
    }
    //When collid with handcuff
    public void stopMoving(){
        canMove = false;
    }

    public void catchFrame(GameObject frame){
        frame.catchFrame();
    }

    private void enableController(){
        // Instantiating a new keyboard instance
        Keyboard keyboard = new Keyboard(this);

        // Assigning Right Arrow key to the RIGHT movement
        KeyboardEvent rightArrow = new KeyboardEvent();
        rightArrow.setKey(KeyboardEvent.KEY_RIGHT);
        rightArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(rightArrow);

        // Assigning Left Arrow key to the LEFT movement
        KeyboardEvent leftArrow = new KeyboardEvent();
        leftArrow.setKey(KeyboardEvent.KEY_LEFT);
        leftArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(leftArrow);

        keyboard.addEventListener(rightArrow);
        keyboard.addEventListener(leftArrow);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        // Moves Rendeiro to the Right
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            if (canMove){
                this.moveRight();
            }

        }
        // Moves Rendeiro to the Left
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
            if(canMove) {
                this.moveLeft();
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
    public int getX(){
        return rendeiroPicture.getX();
    }
    public int getY(){
        return rendeiroPicture.getY();
    }
    public int getHeigh(){
        return rendeiroPicture.getHeight();
    }
    public int getWidth(){
        return rendeiroPicture.getWidth();
    }
}
