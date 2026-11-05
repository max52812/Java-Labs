package org.example;

public class Ticket {
    String flightNumber;
    TicketType type;

    // Конструктор
    public Ticket(String flightNumber, TicketType type) {
        this.flightNumber = flightNumber;
        this.type = type;
    }
}