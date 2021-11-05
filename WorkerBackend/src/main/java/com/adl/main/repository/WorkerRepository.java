package com.adl.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adl.main.model.InformationDepartmentModel;
import com.adl.main.model.WorkerModel;

public interface WorkerRepository extends JpaRepository<WorkerModel, Integer>{
	
	  @Query(value="SELECT * FROM worker p ORDER BY salary DESC LIMIT 5" ,nativeQuery = true)
	  List<WorkerModel> findTop5Salary();
	  
	  @Query(value="SELECT * FROM worker WHERE salary = (SELECT salary FROM worker GROUP BY salary HAVING COUNT(salary) > 1)", nativeQuery = true)
	  List<WorkerModel> findSameSalary();
	  
	  @Query(value="SELECT department, COUNT(department) AS jumlah FROM worker GROUP BY department", nativeQuery = true)
	  List<InformationDepartmentModel> findDepartmentInfo();
}
