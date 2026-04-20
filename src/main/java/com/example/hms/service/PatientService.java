package com.example.hms.service;

import com.example.hms.dto.PatientDto;
import com.example.hms.entity.Patient;
import com.example.hms.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientDto createPatient(PatientDto dto) {
        Patient patient = Patient.builder()
                .name(dto.getName()).age(dto.getAge()).gender(dto.getGender())
                .disease(dto.getDisease()).address(dto.getAddress()).phoneNumber(dto.getPhoneNumber())
                .build();
        return mapToDto(patientRepository.save(patient));
    }

    public List<PatientDto> getAllPatients() {
        return patientRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public PatientDto getPatientById(Long id) {
        return mapToDto(patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id)));
    }

    public PatientDto updatePatient(Long id, PatientDto dto) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
        patient.setName(dto.getName()); patient.setAge(dto.getAge());
        patient.setGender(dto.getGender()); patient.setDisease(dto.getDisease());
        patient.setAddress(dto.getAddress()); patient.setPhoneNumber(dto.getPhoneNumber());
        return mapToDto(patientRepository.save(patient));
    }

    public void deletePatient(Long id) {
        patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
        patientRepository.deleteById(id);
    }

    private PatientDto mapToDto(Patient p) {
        return new PatientDto(p.getId(), p.getName(), p.getAge(),
                p.getGender(), p.getDisease(), p.getAddress(), p.getPhoneNumber());
    }
}
