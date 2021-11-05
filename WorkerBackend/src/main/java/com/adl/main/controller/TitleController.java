package com.adl.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.adl.main.model.TitleModel;
import com.adl.main.model.WorkerModel;
import com.adl.main.repository.BonusRepository;
import com.adl.main.repository.TitleRepository;

@RestController
public class TitleController {
	
	@Autowired
	TitleRepository titleRepo;
	
	
	@GetMapping("/title")
	public List<TitleModel> getAllTitle(){
		List<TitleModel> listTitle = titleRepo.findAll();
		return listTitle;
	}
	
	@PostMapping("/title/save")
	public TitleModel saveTitle(@RequestBody TitleModel data) {
		return titleRepo.save(data);
	}
	
	@PostMapping("/title/save/{worker_ref_id}")
    public TitleModel saveBonus(@PathVariable("worker_ref_id") int worker_ref_id, @RequestBody TitleModel data){
		WorkerModel worker = new WorkerModel();
		worker.setWorker_id(worker_ref_id);
		data.setWorker_ref_id(worker);
		return titleRepo.save(data);
	}
	
	@DeleteMapping("/title")
	public String deleteTitle(@RequestParam("id") int id) {
	  titleRepo.deleteById(id);	
	  return "Berhasil Delete Title";
	}
	
	@PatchMapping("/title")
	public TitleModel updateTitle(@RequestBody TitleModel title){
	     	return titleRepo.save(title);
	}
	

}
