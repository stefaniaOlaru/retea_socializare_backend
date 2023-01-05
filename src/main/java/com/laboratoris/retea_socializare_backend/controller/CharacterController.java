package com.laboratoris.retea_socializare_backend.controller;

import com.laboratoris.retea_socializare_backend.dto.CharacterDTO;
import com.laboratoris.retea_socializare_backend.model.Character;
import com.laboratoris.retea_socializare_backend.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/character")
public class CharacterController {

    @Autowired
    ICharacterService ICharacterService;

    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Character> saveCharacter(@Valid @RequestBody CharacterDTO character){
        return ResponseEntity.ok(ICharacterService.saveCharacter(character));
    }

}
