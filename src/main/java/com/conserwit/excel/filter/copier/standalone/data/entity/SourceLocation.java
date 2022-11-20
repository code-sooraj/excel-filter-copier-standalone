package com.conserwit.excel.filter.copier.standalone.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "SOURCE_LOCATION")
public class SourceLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column(name = "SL_ID", nullable = false)
    @Getter
    @Setter
    private int id;
    @Column(name = "ROW_INDEX", nullable = false)
    @Getter
    @Setter
    private int rowIndex;
    @Column(name = "SHEET_INDEX", nullable = false)
    @Getter
    @Setter
    private int sheetIndex;
    @Column(name = "ORIGIN", nullable = false)
    @Getter
    @Setter
    private String origin;
}
