package org.example;

//интерфейс
public interface Athlete {
    //абстракт методы
    void train();
    void compete();
    String getResults();

    //стат метод
    static void showMotivation() {
        System.out.println("[Мотивация]: Упорный труд побеждает талант, если талант не трудится!");
    }
}
