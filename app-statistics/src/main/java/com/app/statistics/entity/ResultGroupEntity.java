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
@Table(name = "RESULT_GROUP")
public class ResultGroupEntity {

    public ResultGroupEntity(String groupName) {
        this.groupName = groupName;
    }

    @Id
    @Column(name = "RESULT_GROUP_NAME")
    private String groupName;
}
