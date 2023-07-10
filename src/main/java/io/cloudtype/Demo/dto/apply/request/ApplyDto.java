package io.cloudtype.Demo.dto.apply.request;

import io.cloudtype.Demo.entity.Apply;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Schema(description = "자소서 DTO")
public class ApplyDto {
    private Long applyId;
    @Schema(description = "Employ Id")
    private Long employId;
    private String name;
    private String gender;
    private String birth;
    private String phoneNo;
    private String residence;
    private String careerYn;
    private String content1;
    private String content2;
    private String content3;
    private String content4;

    public ApplyDto(Apply apply) {
    this.applyId = apply.getApplyId();
    this.employId = apply.getEmployId().getEmployId();
    this.name = apply.getName();
    this.gender = apply.getGender();
    this.birth = apply.getBirth();
    this.phoneNo = apply.getPhoneNo();
    this.residence = apply.getResidence();
    this.careerYn = apply.getCareerYn();
    this.content1 = apply.getContent1();
    this.content2 = apply.getContent2();
    this.content3 = apply.getContent3();
    this.content4 = apply.getContent4();
    }
}
