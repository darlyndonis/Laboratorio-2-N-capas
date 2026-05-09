package com.example.laboratorio2hogwart.service.impl;

import com.example.laboratorio2hogwart.domain.entity.Wizard;
import com.example.laboratorio2hogwart.repository.WizardRepository;
import com.example.laboratorio2hogwart.service.WizardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WizardServiceImpl implements WizardService {
    private final WizardRepository wizardRepository;

    @Override
    public void createWizard(Wizard wizard) {
        wizardRepository.save(wizard);
    }

    @Override
    public List<Wizard> getAllWizards() {
        return wizardRepository.findAll();
    }

    @Override
    public List<Wizard> getDeathEaters() {
        return wizardRepository.findByIsDeathEater(true);
    }

    @Override
    public List<Wizard> getByPatronus(String patronus) {
        return wizardRepository.findByPatronus(patronus);
    }

    @Override
    public void updateWizard(UUID id, Wizard wizard) {

        Wizard existingWizard = wizardRepository.findById(id)
                .orElseThrow();

        existingWizard.setName(wizard.getName());
        existingWizard.setHouse(wizard.getHouse());
        existingWizard.setPatronus(wizard.getPatronus());
        existingWizard.setIsDeathEater(wizard.getIsDeathEater());

        wizardRepository.save(existingWizard);
    }

    @Override
    public void deleteWizard(UUID id) {
        wizardRepository.deleteById(id);
    }
}
