package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.Grid.Grid;
import org.academiadecodigo.bootcamp.GameObjects.Frame;

public class GameObjectFactory {
    // SPAWNING CHANCES:
    // - Handcuffs: 20%
    // - Frame: 80%

    private Grid grid;
    private GameObject gameObject;

    public GameObject getNewObject (Grid grid) {
        int prob = (int)(Math.random() * 10);
        if(prob > 5) {
            System.out.println("Handcuff created");
            gameObject =  new Handcuff(grid, GameObjectType.HANDCUFFS.getFilePath());
        } else {
            switch (GameObjectType.random()) {
                case MONALISA:
                    System.out.println("Mona Lisa creeated");
                    gameObject = new Frame(grid, GameObjectType.MONALISA.getFilePath());
                    break;
                case SCREAM:
                    System.out.println("Scream created");
                    gameObject = new Frame(grid, GameObjectType.SCREAM.getFilePath());
                    break;
                case DALI:
                    System.out.println("Dali created");
                    gameObject = new Frame(grid, GameObjectType.DALI.getFilePath());
                    break;
                case STARRY_NIGHT:
                    System.out.println("Starry Night created");
                    gameObject = new Frame(grid, GameObjectType.STARRY_NIGHT.getFilePath());
                    break;
                default:
                    System.out.println("Mona Lisa created");
                    gameObject = new Frame(grid, GameObjectType.MONALISA.getFilePath());
                    break;

            }
        }
        return gameObject;
    }


}

