package com.techielady.demo.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techielady.demo.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
