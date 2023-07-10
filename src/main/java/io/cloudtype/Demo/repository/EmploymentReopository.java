package io.cloudtype.Demo.repository;

import io.cloudtype.Demo.entity.Employment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploymentReopository extends JpaRepository<Employment, Long> {

}
