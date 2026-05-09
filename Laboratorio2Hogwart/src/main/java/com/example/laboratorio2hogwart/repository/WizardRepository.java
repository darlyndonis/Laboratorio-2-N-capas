package com.example.laboratorio2hogwart.repository;

import com.example.laboratorio2hogwart.domain.entity.Wizard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WizardRepository extends JpaRepository<Wizard, UUID> {
    List<Wizard> findByIsDeathEater(Boolean isDeathEater);
    List<Wizard> findByPatronus(String patronus);
}
