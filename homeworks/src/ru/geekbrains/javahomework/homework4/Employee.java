package ru.geekbrains.javahomework.homework4;

import java.util.Calendar;

public class Employee {

    private static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
    private static int counter = 0;

    private final int id;
    private final int age;

    private String fullName;
    private double salary;

    public Employee(String fullName, double salary, int birthYear) {
        this(birthYear);
        this.fullName = fullName;
        this.salary = salary;
    }

    private Employee(int birthYear) {
        counter += 1;
        this.id = counter;
        this.age = CURRENT_YEAR - birthYear;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", age=" + age + " years" +
                ", salary=" + salary + "$" +
                '}';
    }

    public void increaseSalary(double incAmount) {
        setSalary(this.salary + incAmount);
    }

    public int getAge() {
        return age;
    }

    public String getFullName() {
        return fullName;
    }

    public double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }
}
