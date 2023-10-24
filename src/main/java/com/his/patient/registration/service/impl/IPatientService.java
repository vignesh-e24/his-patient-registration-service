package com.his.patient.registration.service.impl;

import java.util.List;

import com.his.patient.registration.dto.PatientDto;

public interface IPatientService {

	 PatientDto createPatient(PatientDto patientDto);
	 PatientDto getPatientById(Long Id);
	 List<PatientDto> getAllPatients();
	 PatientDto updatePatient(Long patientId, PatientDto updatedPatient);
	 void deletePatient(Long patientId);
}
 