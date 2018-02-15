package com.app.statistics.entity;

import com.app.statistics.annotation.ResultMapping;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
@Table(name = "TEST_RESULT")
@ResultMapping(groupName = "GROUP1", typeName = "TYPE3")
public class TestResultEntity extends ResultEntity {
    @Column(name = "TEST_FIELD")
    private String testField;
}
