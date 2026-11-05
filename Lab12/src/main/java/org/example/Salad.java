package org.example;

public class Salad extends FoodItem {
    private String dressing;

    public Salad(String name, int id, double calories, String dressing) {
        super(name, id, calories);
        this.dressing = dressing;
    }

    public String getDressing() {
        return dressing;
    }

    public void setDressing(String dressing) {
        this.dressing = dressing;
    }

    @Override
    public String toString() {
        return super.toString() + " [Тип: Салат, Заправка: " + dressing + "]";
    }
}
