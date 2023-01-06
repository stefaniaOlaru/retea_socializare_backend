package com.laboratoris.retea_socializare_backend.dto;

import com.laboratoris.retea_socializare_backend.model.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {
    private Integer id;
    private String content;
    private UserDTO sender;
    private Date date;

    public MessageDTO(Message message) {
        this.id = message.getId();
        this.content = message.getContent();
        this.sender = new UserDTO(message.getSender());
        this.date = message.getDate();
    }

    public static List<MessageDTO> from(List<Message> messages) {
        return messages.stream().map(MessageDTO::new).toList();
    }
}
