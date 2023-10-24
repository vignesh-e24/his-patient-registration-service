package com.his.patient.registration.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.his.patient.registration.dao.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

}
