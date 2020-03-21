package de.coronavirus.domain.infrastructure.repositories;

import de.coronavirus.application.dtos.service.JobDTO;
import de.coronavirus.domain.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job,Long> {

    List<JobDTO> findAllDtoBy();
    Optional<JobDTO> findDtoById(Long id);
}
