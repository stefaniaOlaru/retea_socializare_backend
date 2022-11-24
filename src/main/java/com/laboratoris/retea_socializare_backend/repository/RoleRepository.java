package com.laboratoris.retea_socializare_backend.repository;

import com.laboratoris.retea_socializare_backend.model.ERole;
import com.laboratoris.retea_socializare_backend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(ERole name);
}
