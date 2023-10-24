package com.his.patient.registration.mapper;

import com.his.patient.registration.dao.entity.Patient;
import com.his.patient.registration.dto.PatientDto;

public class PatientMapper {
	
	public static PatientDto mapToPatientDto(Patient patient) {
		return new PatientDto (
				patient.getId(),
				patient.getFirstName(),
				patient.getLastName(),
				patient.getAge(),
				patient.getPhoneNumber()
				);						
	}
	
	public static Patient mapToPatient(PatientDto patientDto) {
		return new Patient (
				patientDto.getId(),
				patientDto.getFirstName(),
				patientDto.getLastName(),
				patientDto.getAge(),
				patientDto.getPhoneNumber()
				);						
	}
}
