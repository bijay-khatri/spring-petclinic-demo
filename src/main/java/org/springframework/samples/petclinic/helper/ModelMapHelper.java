package org.springframework.samples.petclinic.helper;

import org.modelmapper.ModelMapper;
import org.springframework.samples.petclinic.dto.VetDto;
import org.springframework.samples.petclinic.vet.Vet;

public class ModelMapHelper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static VetDto vetToVetDto(Vet source) {
        return modelMapper.map(source, VetDto.class);
    }

    public static Vet vetDtoToVet(VetDto source) {
        return modelMapper.map(source, Vet.class);
    }
}
