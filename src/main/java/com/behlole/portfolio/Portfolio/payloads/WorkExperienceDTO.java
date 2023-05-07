package com.behlole.portfolio.Portfolio.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @NotBlank
    private String companyName;
    @NotBlank
    private String startDate;
    @NotBlank
    private String endDate;
    @NotBlank
    private String jobRole;
    @NotBlank
    private String companyIcon;
    @Size(min = 1, max = 10)
    private List<String> points = new ArrayList<>();
}
