package com.his.patient.registration.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.his.patient.registration.dao.entity.Patient;
import com.his.patient.registration.dao.repository.PatientRepository;
import com.his.patient.registration.dto.PatientDto;
import com.his.patient.registration.exception.ResourceNotFoundException;
import com.his.patient.registration.mapper.PatientMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements IPatientService{
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Override
	public PatientDto createPatient(PatientDto patientDto) {
		
		Patient patient = PatientMapper.mapToPatient(patientDto);
		Patient savePatient = patientRepository.save(patient);
		return PatientMapper.mapToPatientDto(savePatient);
	}

	@Override
	public PatientDto getPatientById(Long patientId) {
		Patient patient = patientRepository.findById(patientId)
				.orElseThrow(()->
								new ResourceNotFoundException("Patient does not exists with given id :" + patientId));
					
				return PatientMapper.mapToPatientDto(patient);
	}

	@Override
	public List<PatientDto> getAllPatients() {
		List<Patient> patients = patientRepository.findAll();
		return patients.stream().map((patient)-> PatientMapper.mapToPatientDto(patient)).collect(Collectors.toList());
	}

	@Override
	public PatientDto updatePatient(Long patientId, PatientDto updatedPatient) {
		Patient patient = patientRepository.findById(patientId)
				.orElseThrow(()->
				new ResourceNotFoundException("Patient does not exists with given id :" + patientId));
		patient.setFirstName(updatedPatient.getFirstName());
		patient.setLastName(updatedPatient.getLastName());
		patient.setAge(updatedPatient.getAge());
		patient.setPhoneNumber(updatedPatient.getPhoneNumber());
		
		Patient updatePatientObj = patientRepository.save(patient);
		
		return PatientMapper.mapToPatientDto(updatePatientObj);
		
		
		
		
	}

	@Override
	public void deletePatient(Long patientId) {
		Patient patient = patientRepository.findById(patientId)
				.orElseThrow(()->
				new ResourceNotFoundException("Patient does not exists with given id :" + patientId));	
		patientRepository.deleteById(patientId);
	}

}
