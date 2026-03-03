package com.boot_demo1.entites;

import jakarta.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee{
    private  Double Salary;


    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double salary) {
        Salary = salary;
    }

    @Override
    public String toString() {
        return "FullTimeEmployee{" +
                "Salary=" + Salary +
                '}';
    }
}
