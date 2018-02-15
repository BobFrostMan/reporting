package com.app.statistics.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection="users")
public class UserEntity {
    @Id
    private String id;

    private String name;
}