package org.example;

import java.util.ArrayList;
import java.util.List;

public class Park {
    private int id;
    private String name;
    private String city;
    private int rating;
    private List<Integer> visitorRatings;

    public Park(int id, String name, String city, int rating, List<Integer> visitorRatings) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.rating = rating;
        this.visitorRatings = visitorRatings != null ? visitorRatings : new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<Integer> getVisitorRatings() {
        return visitorRatings;
    }

    public void setVisitorRatings(List<Integer> visitorRatings) {
        this.visitorRatings = visitorRatings;
    }

    // ср рейтинг по оценкам
    public double getAverageRating() {
        if (visitorRatings == null || visitorRatings.isEmpty()) {
            return rating;
        }
        double sum = 0;
        for (int r : visitorRatings) {
            sum += r;
        }
        return sum / visitorRatings.size();
    }

    public static void printParks(List<Park> parks, int rating) {
        System.out.println("Парки с текущим рейтингом " + rating + ":");
        boolean found = false;
        for (Park p : parks) {
            if (p.getRating() == rating) {
                System.out.printf("  -> ID: %d | %s (%s) | Рейтинг: %d | Ср. балл: %.2f%n",
                        p.getId(), p.getName(), p.getCity(), p.getRating(), p.getAverageRating());
                found = true;
            }
        }
        if (!found) {
            System.out.println("  (нет парков с таким рейтингом)");
        }
    }

    @Override
    public String toString() {
        return String.format("ID: %d | %-22s | Город: %-12s | Рейтинг: %d | Оценки: %s | Ср. балл: %.2f",
                id, name, city, rating, visitorRatings, getAverageRating());
    }
}
