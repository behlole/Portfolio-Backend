package com.behlole.portfolio.Portfolio.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "technologies")
@NoArgsConstructor
@Getter
@Setter
public class Technologies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String technologyName;
    private String technologyIcon;

}
