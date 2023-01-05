package com.laboratoris.retea_socializare_backend.service;

import com.laboratoris.retea_socializare_backend.dto.CharacterDTO;
import com.laboratoris.retea_socializare_backend.model.Character;

public interface ICharacterService {
    Character saveCharacter(CharacterDTO character);
    Character findById(Integer id);
}
