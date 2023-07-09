package io.cloudtype.Demo.controller;

import io.cloudtype.Demo.dto.SampleDto;
import io.cloudtype.Demo.service.SampleService;
import io.cloudtype.common.BaseApiController;
import io.cloudtype.common.BaseApiDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sample")
@Tag(name = "Sample controller", description = "sample api description")
public class SampleController extends BaseApiController<BaseApiDto<?>> {
    private final SampleService sampleService;

    @Operation(summary = "전체 조회", description = "SAMPLE 테이블의 모든 레코드를 조회합니다.")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseApiDto<?>> findAll () {
        List<SampleDto> sampleDtoList = sampleService.findAll();
        return super.ok(new BaseApiDto<>(sampleDtoList));
    }
}
