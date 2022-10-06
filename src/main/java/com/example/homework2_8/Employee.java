package com.example.homework2_8;


import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastFamily;
    private final int department;
    private final double salary;

    public Employee(String firstName, String lastFamily, int department, int salary) {
        this.firstName = firstName;
        this.lastFamily = lastFamily;
        this.department = department;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastFamily() {
        return lastFamily;
    }

    public double getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "имя : " + firstName + "\nфамилия : " + lastFamily + "\n" + " department " + department + "\n" + " salary " + salary + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && department == employee.department && firstName.equals(employee.firstName) && lastFamily.equals(employee.lastFamily);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastFamily, salary, department);
    }
}




