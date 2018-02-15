package com.app.statistics.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass
public abstract class ResultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RESULT_ID")
    protected long id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="RESULT_GROUP_ID")
    protected ResultGroupEntity resultGroup;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="RESULT_META_ID")
    protected ResultMetaEntity meta;
}
