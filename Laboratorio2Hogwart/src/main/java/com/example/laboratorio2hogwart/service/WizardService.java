package com.example.laboratorio2hogwart.service;

import com.example.laboratorio2hogwart.domain.entity.Wizard;

import java.util.List;
import java.util.UUID;

public interface WizardService {
    void createWizard(Wizard wizard);
    List<Wizard> getAllWizards();
    List<Wizard> getDeathEaters();
    List<Wizard> getByPatronus(String patronus);
    void updateWizard(UUID id, Wizard wizard);
    void deleteWizard(UUID id);
}