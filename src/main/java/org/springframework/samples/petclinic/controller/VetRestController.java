package org.springframework.samples.petclinic.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.dto.VetDto;
import org.springframework.samples.petclinic.helper.ApiConstant;
import org.springframework.samples.petclinic.response.ApiResponse;
import org.springframework.samples.petclinic.service.contract.VetService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/vets")
public class VetRestController {
    private final VetService vetService;

    public VetRestController(VetService vetService) {
        this.vetService = vetService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<VetDto>> addVet(@RequestBody VetDto vetDto) {
        if(isInputInvalid(vetDto)){
            ApiResponse.Error clientError = new ApiResponse.Error(HttpStatus.BAD_REQUEST.value(),
                ApiConstant.CLIENT_ERROR,
                "FirstName and/or LastName cannot be null or empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse<>(null, clientError));
        }
        return ResponseEntity.ok(new ApiResponse<>(vetService.addVet(vetDto), null));
    }

    private boolean isInputInvalid(VetDto vetDto) {
        return vetDto.getFirstName() == null || vetDto.getFirstName().trim().isEmpty() || vetDto.getLastName() == null || vetDto.getLastName().trim().isEmpty();
    }

    @GetMapping(name = "")
    public ResponseEntity<ApiResponse<Page<VetDto>>> getVets(@PageableDefault(page = 0, size = 20)
                                                             @SortDefault(value = "firstName", direction = Sort.Direction.ASC)
                                                             Pageable pageable) {
        Page<VetDto> vetDtoPage = vetService.findAll(pageable);
        ApiResponse<Page<VetDto>> response = new ApiResponse<>(vetDtoPage, null);
        return ResponseEntity.ok(response);
    }

}
