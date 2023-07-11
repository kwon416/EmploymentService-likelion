package io.cloudtype.Demo.dto;

import io.cloudtype.Demo.entity.Employment;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "공고 DTO")
public class EmploymentDto {
    private Long employId;
    private Long companyId;
    private String title;
    private String expDate;
    private String content;
    private String companyName;
    private String industry;
    private String corporateForm;
    private String url;
    private String jobType;
    private String salary;
    private String location;
    private String time;
    private String career;
    private String education;
    private String skill;

    public EmploymentDto(Employment employment) {
        this.employId = employment.getEmployId();
        this.companyId = employment.getCompanyId();
        this.title = employment.getTitle();
        this.expDate = employment.getExpDate();
        this.content = employment.getContent();
        this.companyName = employment.getCompanyName();
        this.industry = employment.getIndustry();
        this.corporateForm = employment.getCorporateForm();
        this.url = employment.getUrl();
        this.jobType = employment.getJobType();
        this.salary = employment.getSalary();
        this.location = employment.getLocation();
        this.time = employment.getTime();
        this.career = employment.getCareer();
        this.education = employment.getEducation();
        this.skill = employment.getSkill();
    }

}
