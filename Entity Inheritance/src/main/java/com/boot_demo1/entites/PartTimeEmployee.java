package com.boot_demo1.entites;

import jakarta.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee {
    private Double hours;

    public Double getHours() {
        return hours;
    }

    public void setHours(Double hours) {
        this.hours = hours;
    }


    @Override
    public String toString() {
        return "PartTimeEmployee{" +
                "hours=" + hours +
                '}';
    }
}
