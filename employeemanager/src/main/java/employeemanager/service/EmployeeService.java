package employeemanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import employeemanager.exception.UserNotFoundException;
import employeemanager.model.employee;
import employeemanager.repo.Employeerepo;
@Service
public class EmployeeService {
	@Autowired
	private final Employeerepo employeerepo;
	
	public EmployeeService(Employeerepo employeerepo) {
		this.employeerepo = employeerepo;
	}
	
	public employee addEmployee(employee Employee) {
		return employeerepo.save(Employee);
		}
	
	public List<employee> findAllEmployees(){
		return employeerepo.findAll();
	}
	
	public employee updateEmployee(employee Employee) {
		return employeerepo.save(Employee);
	}
	
	public void deleteEmployee(Long id) {
		employeerepo.deleteEmployeeById(id);
	}
	
	public employee findEmployeeById(Long id) {
		return employeerepo.findEmployeeById(id)
				.orElseThrow(()-> new UserNotFoundException("User by id"+ id+ "not found"));
	}
}
