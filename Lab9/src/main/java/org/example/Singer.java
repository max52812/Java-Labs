package org.example;

public class Singer extends Artist {
    private String voiceType;

    public Singer(String name, int age, String genre, String voiceType) {
        super(name, age, genre);
        this.voiceType = voiceType;
    }

    public String getVoiceType() {
        return voiceType;
    }

    public void setVoiceType(String voiceType) {
        this.voiceType = voiceType;
    }

    //абстракт метод
    @Override
    public void perform() {
        System.out.println(getName() + " выходит на сцену и поет песню живым голосом!");
    }

    //абстракт метод
    @Override
    public String getAwards() {
        return "Имеет 5 наград";
    }

    //переопределение метод
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  -> Специализация: Певец | Тип голоса: " + voiceType + " | Награды: " + getAwards());
    }
}