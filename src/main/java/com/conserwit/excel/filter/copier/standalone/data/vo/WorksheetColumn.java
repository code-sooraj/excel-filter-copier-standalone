package com.conserwit.excel.filter.copier.standalone.data.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * This class represents each cell in a worksheet.
 */
@Data
public class WorksheetColumn {
    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private int columnIndex;
    @Getter
    @Setter
    private String type;
    @Getter
    @Setter
    private boolean imported;
    @Getter
    @Setter
    private boolean exported;
}
