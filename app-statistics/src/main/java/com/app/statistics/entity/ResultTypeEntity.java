package com.app.statistics.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "RESULT_TYPE")
public class ResultTypeEntity {
    public ResultTypeEntity(String typeName) {
        this.typeName = typeName;
    }

    @Id
    @Column(name = "RESULT_TYPE_NAME")
    private String typeName;
}
