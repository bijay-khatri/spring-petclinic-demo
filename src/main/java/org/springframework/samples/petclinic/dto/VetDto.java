package org.springframework.samples.petclinic.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.samples.petclinic.vet.Specialty;

import java.util.Set;

@Getter
@Setter
public class VetDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private Set<Specialty> specialties;
}
