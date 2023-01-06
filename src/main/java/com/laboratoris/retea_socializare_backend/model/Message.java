package com.laboratoris.retea_socializare_backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    @ManyToOne
    private User sender;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Message(String content, User sender, Date date) {
        this.content = content;
        this.sender = sender;
        this.date = date;
    }

}
