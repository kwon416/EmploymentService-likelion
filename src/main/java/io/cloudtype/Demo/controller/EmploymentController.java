package io.cloudtype.Demo.controller;

import io.cloudtype.Demo.dto.EmploymentDto;
import io.cloudtype.Demo.service.EmploymentService;
import io.cloudtype.common.BaseApiController;
import io.cloudtype.common.BaseApiDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/employment")
@Tag(name = "Employment controller", description = "Employment api description")
public class EmploymentController extends BaseApiController<BaseApiDto<?>>  {
    private final EmploymentService employmentService;

    @Operation(summary = "공고 전체 조회", description = "공고 리스트를 조회합니다.")
    @GetMapping
    public ResponseEntity<BaseApiDto<?>> findAll(){
        List<EmploymentDto> employmentDtoList = employmentService.findAll();

        return super.ok(new BaseApiDto<>(employmentDtoList));
    }
    @Operation(summary = "공고 상세 조회", description = "employId 값으로 공고를 상세 조회합니다.")
    @GetMapping("/{id}")
    public ResponseEntity<BaseApiDto<?>> getById (@PathVariable("id") Long employId) {
        try {
            EmploymentDto employmentDto= employmentService.getById(employId);
            return super.ok(new BaseApiDto<>(employmentDto));
        } catch (EntityNotFoundException e) {
            return super.fail(BaseApiDto.newBaseApiDto(), "9999", "조회 실패 : 정보가 없습니다.");
        }
    }


}
