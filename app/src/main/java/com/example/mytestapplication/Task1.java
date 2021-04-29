package com.example.mytestapplication;

public class Task1 {
    public static void main(String[] args) {
        Employee tester = new Employee(7,"Developer");
        System.out.println(tester.getId());
        System.out.println(tester.getVacancy());
    }
}

class Employee {
    private long id;
    private Vacancy vacancy;

    Employee(int id, String position){
        this.id = id;
        this.vacancy = new Vacancy(position);
    }
    String getVacancy() {
        return vacancy.getVacancy();
    }
    long getId() {
        return id;
    }
}

class Vacancy {
    private String name;

    Vacancy(String name){
        this.name = name;
    }

    String getVacancy() {
        return name;
    }
}
