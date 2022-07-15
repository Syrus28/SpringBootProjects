package employeemanager.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import employeemanager.model.employee;


public interface Employeerepo extends JpaRepository<employee,Long> {

	void deleteEmployeeById(Long id);

	Optional<employee> findEmployeeById(Long id);

}