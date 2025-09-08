package com.basa.jpa.controller;

import com.basa.jpa.model.Employee;
import com.basa.jpa.model.Employee_1;
import com.basa.jpa.repo.EmpRepo_1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Emp1Contrll {
    @Autowired
    private EmpRepo_1 repo_1;
    @PostMapping("om/empSave")
    public ResponseEntity<String> saveEmployeeListDetails(@RequestBody List<Employee_1> emp1){
        repo_1.saveAll(emp1);
        return ResponseEntity.ok("data Saved");
    }
    @GetMapping("om/getEmp")
    public List<Employee_1> getAllEmp(){
        return repo_1.findAll();

    }
}
