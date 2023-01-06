package com.laboratoris.retea_socializare_backend.repository;

import com.laboratoris.retea_socializare_backend.model.Message;
import com.laboratoris.retea_socializare_backend.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    // find all messages by section and order by date
    List<Message> findAllBySenderSectionOrderByDateDesc(Section section);
}

