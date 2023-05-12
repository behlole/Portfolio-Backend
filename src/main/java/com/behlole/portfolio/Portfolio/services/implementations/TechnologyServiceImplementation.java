package com.behlole.portfolio.Portfolio.services.implementations;

import com.behlole.portfolio.Portfolio.payloads.TechnologiesDTO;
import com.behlole.portfolio.Portfolio.services.TechnologyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyServiceImplementation implements TechnologyService {
    @Override
    public TechnologiesDTO createTechnology(TechnologiesDTO technologiesDTO) {
        return null;
    }

    @Override
    public List<TechnologiesDTO> getTechnologies() {
        return null;
    }

    @Override
    public TechnologiesDTO updateTechnology(TechnologiesDTO technologiesDTO, Long technologyId) {
        return null;
    }

    @Override
    public void deleteTechnology(Long technologyId) {

    }
}
