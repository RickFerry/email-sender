package com.ms.user.model.dto;

import com.ms.user.model.User;

import java.util.UUID;

public record EmailDto(
        UUID userId,
        String emailTo,
        String subject,
        String text
) {
    public EmailDto(User user) {
        this(user.getId(), user.getEmail(),
                "Cadastro realizado com sucesso", user.getName() + " seja bem vindo!");
    }
}
