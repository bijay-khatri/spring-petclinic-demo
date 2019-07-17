package org.springframework.samples.petclinic.controller;

import org.springframework.samples.petclinic.repository.SpecialtyRepository;
import org.springframework.samples.petclinic.vet.Specialty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/specialities")
public class SpecialityRestController {

    private final SpecialtyRepository specialtyRepository;

    public SpecialityRestController(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @GetMapping("")
    public List<Specialty> getSpecialities() {
        return Collections.unmodifiableList(specialtyRepository.findAll()
            .orElseGet(Collections::emptyList));
    }

}
