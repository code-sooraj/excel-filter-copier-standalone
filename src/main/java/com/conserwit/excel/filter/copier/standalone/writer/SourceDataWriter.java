package com.conserwit.excel.filter.copier.standalone.writer;

import com.conserwit.excel.filter.copier.standalone.data.vo.WorksheetCell;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SourceDataWriter implements ItemWriter<Map<String, WorksheetCell>> {

    @Override
    public void write(List<? extends Map<String, WorksheetCell>> list) throws Exception {

    }
}
