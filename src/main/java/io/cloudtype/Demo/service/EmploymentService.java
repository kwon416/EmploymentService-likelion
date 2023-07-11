package io.cloudtype.Demo.service;

import io.cloudtype.Demo.dto.EmploymentDto;
import io.cloudtype.Demo.dto.apply.request.ApplyDto;
import io.cloudtype.Demo.entity.Apply;
import io.cloudtype.Demo.entity.Employment;
import io.cloudtype.Demo.repository.EmploymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmploymentService {
    private final EmploymentRepository employmentRepository;

    @Transactional
    public List<EmploymentDto> findAll(){
        List<Employment> employmentList = employmentRepository.findAll();
        List<EmploymentDto> employmentDtoList = new ArrayList<>();
        for (Employment employment: employmentList){
            employmentDtoList.add(new EmploymentDto(employment));
        }
        return employmentDtoList;
    }

    @Transactional
    public EmploymentDto getById(Long employId) {
        Employment employment = employmentRepository.findById(employId).orElseThrow(EntityNotFoundException::new);
        return new EmploymentDto(employment);
    }

}
