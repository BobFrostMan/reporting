package com.app.statistics.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class DashboardModel {
    private String id;
    private String name;
    private String description;
    private Date createDate;
    private Date updateDate;
}
