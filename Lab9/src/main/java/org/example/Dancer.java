package org.example;

public class Dancer extends Artist {
    private String danceStyle;

    public Dancer(String name, int age, String genre, String danceStyle) {
        super(name, age, genre);
        this.danceStyle = danceStyle;
    }

    public String getDanceStyle() {
        return danceStyle;
    }

    public void setDanceStyle(String danceStyle) {
        this.danceStyle = danceStyle;
    }

    // абстракт метод
    @Override
    public void perform() {
        System.out.println(getName() + " исполняет зажигательный танец в стиле " + danceStyle + "!");
    }

    // абстракт метод
    @Override
    public String getAwards() {
        return "Имеет 3 награды";
    }

    //переопр метода
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  -> Специализация: Танцор | Стиль танца: " + danceStyle + " | Награды: " + getAwards());
    }
}