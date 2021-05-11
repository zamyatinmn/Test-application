package com.example.mytestapplication;

public class Task1 {
    public static void main(String[] args) {
        Employee tester = new Employee(7,"Developer");
        tester.print();
    }
}

class Employee {
    private long id;
    private Vacancy vacancy;

    Employee(int id, String position){
        this.id = id;
        this.vacancy = new Vacancy(position);
    }
    void print(){
        System.out.println(id + System.lineSeparator() + vacancy.getVacancy());
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
