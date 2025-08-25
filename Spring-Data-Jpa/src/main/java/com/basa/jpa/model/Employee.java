package com.basa.jpa.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Locale;
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;
    private String name;
    private int age;
    @Column(name = "Phone_Number")
    private long phoneNumber=(long) (Math.random()*Math.pow(10,10));
    private String disgnation;
    private double salary=Math.random()*100000;;


    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDisgnation() {
        return disgnation;
    }

    public void setDisgnation(String disgnation) {
        this.disgnation = disgnation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
