package com.ms.email.model;

import com.ms.email.model.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "emails")
@Entity @Getter @Setter @Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    UUID userId;
    String emailFrom;
    String emailTo;
    String subject;

    @Column(columnDefinition =  "TEXT")
    String text;

    LocalDateTime sendDateEmail;
    StatusEmail statusEmail;
}
