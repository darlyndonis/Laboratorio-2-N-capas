package com.example.laboratorio2hogwart.controller;

import com.example.laboratorio2hogwart.domain.entity.Wizard;
import com.example.laboratorio2hogwart.service.impl.WizardServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/wizards")
@AllArgsConstructor
public class WizardController {
    private final WizardServiceImpl wizardService;

    // Crear mago
    @PostMapping
    public ResponseEntity<Wizard> createWizard(
            @RequestBody Wizard wizard){

        wizardService.createWizard(wizard);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(wizard);
    }

    // Obtener todos
    @GetMapping
    public ResponseEntity<List<Wizard>> getAllWizards(){

        return ResponseEntity.ok(
                wizardService.getAllWizards()
        );
    }

    // Obtener mortífagos
    @GetMapping("/deatheaters")
    public ResponseEntity<List<Wizard>> getDeathEaters(){

        return ResponseEntity.ok(
                wizardService.getDeathEaters()
        );
    }

    // Obtener por patronus
    @GetMapping("/patronus/{patronus}")
    public ResponseEntity<List<Wizard>> getByPatronus(
            @PathVariable String patronus){

        return ResponseEntity.ok(
                wizardService.getByPatronus(patronus)
        );
    }

    // Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<String> updateWizard(
            @PathVariable UUID id,
            @RequestBody Wizard wizard){

        wizardService.updateWizard(id, wizard);

        return ResponseEntity.ok("Wizard updated");
    }

    // Eliminar
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteWizard(
            @PathVariable UUID id){

        wizardService.deleteWizard(id);

        return ResponseEntity.ok("Wizard deleted");
    }
}

