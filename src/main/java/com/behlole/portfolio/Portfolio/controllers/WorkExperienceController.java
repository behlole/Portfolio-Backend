package com.behlole.portfolio.Portfolio.controllers;

import com.behlole.portfolio.Portfolio.payloads.ApiResponse;
import com.behlole.portfolio.Portfolio.payloads.WorkExperienceDTO;
import com.behlole.portfolio.Portfolio.services.FileService;
import com.behlole.portfolio.Portfolio.services.WorkExperienceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/work-experience")
public class WorkExperienceController {
    @Autowired
    WorkExperienceService workExperienceService;
    @Autowired
    FileService fileService;

    @Value("${project.image}")
    private String path;

    @GetMapping("/")
    public ResponseEntity<List<WorkExperienceDTO>> getWorkExperiences() {
        return new ResponseEntity<>(this.workExperienceService.getWorkExperiences(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<WorkExperienceDTO> createWorkExperience(
            @Valid @RequestParam("companyIcon") MultipartFile companyIcon,
            @Valid @RequestParam("companyName") String companyName,
            @Valid @RequestParam("startDate") String startDate,
            @Valid @RequestParam("endDate") String endDate,
            @Valid @RequestParam("jobRole") String jobRole,
            @Valid @RequestParam("points") List<String> points
    ) throws IOException {

        WorkExperienceDTO workExperienceDTO = createWorkDTOWithFile(
                companyIcon,
                companyName,
                startDate,
                endDate,
                jobRole,
                points);
        return new ResponseEntity<>(this.workExperienceService.createWorkExperience(workExperienceDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{experienceId}")
    public ResponseEntity<WorkExperienceDTO> updateWorkExperience(
            @Valid @RequestParam("companyIcon") MultipartFile companyIcon,
            @Valid @RequestParam("companyName") String companyName,
            @Valid @RequestParam("startDate") String startDate,
            @Valid @RequestParam("endDate") String endDate,
            @Valid @RequestParam("jobRole") String jobRole,
            @Valid @RequestParam("points") List<String> points,
            @PathVariable Long experienceId
    ) throws IOException {
        WorkExperienceDTO workExperienceDTO = createWorkDTOWithFile(
                companyIcon,
                companyName,
                startDate,
                endDate,
                jobRole,
                points);
        return new ResponseEntity<>(this.workExperienceService.updateWorkExperience(workExperienceDTO, experienceId), HttpStatus.CREATED);
    }

    private WorkExperienceDTO createWorkDTOWithFile(
            MultipartFile companyIcon,
            String companyName,
            String startDate,
            String endDate,
            String jobRole,
            List<String> points
    ) throws IOException {
        String filename = this.fileService.uploadImage(path, companyIcon);
        WorkExperienceDTO workExperienceDTO = new WorkExperienceDTO();
        workExperienceDTO.setCompanyIcon(filename);
        workExperienceDTO.setEndDate(endDate);
        workExperienceDTO.setCompanyName(companyName);
        workExperienceDTO.setPoints(points);
        workExperienceDTO.setJobRole(jobRole);
        workExperienceDTO.setStartDate(startDate);
        return workExperienceDTO;
    }

    @DeleteMapping("/{experienceId}")
    public ResponseEntity<ApiResponse> deleteWorkExperience(@PathVariable Long experienceId) {
        this.workExperienceService.deleteWorkExperienceDTO(experienceId);
        return new ResponseEntity<>(new ApiResponse("Work Experience Deleted Successfully", true), HttpStatus.CREATED);
    }
}
