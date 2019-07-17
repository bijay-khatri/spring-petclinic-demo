package org.springframework.samples.petclinic.repository;

import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.vet.Specialty;

import java.util.List;
import java.util.Optional;

public interface SpecialtyRepository extends Repository<Specialty, Integer> {
    Optional<Specialty> findByName(String name);
    Optional<List<Specialty>> findAll();
    Specialty save(Specialty specialty);
}
