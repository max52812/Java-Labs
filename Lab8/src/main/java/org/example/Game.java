package org.example;

//баз класс для всех игр
public class Game {
    private String name;
    private String genre;
    private double rating;

    public Game(String name, String genre, double rating) {
        this.name = name;
        this.genre = genre;
        this.rating = rating;
    }

    //геты и сеты
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    //метод процесса игры
    public void play() {
        System.out.println("Запуск игры...");
    }

    //вывод инф об игре
    public void displayInfo() {
        System.out.println("Название: " + name + " | Жанр: " + genre + " | Рейтинг: " + rating + "/10");
    }
}