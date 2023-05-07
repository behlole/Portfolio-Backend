package com.behlole.portfolio.Portfolio.services.implementations;

import com.behlole.portfolio.Portfolio.entities.WorkExperience;
import com.behlole.portfolio.Portfolio.payloads.WorkExperienceDTO;
import com.behlole.portfolio.Portfolio.repositories.WorkExperienceRepo;
import com.behlole.portfolio.Portfolio.services.WorkExperienceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkExperienceServiceImplementation implements WorkExperienceService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    WorkExperienceRepo workExperienceRepo;

    @Override
    public WorkExperienceDTO createWorkExperience(WorkExperienceDTO workExperienceDTO) {
        WorkExperience workExperience = this.workExperienceRepo.save(this.modelMapper.map(workExperienceDTO, WorkExperience.class));
        return this.modelMapper.map(workExperience, WorkExperienceDTO.class);
    }

    @Override
    public List<WorkExperienceDTO> getWorkExperiences() {
        return null;
    }

    @Override
    public WorkExperienceDTO updateWorkExperience(WorkExperienceDTO workExperienceDTO, Long workExperienceId) {
        return null;
    }

    @Override
    public void deleteWorkExperienceDTO(Long workExperienceId) {

    }
}
