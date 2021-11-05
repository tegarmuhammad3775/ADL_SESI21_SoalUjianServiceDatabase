package com.adl.main.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adl.main.model.BonusModel;
import com.adl.main.model.InformationDepartmentModel;
import com.adl.main.model.WorkerModel;
import com.adl.main.repository.BonusRepository;
import com.adl.main.repository.WorkerRepository;

@RestController
public class WorkerController {
	
	@Autowired
	WorkerRepository workerRepo;
	
	
	@GetMapping("/worker")
	public List<WorkerModel> getAllWorker(){
		List<WorkerModel> listWorker = workerRepo.findAll();
		return listWorker;
	}
	
	@PostMapping("/worker/save")
	public WorkerModel saveWorker(@RequestBody WorkerModel data) {
		return workerRepo.save(data);
	}
	

	@DeleteMapping("/worker")
	public String deleteWorker(@RequestParam("worker_id") int worker_id) {
	  workerRepo.deleteById(worker_id);	
	  return "Berhasil Delete Worker";
	}
	
	@PatchMapping("/worker")
	public WorkerModel updateWorker(@RequestBody WorkerModel worker){
	     	return workerRepo.save(worker);
	}
	
	@GetMapping("/worker/top_salary")
	public List<WorkerModel> getTop5Salary(){
		List<WorkerModel> listWorker = workerRepo.findTop5Salary();
		return listWorker;
	}
	
	@GetMapping("/worker/same_salary")
	public List<WorkerModel> getSameSalary(){
		List<WorkerModel> listWorker = workerRepo.findSameSalary();
		return listWorker;
	}
	
	@GetMapping("/worker/department_info")
	public ResponseEntity<String> getDepartmentInfo(){
		List<InformationDepartmentModel> listDepartInfo = workerRepo.findDepartmentInfo();
		JSONArray list = new JSONArray();
		
		for (InformationDepartmentModel infoDepartModel : listDepartInfo) {
			JSONObject obj = new JSONObject();
			obj.put("department", infoDepartModel.getDepartment());
			obj.put("jumlah", infoDepartModel.getJumlah());
			list.put(obj);
		}
		
		return ResponseEntity
				   .status(HttpStatus.OK)
				   .contentType(MediaType.APPLICATION_JSON)
				   .body(list.toString());
	}
	
	

}

