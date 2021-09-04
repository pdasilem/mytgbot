package ru.pdasilem.mytb.repository.entity;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name="tg_user")
public class TelegramUser {

    @Id
    @Column(name="chat_id")
    private String chatId;

    @Column(name="active")
    private boolean active;
}
