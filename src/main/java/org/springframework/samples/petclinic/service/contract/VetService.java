package org.springframework.samples.petclinic.service.contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.samples.petclinic.dto.VetDto;

public interface VetService {
    VetDto addVet(VetDto vetDto);
    Page<VetDto> findAll(Pageable pageable);
}
