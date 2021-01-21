package com.example.api.medication.pojo;

import java.util.List;

import com.example.api.common.pojo.Medication;

public class MedData {
	
	private int id;
	
	private List<Medication> medicationList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Medication> getMedicationList() {
		return medicationList;
	}

	public void setMedicationList(List<Medication> medicationList) {
		this.medicationList = medicationList;
	}

}
