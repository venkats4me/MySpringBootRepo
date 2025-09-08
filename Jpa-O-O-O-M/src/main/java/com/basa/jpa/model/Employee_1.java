package com.basa.jpa.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "employee1_details")
public class Employee_1 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private Long empId;
    private String empName;
    private Integer empAge;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
    private List<Address_1> address1List;

    public List<Address_1> getAddress1List() {
        return address1List;
    }

    public void setAddress1List(List<Address_1> address1List) {
        this.address1List = address1List;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getEmpAge() {
        return empAge;
    }

    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }
}
