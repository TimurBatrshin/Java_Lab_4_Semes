package ru.itis.javalab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.javalab.models.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
