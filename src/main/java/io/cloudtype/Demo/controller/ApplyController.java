package io.cloudtype.Demo.controller;

import io.cloudtype.Demo.dto.apply.request.ApplyDto;
import io.cloudtype.Demo.service.ApplyService;
import io.cloudtype.common.BaseApiController;
import io.cloudtype.common.BaseApiDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/apply")
@Tag(name = "Apply controller", description = "Apply api description")
public class ApplyController extends BaseApiController<BaseApiDto<?>> {
    private final ApplyService applyService;

    @Operation(summary = "자소서 전체 조회", description = "자소서를 리스트를 조회합니다.")
    @GetMapping
    public ResponseEntity<BaseApiDto<?>> findAll() {
        List<ApplyDto> applyDtoList = applyService.findAll();
        return super.ok(new BaseApiDto<>(applyDtoList));
    }

    @Operation(summary = "자소서 아이디로 조회", description = "applyId 값으로 자소서 정보를 조회합니다.")
    @GetMapping("/{id}")
    public ResponseEntity<BaseApiDto<?>> getById (@PathVariable("id") Long applyId) {
        try {
            ApplyDto applyDto= applyService.getById(applyId);
            return super.ok(new BaseApiDto<>(applyDto));
        } catch (EntityNotFoundException e) {
            return super.fail(BaseApiDto.newBaseApiDto(), "9999", "조회 실패 : 정보가 없습니다.");
        }
    }

    @Operation(summary = "자소서 저장", description = "입력한 자소서를 저장합니다.")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseApiDto<?>> saveApply (@RequestBody ApplyDto request) {
        try {
            applyService.saveApply(request);
            return super.ok(BaseApiDto.newBaseApiDto());
        } catch (EntityNotFoundException e) {
            return super.fail(BaseApiDto.newBaseApiDto(), "9999", "저장 실패 : employId 정보가 없습니다.");
        }
    }
    @Operation(summary = "자소서 수정", description = "입력한 자소서를 수정합니다.")
    @PostMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseApiDto<?>> updateApply (@RequestBody ApplyDto request) {
        try {
            applyService.saveApply(request);
            return super.ok(BaseApiDto.newBaseApiDto());
        } catch (EntityNotFoundException e) {
            return super.fail(BaseApiDto.newBaseApiDto(), "9999", "수정 실패 : 수정할 정보가 없습니다.");
        }
    }


}
