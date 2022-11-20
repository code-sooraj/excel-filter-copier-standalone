package com.conserwit.excel.filter.copier.standalone.data.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

/**
 * This class represents a workbook.
 */
@AllArgsConstructor
public class Workbook {

    @Getter
    private Map<String, WorksheetCell> headerRow = null;
    @Getter
    private List<Map<String, WorksheetCell>> dataRows = null;

}
