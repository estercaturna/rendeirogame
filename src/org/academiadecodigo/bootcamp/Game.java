package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.GameObjects.Frame;
import org.academiadecodigo.bootcamp.GameObjects.GameObject;
import org.academiadecodigo.bootcamp.GameObjects.GameObjectFactory;
import org.academiadecodigo.bootcamp.GameObjects.Handcuff;
import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.bootcamp.Screens.EndScreen;
import org.academiadecodigo.bootcamp.Screens.GameScreen;
import org.academiadecodigo.bootcamp.Screens.InitialScreen;

public class Game {
    private Grid grid;
    private Rendeiro rendeiro;
    private KeyboardListener keyboardListener;
    private InitialScreen initialScreen;
    private GameScreen gameScreen;
    private EndScreen endScreen;
    private GameObjectFactory objectFactory;
    private GameObject gameObject;
    private GameObject[] objs;
    private Handcuff handcuff;
    private Game game;
    private int delay;
    private boolean gameScreenActive = false;
    private boolean endScreenActive = false;

    public Game(int numberOfObjects) {
        this.grid = new Grid();
        this.keyboardListener = new KeyboardListener(this);
        this.objectFactory = new GameObjectFactory();
        objs = new GameObject[numberOfObjects];
        for (int i = 0; i < objs.length; i++) {
            this.objs[i] = objectFactory.getNewObject(grid);
        }
        changeToInitialScreen();
    }

    public void start() {
        gameScreenActive = true;
        System.out.println("Starting the game");
    }

    public void changeToInitialScreen() {
        initialScreen = new InitialScreen(this);
    }

    public void changeToGameScreen() {
        gameScreen = new GameScreen(this);
        rendeiro = new Rendeiro(grid);
        rendeiro.moveRight();
        moveGameObject();
    }

    public void setGameScreenActive(boolean isAtive){
        gameScreenActive = isAtive;
    }

    public void moveGameObject() {
        try {
            while (gameScreenActive == true) {
                Thread.sleep(50);
                for (int i = 0; i < objs.length; i++) {
                    objs[i].moveDown();
                    checkCollision(rendeiro);
                }
            }
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
    }

    public void checkCollision(Rendeiro rendeiro) {
        for (int i = 0; i < objs.length; i++) {
            if (objs[i].getX() < rendeiro.getX() + rendeiro.getWidth() &&
                    objs[i].getX() + objs[i].getWidth() > rendeiro.getX() &&
                    objs[i].getY() < rendeiro.getY() + rendeiro.getHeigh() &&
                    objs[i].getHeigh() + objs[i].getY() > rendeiro.getY()) {
                objs[i].delete();
                if(objs[i] instanceof Frame){
                    rendeiro.catchFrame(objs[i]);
                }
                if (objs[i] instanceof Handcuff) {
                    for (int j = 0; j < objs.length; j++) {
                        objs[j].delete();
                    }
                    changeToEndScreen();
                }
            }
        }
    }

    public void changeToEndScreen () {
        gameScreenActive = false;
        endScreenActive = true;
        rendeiro.stopMoving();
        endScreen = new EndScreen(this);
    }

    public boolean isStarted () {
        return gameScreenActive == true;
    }

    public boolean hasEnded () {
        return endScreenActive == true;
    }
}

