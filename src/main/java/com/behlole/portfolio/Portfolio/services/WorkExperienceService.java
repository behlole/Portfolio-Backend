package com.behlole.portfolio.Portfolio.services;

import com.behlole.portfolio.Portfolio.payloads.WorkExperienceDTO;
import com.behlole.portfolio.Portfolio.repositories.WorkExperienceRepo;

import java.util.List;

public interface WorkExperienceService {
    WorkExperienceDTO createWorkExperience(WorkExperienceDTO workExperienceDTO);

    List<WorkExperienceDTO> getWorkExperiences();

    WorkExperienceDTO updateWorkExperience(WorkExperienceDTO workExperienceDTO, Long workExperienceId);

    void deleteWorkExperienceDTO(Long workExperienceId);
}
