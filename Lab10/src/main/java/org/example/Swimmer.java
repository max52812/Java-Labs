package org.example;

//реализ оба интерфейса
public class Swimmer implements Athlete, TeamPlayer {
    private String name;
    private String team;
    private int records;

    public Swimmer(String name, String team, int records) {
        this.name = name;
        this.team = team;
        this.records = records >= 0 ? records : 0;
    }

    // гетты и сетты
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        if (team != null && !team.trim().isEmpty()) {
            this.team = team;
        }
    }

    public int getRecords() {
        return records;
    }

    public void setRecords(int records) {
        if (records >= 0) {
            this.records = records;
        }
    }

    // реализ методы интерфейса атлет
    @Override
    public void train() {
        System.out.println("Пловец " + name + " проплывает утреннюю дистанцию 400 метров вольным стилем.");
    }

    @Override
    public void compete() {
        System.out.println("Пловец " + name + " стартует в заплыве чемпионата за сборную \"" + team + "\"!");
    }

    @Override
    public String getResults() {
        return "Установлено рекордов: " + records;
    }

    //реализ методоы интерфейса TeamPlayer
    @Override
    public void playWithTeam() {
        System.out.println("Пловец " + name + " отрабатывает передачу эстафеты в эстафетной четвёрке команды \"" + team + "\".");
    }

    public void displayInfo() {
        System.out.println("Имя: " + name + " | Вид спорта: Плавание | Команда: " + team + " | " + getResults());
    }
}
