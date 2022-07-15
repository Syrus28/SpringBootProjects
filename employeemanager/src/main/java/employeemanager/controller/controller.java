package employeemanager.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import employeemanager.model.employee;
import employeemanager.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class controller {
	@Autowired
	private final EmployeeService employeeservice;

	public controller(EmployeeService employeeservice) {
		this.employeeservice = employeeservice;
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<employee>> getAllEmployee(){
		List<employee> employees=employeeservice.findAllEmployees();
		return  new ResponseEntity<>(employees,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<employee> getEmployeeById(@PathVariable("id") Long id){
		employee Employee=employeeservice.findEmployeeById(id);
		return  new ResponseEntity<>(Employee,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<employee> addEmployee(@RequestBody employee Employee){
		employee newEmployee=employeeservice.addEmployee(Employee);
		return  new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<employee> updateEmployee(@RequestBody employee Employee){
		employee updateEmployee=employeeservice.updateEmployee(Employee);
		return  new ResponseEntity<>(updateEmployee,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<employee>deleteEmployee(@PathVariable("id") Long id){
		employeeservice.deleteEmployee(id);
		return  new ResponseEntity<>(HttpStatus.OK);
	}
	
}
