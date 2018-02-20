package com.app.statistics.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Document(collection = "DASHBOARD")
public class DashboardEntity {
    @Id
    private String id;
    private String name;
    private String description;
    private Date createDate;
    private Date updateDate;
}
