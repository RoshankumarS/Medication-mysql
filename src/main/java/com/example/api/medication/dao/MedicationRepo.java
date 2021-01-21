package com.example.api.medication.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.common.pojo.Medication;

public interface MedicationRepo extends JpaRepository<Medication, Integer>{

	@Transactional
	void deleteByPatient_id(int id);

	@Transactional
	List<Optional<Medication>> findAllByPatient_id(int patientId);

}