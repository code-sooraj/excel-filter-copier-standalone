package com.conserwit.excel.filter.copier.standalone.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "SOURCE_VALUE")
public class SourceValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column(name = "SV_ID", nullable = false)
    @Getter
    @Setter
    private int id;
    @ManyToOne
    @JoinColumn(name = "SL_ID", referencedColumnName = "SL_ID", nullable = false)
    @Getter
    @Setter
    private SourceLocation location;
    @ManyToOne
    @JoinColumn(name = "SA_ID", referencedColumnName = "SA_ID", nullable = false)
    @Getter
    @Setter
    private SourceAttribute attribute;
    @Column(name = "SV_VALUE", nullable = false)
    @Getter
    @Setter
    private String value;
}
