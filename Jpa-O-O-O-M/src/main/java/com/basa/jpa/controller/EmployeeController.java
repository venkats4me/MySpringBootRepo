package com.basa.jpa.controller;

import com.basa.jpa.model.Employee;
import com.basa.jpa.repo.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmpRepo repo;
@PostMapping("/empSave")
    public ResponseEntity<String> saveEmployeeDetails(@RequestBody List<Employee> emp){
     repo.saveAll(emp);
     return ResponseEntity.ok("data Saved");
    }
    @GetMapping("/getEmp")
    public List<Employee> getAllEmp(){
    return repo.findAll();

    }


}
