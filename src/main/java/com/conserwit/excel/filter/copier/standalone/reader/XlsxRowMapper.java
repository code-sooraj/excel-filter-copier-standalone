package com.conserwit.excel.filter.copier.standalone.reader;

import com.conserwit.excel.filter.copier.standalone.config.ColumnDefConfig;
import com.conserwit.excel.filter.copier.standalone.data.vo.WorksheetCell;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.map.HashedMap;
import org.springframework.batch.extensions.excel.RowMapper;
import org.springframework.batch.extensions.excel.support.rowset.RowSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Properties;

@Component
@AllArgsConstructor
public class XlsxRowMapper implements RowMapper<Map<String, WorksheetCell>> {

    @Autowired
    private ColumnDefConfig columnDefConfig;

    @Override
    public Map<String, WorksheetCell> mapRow(RowSet rowSet) throws Exception {
        Properties properties = rowSet.getProperties();
        Map<String, WorksheetCell> rowMap = new HashedMap<>();

        return rowMap;
    }

}
