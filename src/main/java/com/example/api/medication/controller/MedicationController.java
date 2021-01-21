package com.example.api.medication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.common.pojo.Medicine;
import com.example.api.medication.pojo.MedData;
import com.example.api.medication.service.IMedicationService;

@RestController
@RequestMapping("/medication")
public class MedicationController {
	
	@Autowired
	private IMedicationService medicationServices;
	
	@PostMapping(path = "/save", consumes="application/json")
	public String saveMedicationData(@RequestBody MedData medData) {
		return medicationServices.saveMedicationData(medData);
	}
	
	@PostMapping(path = "/update", consumes="application/json")
	public String updateMedicationData(@RequestBody MedData medData) {
		return medicationServices.updateMedicationData(medData);
	}
	
	@GetMapping(value = "/get/{patientId}", produces="application/json")
	public List<Optional<Medicine>> getMedicationData(@PathVariable("patientId") int patientId) {
		return medicationServices.getMedicationData(patientId);
	}
	
}
