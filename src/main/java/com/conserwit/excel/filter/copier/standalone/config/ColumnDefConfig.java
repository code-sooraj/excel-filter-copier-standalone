package com.conserwit.excel.filter.copier.standalone.config;

import com.conserwit.excel.filter.copier.standalone.data.mapper.WorksheetColumnMapper;
import com.conserwit.excel.filter.copier.standalone.data.vo.WorksheetColumn;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

@Component
public class ColumnDefConfig {

    @Value("${input.columnsDef}")
    @Getter
    @Setter
    private String columnDefPath;

    @Autowired
    @Getter
    @Setter
    private WorksheetColumnMapper worksheetColumnMapper;

    private List<WorksheetColumn> columnDefList;

    private void init() throws FileNotFoundException {
        if (Objects.isNull(this.columnDefList)) {
            this.columnDefList = read(columnDefPath);
        }
    }

    private List<WorksheetColumn> read(String columnDefPath) throws FileNotFoundException {
        return transform(new Yaml().load(new FileInputStream(columnDefPath)));
    }

    private List<WorksheetColumn> transform(Map<String, Object> fileRawData) {
        List<Map<String, Object>> allColumnsRawDataList = (List<Map<String, Object>>) fileRawData.get("columns");
        if (Objects.isNull(allColumnsRawDataList) || allColumnsRawDataList.isEmpty()) {
            throw new RuntimeException("Incorrect Configuration: Please configure column definitions to map");
        }
        return mapRow(allColumnsRawDataList);
    }

    private List<WorksheetColumn> mapRow(List<Map<String, Object>> allColumnsRawDataList) {
        List<WorksheetColumn> transformedColumnDataList = new ArrayList<>();
        for (ListIterator<Map<String, Object>> columnsIterator = allColumnsRawDataList.listIterator(); columnsIterator.hasNext();)  {
            int columnIndex = columnsIterator.nextIndex();
            Map<String, Object> columnRawData = columnsIterator.next();
            WorksheetColumn worksheetColumn = worksheetColumnMapper.map((Map<String, Object>) columnRawData.get("column"), columnIndex);
            transformedColumnDataList.add(worksheetColumn);
        }
        return transformedColumnDataList;
    }

    public List<WorksheetColumn> getColumnDefList() throws FileNotFoundException {
        init();
        return this.columnDefList;
    }
}
