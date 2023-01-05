package com.laboratoris.retea_socializare_backend.repository;

import com.laboratoris.retea_socializare_backend.model.Character;
import com.laboratoris.retea_socializare_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface CharacterRepository extends JpaRepository<Character, Integer> {
    Optional<Character> findById(Integer id);
}
