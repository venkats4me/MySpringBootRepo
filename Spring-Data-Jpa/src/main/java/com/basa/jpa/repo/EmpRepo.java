package com.basa.jpa.repo;

import com.basa.jpa.model.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Long> {
    Employee findByEmpId(int empid);

    List<Employee> deleteByDisgnation(String desc);
    Optional<Employee> findTopByDisgnationOrderBySalaryDesc(String desc);


    //Optional<Employee> findTop2ByDisgnationOrderBySalaryDesc(String desc); it will give top2 val
    @Query("select p from Employee p")
    List<Employee> getAllEmpByQuery();

    @Query("select e from Employee e where e.status=:activeState and e.disgnation in :designationList")
    List<Employee> findEmployeeByDesignationAndActiveQuery(@Param("activeState") Boolean activeState,
                                                           @Param("designationList") List<String> designationList,
                                                           Sort sort);
}
