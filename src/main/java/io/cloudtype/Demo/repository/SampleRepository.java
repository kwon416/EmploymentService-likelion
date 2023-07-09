package io.cloudtype.Demo.repository;

import io.cloudtype.Demo.entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository extends JpaRepository<Sample, Long> {

}
