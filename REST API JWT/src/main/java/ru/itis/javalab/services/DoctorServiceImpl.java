package ru.itis.javalab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.javalab.dto.DoctorDto;
import ru.itis.javalab.models.Doctor;
import ru.itis.javalab.repositories.DoctorRepository;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    private DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<DoctorDto> getAllDoctors() {
        return DoctorDto.from(doctorRepository.findAll());
    }

    @Override
    public DoctorDto addDoctor(DoctorDto doctorDto) {
        Doctor newDoctor = Doctor.builder().firstName(doctorDto.getFirstName())
                .lastName(doctorDto.getLastName()).age(doctorDto.getAge()).
                        experience(doctorDto.getExperience()).build();
        doctorRepository.save(newDoctor);
        return DoctorDto.from(newDoctor);
    }

    @Override
    public DoctorDto updateDoctor(Long id, DoctorDto doctorDto) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        doctor.setFirstName(doctorDto.getFirstName());
        doctor.setLastName(doctorDto.getLastName());
        doctorRepository.save(doctor);
        return DoctorDto.from(doctor);
    }
}
