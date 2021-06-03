package ru.itis.javalab.controllers;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.javalab.dto.DoctorDto;
import ru.itis.javalab.services.DoctorService;

import java.util.List;

@RestController
public class DoctorController {

    private DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }


    @GetMapping("/doctors")
    public ResponseEntity<List<DoctorDto>> getAllDoctors(@RequestHeader(name = "X-TOKEN") String token){
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @ApiOperation(value = "Добавление педагога")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Успешно добавлено", response = DoctorDto.class)})
    @PostMapping("/addDoctor")
    public  ResponseEntity<DoctorDto> addDoctor(@RequestBody DoctorDto doctorDto){
        return ResponseEntity.ok(doctorService.addDoctor(doctorDto));
    }

    @PutMapping("/update/{doctor-id}")
    public ResponseEntity<DoctorDto> updateDoctor(@PathVariable(value = "doctor-id") Long id,
                                                  @RequestBody DoctorDto doctorDto){
        return ResponseEntity.ok(doctorService.updateDoctor(id,doctorDto));
    }
}
