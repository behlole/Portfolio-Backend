package com.behlole.portfolio.Portfolio.controllers;

import com.behlole.portfolio.Portfolio.entities.WorkExperience;
import com.behlole.portfolio.Portfolio.payloads.ApiResponse;
import com.behlole.portfolio.Portfolio.payloads.WorkExperienceDTO;
import com.behlole.portfolio.Portfolio.repositories.WorkExperienceRepo;
import com.behlole.portfolio.Portfolio.services.WorkExperienceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/work-experience")
public class WorkExperienceController {
    @Autowired
    WorkExperienceService workExperienceService;

    @GetMapping("/")
    public ResponseEntity<List<WorkExperienceDTO>> getWorkExperiences() {
        return new ResponseEntity<>(this.workExperienceService.getWorkExperiences(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<WorkExperienceDTO> createWorkExperience(@Valid @RequestBody WorkExperienceDTO workExperienceDTO) {
        return new ResponseEntity<>(this.workExperienceService.createWorkExperience(workExperienceDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{experienceId}")
    public ResponseEntity<WorkExperienceDTO> createWorkExperience(@Valid @RequestBody WorkExperienceDTO workExperienceDTO, @PathVariable Long experienceId) {
        return new ResponseEntity<>(this.workExperienceService.updateWorkExperience(workExperienceDTO, experienceId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{experienceId}")
    public ResponseEntity<ApiResponse> deleteWorkExperience(@PathVariable Long experienceId) {
        this.workExperienceService.deleteWorkExperienceDTO(experienceId);
        return new ResponseEntity<>(new ApiResponse("Work Experience Deleted Successfully", true), HttpStatus.CREATED);
    }
}
