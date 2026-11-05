package org.example;

//реализ оба интерфейса
public class FootballPlayer implements Athlete, TeamPlayer {
    private String name;
    private String team;
    private int goals;

    public FootballPlayer(String name, String team, int goals) {
        this.name = name;
        this.team = team;
        this.goals = goals >= 0 ? goals : 0;
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

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        if (goals >= 0) {
            this.goals = goals;
        }
    }

    //реализ методы интерфейса атлет
    @Override
    public void train() {
        System.out.println("Футболист " + name + " отрабатывает удары по воротам и физическую выносливость.");
    }

    @Override
    public void compete() {
        System.out.println("Футболист " + name + " выходит в стартовом составе на матч за команду \"" + team + "\"!");
    }

    @Override
    public String getResults() {
        return "Забито голов за сезон: " + goals;
    }

    // реализ методы интерфейса TeamPlayer
    @Override
    public void playWithTeam() {
        System.out.println("Футболист " + name + " играет в пас и отрабатывает комбинации в составе команды \"" + team + "\".");
    }

    public void displayInfo() {
        System.out.println("Имя: " + name + " | Вид спорта: Футбол | Команда: " + team + " | " + getResults());
    }
}
