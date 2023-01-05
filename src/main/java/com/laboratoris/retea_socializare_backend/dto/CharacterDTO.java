package com.laboratoris.retea_socializare_backend.dto;

import com.laboratoris.retea_socializare_backend.model.Character;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterDTO {
    private Integer id;
    private String name;
    private String image;

    public CharacterDTO(Character character) {
        this.id = character.getId();
        this.name = character.getName();
        this.image = character.getImage();
    }
}
