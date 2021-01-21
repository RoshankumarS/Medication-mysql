package com.example.api.medication.service;

import java.util.List;
import java.util.Optional;

import com.example.api.common.pojo.Medicine;
import com.example.api.medication.pojo.MedData;

public interface IMedicationService {

	public String saveMedicationData(MedData medData);
	
	public String updateMedicationData(MedData medData);

	public List<Optional<Medicine>> getMedicationData(int patientId);
	
}