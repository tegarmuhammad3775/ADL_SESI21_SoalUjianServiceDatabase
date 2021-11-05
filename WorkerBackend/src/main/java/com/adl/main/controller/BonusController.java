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


@RestController
public class BonusController {
	
	@Autowired
	BonusRepository bonusRepo;
	
	
	@GetMapping("/bonus")
	public List<BonusModel> getAllBonus(){
		List<BonusModel> listBonus = bonusRepo.findAll();
		return listBonus;
	}
	
	@PostMapping("/bonus/save")
	public BonusModel saveBonus(@RequestBody BonusModel data) {
		return bonusRepo.save(data);
	}
	
	@PostMapping("/bonus/save/{worker_ref_id}")
    public BonusModel saveBonus(@PathVariable("worker_ref_id") int worker_ref_id, @RequestBody BonusModel data){
		WorkerModel worker = new WorkerModel();
		worker.setWorker_id(worker_ref_id);
		data.setWorker_ref_id(worker);
		return bonusRepo.save(data);
	}
	
	@DeleteMapping("/bonus")
	public String deleteBonus(@RequestParam("id") int id) {
	  bonusRepo.deleteById(id);	
	  return "Berhasil Delete Bonus";
	}
	
	@PatchMapping("/bonus")
	public BonusModel updateBonus(@RequestBody BonusModel bonus){
	     	return bonusRepo.save(bonus);
	}
	
	
	
	

}
