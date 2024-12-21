package com.example.kafkabase.dto;

import java.time.LocalDate;


public class MoneyMessage {
    private Long id;
    private Long value;
    private LocalDate date;

    public MoneyMessage(Long id, Long value, LocalDate date) {
        this.id = id;
        this.value = value;
        this.date = date;
    }

    public MoneyMessage() {
    }

    @Override
    public String toString() {
        return "MoneyMessage{" +
                "id=" + id +
                ", value=" + value +
                ", date=" + date +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
