package com.behlole.portfolio.Portfolio.repositories;

import com.behlole.portfolio.Portfolio.entities.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkExperienceRepo extends JpaRepository<WorkExperience, Long> {
}
