package com.laboratoris.retea_socializare_backend.dto;

import com.laboratoris.retea_socializare_backend.model.Section;
import com.laboratoris.retea_socializare_backend.model.User;
import com.laboratoris.retea_socializare_backend.model.Character;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private Section section;
    private Character character;

    public UserDTO(User user) {
        this.id = user.getId();
        this.section = user.getSection();
        this.character = user.getCharacter();
    }
}
