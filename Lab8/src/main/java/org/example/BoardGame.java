package org.example;

// настол игра наследует класс Game
public class BoardGame extends Game {
    private int players;

    public BoardGame(String name, String genre, double rating, int players) {
        //отправ данные к родителю Game
        super(name, genre, rating);
        this.players = players;
    }

    public int getPlayers() {
        return players;
    }

    public void setPlayers(int players) {
        this.players = players;
    }

    //переопр метод родителя
    @Override
    public void play() {
        System.out.println("Играем за столом всей компанией (" + players + " чел.)");
    }

    //метод настол игры-бросок
    public void rollDice() {
        int dice = (int) (Math.random() * 6) + 1; //от 1 до 6
        System.out.println("Бросок кубика для \"" + getName() + "\": выпало число " + dice);
    }
}