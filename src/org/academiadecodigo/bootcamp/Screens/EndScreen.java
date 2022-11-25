package org.academiadecodigo.bootcamp.Screens;

import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class EndScreen {
    //Properties
    private Picture backgroundImage;
    private Game game;
    private Grid grid;

    //Constructor
    public EndScreen(Game game) {
        this.game = game;
        grid = new Grid();
        backgroundImage = new Picture(grid.getPadding(), grid.getPadding(), "resources/images/game-over.jpg");
        backgroundImage.draw();
    }
}
