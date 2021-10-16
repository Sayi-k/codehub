package com.batch.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.batch.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, String> {

}
