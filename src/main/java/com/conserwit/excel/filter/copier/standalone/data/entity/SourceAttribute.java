package com.conserwit.excel.filter.copier.standalone.data.entity;

import javax.persistence.*;

@Entity(name = "SOURCE_ATTRIBUTE")
public class SourceAttribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column(name = "SA_ID", nullable = false)
    public int id;
    @Column(name = "SA_NAME", nullable = false)
    public String name;
    @Column(name = "SA_TYPE", nullable = false)
    public String type;
}
