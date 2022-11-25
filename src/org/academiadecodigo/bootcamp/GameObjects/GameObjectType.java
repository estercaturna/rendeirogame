package org.academiadecodigo.bootcamp.GameObjects;

public enum GameObjectType {
    HANDCUFFS("resources/images/handcuffs.png"),
    MONALISA("resources/images/mona-lisa.png"),
    SCREAM("resources/images/scream.png"),
    DALI("resources/images/dali.png"),
    STARRY_NIGHT("resources/images/starry-night.png");

    private double speed;
    private String filePath;

    GameObjectType(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public static GameObjectType random () {
        return GameObjectType.values()[(int) (Math.random() * (GameObjectType.values().length - 1))];
    }
}
