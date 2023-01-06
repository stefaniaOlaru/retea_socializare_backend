package com.laboratoris.retea_socializare_backend.service;

import com.laboratoris.retea_socializare_backend.dto.MessageDTO;
import com.laboratoris.retea_socializare_backend.model.Message;
import com.laboratoris.retea_socializare_backend.model.User;
import com.laboratoris.retea_socializare_backend.repository.MessageRepository;
import com.laboratoris.retea_socializare_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class MessageService implements IMessageService{

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<MessageDTO> getMessages(org.springframework.security.core.userdetails.User authUser) {
        User user = userRepository.findByEmail(authUser.getUsername()).orElse(null);

        if(user == null) {
            throw new RuntimeException("User not found");
        }

        System.out.println(user.getEmail());

        return MessageDTO.from(messageRepository.findAllBySenderSectionOrderByDateDesc(user.getSection()));
    }

    @Override
    public MessageDTO saveMessage(String content, org.springframework.security.core.userdetails.User authUser) {
        User user = userRepository.findByEmail(authUser.getUsername()).orElse(null);

        if(user == null) {
            throw new RuntimeException("User not found");
        }

        Message message = new Message(content, user, new Date());
        return new MessageDTO(messageRepository.save(message));
    }
}
