package org.academiadecodigo.bootcamp.Screens;

import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class InitialScreen {
    //Properties
    private Picture backgroundImage;
    private Grid grid;
    private Game game;

    //Constructor
    public InitialScreen(Game game) {
        this.game = game;
        grid = new Grid();
        backgroundImage = new Picture(grid.getPadding(), grid.getPadding(), "resources/images/main-menu.jpg");
        backgroundImage.draw();
    }
}
