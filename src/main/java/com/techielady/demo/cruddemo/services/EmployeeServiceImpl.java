package com.techielady.demo.cruddemo.services;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techielady.demo.cruddemo.dao.EmployeeRepository;
import com.techielady.demo.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}

	@Override
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeebyId(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		
		if(result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			throw new RuntimeException("The employee with the id " + theId + "was not found");
		}
		return theEmployee;
	}

	@Override
	public void saveAll(Employee thEmployee) {
		employeeRepository.save(thEmployee);
	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}
