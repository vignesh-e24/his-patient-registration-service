package com.his.patient.registration.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {
	private Long id;
	private String firstName;
	private String lastName;
	private Long age;
	private Long phoneNumber;
}
