package com.his.patient.registration.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.his.patient.registration.dto.PatientDto;
import com.his.patient.registration.service.impl.IPatientService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {
	
	private IPatientService patientService;
	
    //Build Add Patient REST API 
	@PostMapping
	public ResponseEntity<PatientDto> createPatient(@RequestBody PatientDto patientDto){
		PatientDto savePatient = patientService.createPatient(patientDto);
		return new ResponseEntity<>(savePatient, HttpStatus.CREATED);
	}
	
    //Build Get Patient REST API 
	@GetMapping("{id}")
	public ResponseEntity<PatientDto> getPatientById(@PathVariable("id")Long patientId){
		PatientDto patientDto = patientService.getPatientById(patientId);
		return ResponseEntity.ok(patientDto);
	}
	
	//Build Get All Patients REST API 
	@GetMapping
	public ResponseEntity<List<PatientDto>> getAllPatients(){
		List<PatientDto> patients = patientService.getAllPatients();	
		return ResponseEntity.ok(patients);
	}
	
	//Build Update Patient REST API 
	@PutMapping("{id}")
	public ResponseEntity<PatientDto> updatePatient(@PathVariable("id") Long patientId,@RequestBody PatientDto updatedPatient){
														
		   PatientDto patientDto = patientService.updatePatient(patientId, updatedPatient);
		   return ResponseEntity.ok(patientDto);
	}
	
	//Build Delete Patient REST API 
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletePatient(@PathVariable("id")Long patientId){
		patientService.deletePatient(patientId);
		return ResponseEntity.ok("Patient deleted successfully!.");
	}
}

