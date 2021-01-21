package com.example.api.medication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.common.pojo.Medicine;

public interface MedicineRepo extends JpaRepository<Medicine, Integer>{

}
