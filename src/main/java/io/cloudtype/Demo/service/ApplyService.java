package io.cloudtype.Demo.service;

import io.cloudtype.Demo.dto.apply.request.ApplyDto;
import io.cloudtype.Demo.entity.Apply;
import io.cloudtype.Demo.entity.Employment;
import io.cloudtype.Demo.repository.ApplyRepository;
import io.cloudtype.Demo.repository.EmploymentReopository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApplyService {
    @Autowired
    private ApplyRepository applyRepository;
    @Autowired
    EmploymentReopository employmentReopository;

    public List<ApplyDto> findAll() {
        return applyRepository.findAll().stream()
                .map(ApplyDto::new)
                .collect(Collectors.toList());
    }

    public ApplyDto getById(Long id) {
        Apply apply = applyRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return new ApplyDto(apply);
    }

   public void saveApply(ApplyDto request) {
       Employment employment = employmentReopository.findById(request.getEmployId()).orElseThrow(EntityNotFoundException::new);
       System.out.println("in save apply service");
       System.out.println(employment);
       //생성
       if (request.getApplyId() == null) {
           Apply apply = Apply.builder()
                   .employId(employment)
                   .name(request.getName())
                   .gender(request.getGender())
                   .birth(request.getBirth())
                   .phoneNo(request.getPhoneNo())
                   .residence(request.getResidence())
                   .careerYn(request.getCareerYn())
                   .content1(request.getContent1())
                   .content2(request.getContent2())
                   .content3(request.getContent3())
                   .content4(request.getContent4())
                   .build();
           applyRepository.save(apply);
       } else {
           //수정
           //아이디 값 확인
           Apply check = applyRepository.findById(request.getApplyId()).orElseThrow(EntityNotFoundException::new);
           System.out.println(check);
           Apply apply = Apply.update(
                   request.getApplyId(),
                   employment,
                   request.getName(),
                   request.getGender(),
                   request.getBirth(),
                   request.getPhoneNo(),
                   request.getResidence(),
                   request.getCareerYn(),
                   request.getContent1(),
                   request.getContent2(),
                   request.getContent3(),
                   request.getContent4()
           );
           applyRepository.save(apply);
       }
       
   }
}
