package com.conserwit.excel.filter.copier.standalone.processor;

import com.conserwit.excel.filter.copier.standalone.data.vo.WorksheetCell;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class XlsxRowProcessor implements ItemProcessor<Map<String, WorksheetCell>, Map<String, WorksheetCell>> {

    @Override
    public Map<String, WorksheetCell> process(Map<String, WorksheetCell> worksheetRow) throws Exception {
        return null;
    }
}
