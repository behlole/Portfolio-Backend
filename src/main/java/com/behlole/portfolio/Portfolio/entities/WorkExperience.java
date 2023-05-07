package com.behlole.portfolio.Portfolio.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity()
@Table(name = "work_experiences")
@NoArgsConstructor
@Getter
@Setter
public class WorkExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String companyName;
    private String startDate;
    private String endDate;
    private String jobRole;
    private String companyIcon;
    @ElementCollection
    @CollectionTable(name = "points")
    @Column(name = "point")
    private List<String> points = new ArrayList<>();
}
