package com.conserwit.excel.filter.copier.standalone.config;

import com.conserwit.excel.filter.copier.standalone.data.mapper.WorksheetColumnMapper;
import com.conserwit.excel.filter.copier.standalone.data.vo.WorksheetColumn;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.util.List;

@RunWith(SpringRunner.class)
@TestPropertySource(properties = { "input.columnsDef=src/test/resources/columnsDef.yml" })
public class ColumnDefConfigTest {

    @TestConfiguration
    static class ColumnDefConfigTestConfiguration {
        @Bean
        public ColumnDefConfig columnDefConfig() {
            ColumnDefConfig columnDefConfig = new ColumnDefConfig();
            columnDefConfig.setColumnDefPath("src/test/resources/columnsDef.yml");
            columnDefConfig.setWorksheetColumnMapper(columnMapper());
            return columnDefConfig;
        }

        @Bean
        public WorksheetColumnMapper columnMapper() {
            return new WorksheetColumnMapper();
        }
    }

    @Autowired
    private ColumnDefConfig columnDefConfig;

    @Test
    public void testConfig() throws FileNotFoundException {

        List<WorksheetColumn> columnDefMap = columnDefConfig.getColumnDefList();
        System.out.println(columnDefMap);
    }

}
