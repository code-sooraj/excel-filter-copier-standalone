package com.conserwit.excel.filter.copier.standalone.data.mapper;

import com.conserwit.excel.filter.copier.standalone.data.vo.WorksheetColumn;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class WorksheetColumnMapper {

    public WorksheetColumn map(Map<String, Object> columnRawData, int columnIndex) {
        WorksheetColumn worksheetColumn = new WorksheetColumn();
        worksheetColumn.setId((String) columnRawData.get("id"));
        worksheetColumn.setColumnIndex(columnIndex);
        worksheetColumn.setName((String) columnRawData.get("name"));
        worksheetColumn.setType((String) columnRawData.get("type"));
        worksheetColumn.setImported((Boolean) columnRawData.get("import"));
        worksheetColumn.setExported((Boolean) columnRawData.get("export"));
        return worksheetColumn;
    }
}
