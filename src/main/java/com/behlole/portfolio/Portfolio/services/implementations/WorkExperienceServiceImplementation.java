package com.behlole.portfolio.Portfolio.services.implementations;

import com.behlole.portfolio.Portfolio.entities.WorkExperience;
import com.behlole.portfolio.Portfolio.exceptions.ResourceNotFoundException;
import com.behlole.portfolio.Portfolio.payloads.WorkExperienceDTO;
import com.behlole.portfolio.Portfolio.repositories.WorkExperienceRepo;
import com.behlole.portfolio.Portfolio.services.WorkExperienceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@Service
public class WorkExperienceServiceImplementation implements WorkExperienceService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    WorkExperienceRepo workExperienceRepo;
    @Value("${server.port}")
    String port;

    @Override
    public WorkExperienceDTO createWorkExperience(WorkExperienceDTO workExperienceDTO) {
        WorkExperience workExperience = this.workExperienceRepo.save(this.modelMapper.map(workExperienceDTO, WorkExperience.class));
        return this.modelMapper.map(workExperience, WorkExperienceDTO.class);
    }

    @Override
    public List<WorkExperienceDTO> getWorkExperiences() {
        List<WorkExperience> workExperiences = this.workExperienceRepo.findAll();
        return workExperiences.stream().map(workExperience -> {
                    try {
                        workExperience.setCompanyIcon(
                                InetAddress.getLocalHost().getHostAddress() + ":" + port +
                                        "/images/" +
                                        workExperience.getCompanyIcon()
                        );
                    } catch (UnknownHostException e) {
                        throw new RuntimeException(e);
                    }
                    return this.modelMapper.map(workExperience, WorkExperienceDTO.class);
                }
        ).toList();
    }

    @Override
    public WorkExperienceDTO updateWorkExperience(WorkExperienceDTO workExperienceDTO, Long workExperienceId) {
        WorkExperience foundWorkExperience = this.workExperienceRepo.findById(workExperienceId).orElseThrow(() -> new ResourceNotFoundException("Work Experience", "ID", workExperienceId));
        WorkExperience updatedWorkExperience = this.modelMapper.map(workExperienceDTO, WorkExperience.class);
        foundWorkExperience.setCompanyIcon(updatedWorkExperience.getCompanyIcon());
        foundWorkExperience.setPoints(updatedWorkExperience.getPoints());
        foundWorkExperience.setCompanyName(updatedWorkExperience.getCompanyName());
        foundWorkExperience.setEndDate(updatedWorkExperience.getEndDate());
        foundWorkExperience.setStartDate(updatedWorkExperience.getStartDate());
        foundWorkExperience.setJobRole(updatedWorkExperience.getJobRole());
        this.workExperienceRepo.save(foundWorkExperience);
        return this.modelMapper.map(foundWorkExperience, WorkExperienceDTO.class);
    }

    @Override
    public void deleteWorkExperienceDTO(Long workExperienceId) {
        WorkExperience foundWorkExperience = this.workExperienceRepo.findById(workExperienceId).orElseThrow(() -> new ResourceNotFoundException("Work Experience", "ID", workExperienceId));
        this.workExperienceRepo.delete(foundWorkExperience);
    }
}
