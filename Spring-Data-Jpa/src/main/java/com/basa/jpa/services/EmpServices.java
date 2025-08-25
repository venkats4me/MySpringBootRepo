package com.basa.jpa.services;

import com.basa.jpa.model.Employee;
import com.basa.jpa.repo.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmpServices {
    @Autowired
    private EmpRepo repo;
    public List<Employee> saveEmpList(List<Employee> empList) {
        return repo.saveAll(empList);
    }

    public List<Employee> getAllEmp() {
        return repo.findAll();
    }

    public Employee getEmpById(int id) {
        return repo.findByEmpId(id);
    }

    public Optional<Employee> getEmpByIdDef(Long id) {
        return repo.findById(id);
    }

    public  List<Employee> deleteByDesing(String desc) {
       return repo.deleteByDisgnation(desc);
    }

   /* public Optional<Employee> getEmpMaxSalByDesc(String desc) {
        return repo.findAll().stream().filter(e->e.getDisgnation().equals(desc)).
                max(Comparator.comparingDouble(Employee::getSalary));
    }*/
    public Optional<Employee> getEmpMaxSalByDesc(String desc) {
        return repo.findTopByDisgnationOrderBySalaryDesc(desc);
    }
}
