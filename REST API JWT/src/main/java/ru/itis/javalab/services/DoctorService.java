package ru.itis.javalab.services;

import ru.itis.javalab.dto.DoctorDto;

import java.util.List;

public interface DoctorService {
    List<DoctorDto> getAllDoctors();
    DoctorDto addDoctor(DoctorDto doctorDto);
    DoctorDto updateDoctor(Long id, DoctorDto doctorDto);
}
