package com.conserwit.excel.filter.copier.standalone.reader;

import com.conserwit.excel.filter.copier.standalone.data.vo.WorksheetCell;
import org.springframework.batch.extensions.excel.poi.PoiItemReader;
import org.springframework.core.io.PathResource;

import java.util.Map;

public class XlsxRowReader extends PoiItemReader<Map<String, WorksheetCell>> {

    public XlsxRowReader(PathResource pathResource, XlsxRowMapper xlsxRowMapper) {
        this.setLinesToSkip(1); // Skip Header
        this.setResource(pathResource);
        this.setRowMapper(xlsxRowMapper);
    }

}

