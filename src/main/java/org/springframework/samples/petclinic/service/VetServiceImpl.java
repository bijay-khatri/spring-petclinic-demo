package org.springframework.samples.petclinic.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.samples.petclinic.dto.VetDto;
import org.springframework.samples.petclinic.helper.ModelMapHelper;
import org.springframework.samples.petclinic.repository.SpecialtyRepository;
import org.springframework.samples.petclinic.repository.VetJpaRepository;
import org.springframework.samples.petclinic.service.contract.VetService;
import org.springframework.samples.petclinic.vet.Specialty;
import org.springframework.samples.petclinic.vet.Vet;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VetServiceImpl implements VetService {
    private final VetJpaRepository vetRepository;
    private final SpecialtyRepository specialtyRepository;

    public VetServiceImpl(VetJpaRepository vetRepository, SpecialtyRepository specialtyRepository) {
        this.vetRepository = vetRepository;
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public VetDto addVet(VetDto vetDto) {
        Vet vet = ModelMapHelper.vetDtoToVet(vetDto);
        vetDto.getSpecialties().forEach(s -> {
            //TODO: Validate this assumption
            Optional<Specialty> optionalSpecialty = specialtyRepository.findByName(s.getName());
            Specialty specialty = optionalSpecialty.orElseGet(() -> specialtyRepository.save(s));

            vet.addSpecialty(specialty);
        });
        return ModelMapHelper.vetToVetDto(vetRepository.save(vet));
    }

    @Override
    public Page<VetDto> findAll(Pageable pageable) {
        Page<Vet> vetList = vetRepository.findAll(pageable);
        if(vetList.isEmpty()) {
            return Page.empty();
        }
        return vetList.map(ModelMapHelper::vetToVetDto);
    }
}
