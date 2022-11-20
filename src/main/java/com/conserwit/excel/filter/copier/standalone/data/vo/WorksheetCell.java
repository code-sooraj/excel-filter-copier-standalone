package com.conserwit.excel.filter.copier.standalone.data.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * This class represents each cell in a worksheet.
 */
@Data
public class WorksheetCell {
    @Getter
    @Setter
    private int rowIndex;
    @Getter
    @Setter
    private String value;
    @Getter
    @Setter
    private WorksheetColumn column;
}
