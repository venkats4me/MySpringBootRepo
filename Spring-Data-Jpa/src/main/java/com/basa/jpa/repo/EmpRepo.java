package com.basa.jpa.repo;

import com.basa.jpa.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Long> {
    Employee findByEmpId(int empid);

    List<Employee> deleteByDisgnation(String desc);
    Optional<Employee> findTopByDisgnationOrderBySalaryDesc(String desc);
}
