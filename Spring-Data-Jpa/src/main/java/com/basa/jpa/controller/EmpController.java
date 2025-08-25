package com.basa.jpa.controller;

import com.basa.jpa.model.Employee;
import com.basa.jpa.services.EmpServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class EmpController {
    @Autowired
    private EmpServices empsrv;
    @PostMapping("/saveEmp")
    public List<Employee> saveEmp(@RequestBody List<Employee> empList){
        return empsrv.saveEmpList(empList);
    }
    @GetMapping("/getAllEmp")
    public List<Employee> getAllEmp(){
        return empsrv.getAllEmp();
    }
    @GetMapping("/getByEmp/{id}")
    public Employee getEmpById(@PathVariable int id){
        return empsrv.getEmpById(id);
    }
    @GetMapping("/getByEmpDef/{id}")
    public Optional<Employee> getEmpByIdDef(@PathVariable Long id){
        return empsrv.getEmpByIdDef(id);
    }
    @DeleteMapping("DelbyDesc/{desc}")
    public List<Employee> deleteByDesing(@PathVariable String desc){
      return   empsrv.deleteByDesing(desc);

    }
    @GetMapping("/getByEmpSalByDesc/{desc}")
    public Optional<Employee> getEmpMaxSalByDesc(@PathVariable String desc){
        return empsrv.getEmpMaxSalByDesc(desc);
    }
}
