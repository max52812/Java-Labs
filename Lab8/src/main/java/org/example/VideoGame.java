package org.example;

// комп игра наследует класс Game
public class VideoGame extends Game {
    // Уникальное поле: платформа (PC, PlayStation и т.д.)
    private String platform;

    public VideoGame(String name, String genre, double rating, String platform) {
        // передаем общ параметры родителю
        super(name, genre, rating);
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    //переопр метод родителя
    @Override
    public void play() {
        System.out.println("Играем на компьютере (платформа: " + platform + ")");
    }

    //метод видеоигры-сохр
    public void saveGame() {
        System.out.println("Игра \"" + getName() + "\" сохранена на диск/облако!");
    }
}