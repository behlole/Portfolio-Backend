package com.behlole.portfolio.Portfolio.repositories;

import com.behlole.portfolio.Portfolio.entities.Technologies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologiesRepo extends JpaRepository<Technologies, Long> {
}
