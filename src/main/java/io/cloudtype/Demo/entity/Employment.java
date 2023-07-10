package io.cloudtype.Demo.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "EMPLOYMENT")
@Table(name = "EMPLOYMENT")
public class Employment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOY_ID")
    private Long employId;
    @Column(name = "COMPANY_ID", nullable = false)
    private Long companyId;
    @Column(name = "TITLE", nullable = false)
    private String title;
    @Column(name = "EXP_DATE", nullable = false)
    private String expDate;
    @Column(name = "CONTENT", nullable = false)
    private String content;
    @Column(name = "COMPANY_NAME", nullable = false)
    private String companyName;
    @Column(name = "INDUSTRY", nullable = false)
    private String industry;
    @Column(name = "CORPORATE_FORM", nullable = false)
    private String corporateForm;
    @Column(name = "URL", nullable = false)
    private String url;
    @Column(name = "JOB_TYPE", nullable = false)
    private String jobType;
    @Column(name = "SALARY", nullable = false)
    private String salary;
    @Column(name = "LOCATION", nullable = false)
    private String location;
    @Column(name = "TIME", nullable = false)
    private String time;
    @Column(name = "CAREER", nullable = false)
    private String career;
    @Column(name = "EDUCATION", nullable = false)
    private String education;
    @Column(name = "SKILL", nullable = false)
    private String skill;

    @Builder
    public Employment(
            Long employId,
            Long companyId,
            String title,
            String expDate,
            String content,
            String companyName,
            String industry,
            String corporateForm,
            String url,
            String jobType,
            String salary,
            String location,
            String time,
            String career,
            String education,
            String skill
    ) {
        this.employId = employId;
        this.companyId = companyId;
        this.title = title;
        this.expDate = expDate;
        this.content = content;
        this.companyName = companyName;
        this.industry = industry;
        this.corporateForm = corporateForm;
        this.url = url;
        this.jobType = jobType;
        this.salary = salary;
        this.location = location;
        this.time = time;
        this.career = career;
        this.education = education;
        this.skill = skill;
    }
}
