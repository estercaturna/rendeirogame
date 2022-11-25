package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.Rendeiro;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardListener implements KeyboardHandler {

    private Rendeiro rendeiro;
    private Game game;
    private int gamesPlayed = 0;

    public KeyboardListener(Game game){
        this.game = game;
        this.init();
    }

    public void init(){
        // Instantiating a new keyboard instance
        Keyboard keyboard = new Keyboard(this);

        // Assigning Q key to the QUIT GAME action
        KeyboardEvent qKey = new KeyboardEvent();
        qKey.setKey(KeyboardEvent.KEY_Q);
        qKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(qKey);

        // Assigning R key to the REPEAT PLAYING action
        KeyboardEvent pKey = new KeyboardEvent();
        pKey.setKey(KeyboardEvent.KEY_P);
        pKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(pKey);

        // Assigning S key to the START PLAYING action
        KeyboardEvent sKey = new KeyboardEvent();
        sKey.setKey(KeyboardEvent.KEY_S);
        sKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(sKey);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        // Condition to quit the game when the key is pressed
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_Q) {
            if(game.hasEnded()){
                System.out.println("Bye bye! It was a great game! 😎");
                System.exit(0);
            }
        }

        // Plays the game again if inside the EndScreen
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_P) {
            if(!game.isStarted() && gamesPlayed <= 1){
                game.start();
                gamesPlayed++;
            }
        }

        // Plays the game again if inside the EndScreen
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_S) {
            if(!game.isStarted()){
                game.start();
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        // Method not necessary to be implemented
    }
}
