package com.behlole.portfolio.Portfolio.payloads;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TechnologiesDTO {
    private long id;
    @NotBlank
    private String technologyName;
    @NotBlank
    private String technologyIcon;
}
