package com.basa.jpa.repo;

import com.basa.jpa.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepo extends JpaRepository<Employee,Long> {
}
