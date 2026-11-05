package org.example;

// abstract запрещ созд объекта через new Artist()
public abstract class Artist {
    private String name;
    private int age;
    private String genre;

    public Artist(String name, int age, String genre) {
        this.name = name;
        this.age = age > 0 ? age : 18;
        this.genre = genre;
    }

    // геты и сеты
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        if (genre != null && !genre.trim().isEmpty()) {
            this.genre = genre;
        }
    }

    //абстракт методы
    // метод выступления
    public abstract void perform();

    // мьетод получения наград
    public abstract String getAwards();

    // метод
    public void displayInfo() {
        System.out.println("Имя: " + name + " | Возраст: " + age + " | Жанр: " + genre);
    }
}