package com.example.homework2_8;


import java.util.Objects;

public class Employee {
    private final String name;
    private final String surname;
    private final int department;
    private final double salary;

    public Employee(String name, String surname, int department, int salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "имя : " + getName() + "\nфамилия : " + getSurname() + "\n" + " department " + getDepartment() + "\n" + " salary " + getSalary() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && Double.compare(employee.salary, salary) == 0 && name.equals(employee.name) && surname.equals(employee.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, department, salary);
    }
}




