package com.laboratoris.retea_socializare_backend.controller;

import com.laboratoris.retea_socializare_backend.dto.JwtResponse;
import com.laboratoris.retea_socializare_backend.dto.MessageDTO;
import com.laboratoris.retea_socializare_backend.dto.SendMessageRequest;
import com.laboratoris.retea_socializare_backend.model.Message;
import com.laboratoris.retea_socializare_backend.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/latest-messages")
    public ResponseEntity<List<MessageDTO>> getLatestMessages(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(messageService.getMessages(user));
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/send-message")
    public ResponseEntity<MessageDTO> sendMessage(@AuthenticationPrincipal User user, @RequestBody SendMessageRequest sendMessageRequest) {
        return ResponseEntity.ok(messageService.saveMessage(sendMessageRequest.getContent(), user));
    }

}
