package com.laboratoris.retea_socializare_backend.service;

import com.laboratoris.retea_socializare_backend.dto.MessageDTO;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface IMessageService {
    List<MessageDTO> getMessages(User authUser);

    MessageDTO saveMessage(String content, User authUser);
}
