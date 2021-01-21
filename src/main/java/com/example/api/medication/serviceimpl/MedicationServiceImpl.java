package com.example.api.medication.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.common.dao.PatientRepo;
import com.example.api.common.pojo.Medication;
import com.example.api.common.pojo.Medicine;
import com.example.api.medication.dao.MedicationRepo;
import com.example.api.medication.dao.MedicineRepo;
import com.example.api.medication.pojo.MedData;
import com.example.api.medication.service.IMedicationService;

@Service
public class MedicationServiceImpl implements IMedicationService {
	
	private String validMessageForSave = "Patient Medication Data Submitted Successfully";
	
	private String validMessageForUpdate = "Patient Medication Data Updated Successfully";
	
	@Autowired
	private MedicationRepo medicationRepo;
	
	@Autowired
	private PatientRepo patientRepo;
	
	@Autowired
	private MedicineRepo medicineRepo;

	@Override
	public String saveMedicationData(MedData medData) {
		medData.getMedicationList().stream().forEach(m -> {
			m.setPatient(patientRepo.getOne(medData.getId()));
			medicationRepo.save(m);});
		return validMessageForSave;
	}

	@Override
	public String updateMedicationData(MedData medData) {
		medicationRepo.deleteByPatient_id(medData.getId());
		medData.getMedicationList().stream().forEach(m -> {
			m.setPatient(patientRepo.getOne(medData.getId()));
			medicationRepo.save(m);});
		return validMessageForUpdate;
	}

	@Override
	public List<Optional<Medicine>> getMedicationData(int patientId) {
		List<Optional<Medication>> medicationList = medicationRepo.findAllByPatient_id(patientId);
		List<Optional<Medicine>> medicineList = new ArrayList<>();
		medicationList.stream().forEach(m -> medicineList.add(medicineRepo.findById(m.get().getMedication_id())));
		return medicineList;
	}
	
}
