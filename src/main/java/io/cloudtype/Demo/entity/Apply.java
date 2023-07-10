package io.cloudtype.Demo.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "APPLY")
@Table(name = "APPLY")
public class Apply {
    @Id
    @Column(name = "APPLY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applyId;

    @ManyToOne
    @JoinColumn(name = "EMPLOY_ID", nullable = false, referencedColumnName = "EMPLOY_ID")
    private Employment employId;

    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "GENDER", nullable = false)
    private String gender;
    @Column(name = "BIRTH", nullable = false)
    private String birth;
    @Column(name = "PHONE_NO", nullable = false)
    private String phoneNo;
    @Column(name = "RESIDENCE", nullable = false)
    private String residence;
    @Column(name = "CAREER_YN", nullable = false)
    private String careerYn;
    @Column(name = "CONTENT_1", nullable = false)
    private String content1;
    @Column(name = "CONTENT_2", nullable = false)
    private String content2;
    @Column(name = "CONTENT_3", nullable = false)
    private String content3;
    @Column(name = "CONTENT_4", nullable = false)
    private String content4;

    @Builder
    public Apply(
            Employment employId,
            String name,
            String gender,
            String birth,
            String phoneNo,
            String residence,
            String careerYn,
            String content1,
            String content2,
            String content3,
            String content4
    ) {
        this.employId = employId;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.phoneNo = phoneNo;
        this.residence = residence;
        this.careerYn = careerYn;
        this.content1 = content1;
        this.content2 = content2;
        this.content3 = content3;
        this.content4 = content4;
    }

    public static Apply update(
            Long applyId,
            Employment employId,
            String name,
            String gender,
            String birth,
            String phoneNo,
            String residence,
            String careerYn,
            String content1,
            String content2,
            String content3,
            String content4
    ) {
        Apply apply = new Apply();
        apply.setApplyId(applyId);
        apply.setEmployId(employId);
        apply.setName(name);
        apply.setGender(gender);
        apply.setBirth(birth);
        apply.setPhoneNo(phoneNo);
        apply.setResidence(residence);
        apply.setCareerYn(careerYn);
        apply.setContent1(content1);
        apply.setContent2(content2);
        apply.setContent3(content3);
        apply.setContent4(content4);
        return apply;
    }



}
