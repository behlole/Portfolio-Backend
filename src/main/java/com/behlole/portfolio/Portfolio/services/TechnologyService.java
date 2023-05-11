package com.behlole.portfolio.Portfolio.services;

import com.behlole.portfolio.Portfolio.payloads.TechnologiesDTO;

import java.util.List;

public interface TechnologyService {

    TechnologiesDTO createTechnology(TechnologiesDTO technologiesDTO);

    List<TechnologiesDTO> getTechnologies();

    TechnologiesDTO updateTechnology(TechnologiesDTO technologiesDTO, Long technologyId);

    void deleteTechnology(Long technologyId);
}
