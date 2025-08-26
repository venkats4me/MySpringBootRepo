package com.basa.jpa.services;

import com.basa.jpa.model.Employee;
import com.basa.jpa.repo.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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

    public Page<Employee> getEmployeePagination(Integer pageNumber, Integer pageSize, String sortProperty) {
        Pageable pageable = null;
        if(null!=sortProperty){
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC,sortProperty);
        }else {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC,"name");
        }
        return repo.findAll(pageable);
    }

    public List<Employee> getAllEmpByQuery() {
        return repo.getAllEmpByQuery();
    }
    public List<Employee> findEmployeeByDesignationAndActiveQuery(Boolean activeState,List<String> designationList) {
        return repo.findEmployeeByDesignationAndActiveQuery(activeState,designationList,Sort.by("name"));
    }

}
