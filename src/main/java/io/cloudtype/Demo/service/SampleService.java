package io.cloudtype.Demo.service;

import io.cloudtype.Demo.dto.SampleDto;
import io.cloudtype.Demo.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SampleService {
    @Autowired
    private SampleRepository sampleRepository;

    public List<SampleDto> findAll() {
        return sampleRepository.findAll().stream()
                .map(sample-> new SampleDto(sample.getId(), sample.getData()))
                .collect(Collectors.toList());

    }
}
