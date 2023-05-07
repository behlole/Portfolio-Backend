package com.behlole.portfolio.Portfolio.controllers;

import com.behlole.portfolio.Portfolio.entities.WorkExperience;
import com.behlole.portfolio.Portfolio.repositories.WorkExperienceRepo;
import com.behlole.portfolio.Portfolio.services.WorkExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/work-experience/")
public class WorkExperienceController {
    @Autowired
    WorkExperienceService workExperienceService;
}
