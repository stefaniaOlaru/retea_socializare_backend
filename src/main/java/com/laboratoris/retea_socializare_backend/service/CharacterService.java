package com.laboratoris.retea_socializare_backend.service;

import com.laboratoris.retea_socializare_backend.dto.CharacterDTO;
import com.laboratoris.retea_socializare_backend.model.Character;
import com.laboratoris.retea_socializare_backend.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService implements ICharacterService {

    @Autowired
    CharacterRepository characterRepository;

    @Override
    public Character saveCharacter(CharacterDTO character) {
        return characterRepository.save(new Character(character.getName(), character.getImage()));
    }

    @Override
    public Character findById(Integer id) {
        return characterRepository.findById(id).orElse(null);
    }
}
