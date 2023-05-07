package com.behlole.portfolio.Portfolio.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class WorkExperienceDTO {
    private Long id;
    private String companyName;
    private String startDate;
    private String endDate;
    private String jobRole;
    private String companyIcon;
    private List<String> points = new ArrayList<>();
}
