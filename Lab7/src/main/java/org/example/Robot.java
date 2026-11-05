package org.example;

public class Robot {

    private String model;
    private String function;
    private double batteryLife;

    private static int totalRobots = 0; // счетчик созд роботов
    private static double totalBatteryLife = 0.0; // сумма времени работы всех

    public Robot(String model, String function, double batteryLife) {
        this.model = model;
        this.function = function;
        this.batteryLife = batteryLife > 0 ? batteryLife : 1.0; // защита

        //при созд нов объекта обновляем стат счетчики
        totalRobots++;
        totalBatteryLife += this.batteryLife;
    }




    public void test() {
        System.out.println(this.model);
        System.out.println(this.function);
        System.out.println(this.batteryLife);
        System.out.println(totalRobots);
        System.out.println(totalBatteryLife);
    }

    public static void test(Robot robot) {
        System.out.println(robot.model);
        System.out.println(robot.function);
        System.out.println(robot.batteryLife);
        System.out.println(totalRobots);
        System.out.println(totalBatteryLife);
    }





    //гет
    public String getModel() {
        return model;
    }

    public String getFunction() {
        return function;
    }

    public double getBatteryLife() {
        return batteryLife;
    }

    //гет стат
    public static int getTotalRobots() {
        return totalRobots;
    }

    public static double getTotalBatteryLife() {
        return totalBatteryLife;
    }

    //стат метод
    //ср время работы роботов
    public static double getAverageBatteryLife() {
        if (totalRobots == 0) {
            return 0.0; // защита  /ноль
        }
        return totalBatteryLife / totalRobots;
    }

    //метод вывод робота
    public void displayInfo() {
        System.out.println("Модель: " + model +
                " | Назначение: " + function +
                " | Батарея: " + batteryLife + " ч.");
    }
}