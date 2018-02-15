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
@Table(name = "RESULT_META")
public class ResultMetaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RESULT_META_ID")
    private long id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="RESULT_TYPE")
    private ResultTypeEntity type;
}
