package org.springframework.samples.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.vet.Vet;

public interface VetJpaRepository extends JpaRepository<Vet, Integer> {
}
