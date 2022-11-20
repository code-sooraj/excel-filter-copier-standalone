package com.conserwit.excel.filter.copier.standalone;

import com.conserwit.excel.filter.copier.standalone.data.vo.WorksheetCell;
import com.conserwit.excel.filter.copier.standalone.processor.XlsxRowProcessor;
import com.conserwit.excel.filter.copier.standalone.reader.XlsxFilesDirReader;
import com.conserwit.excel.filter.copier.standalone.reader.XlsxRowMapper;
import com.conserwit.excel.filter.copier.standalone.reader.XlsxRowReader;
import com.conserwit.excel.filter.copier.standalone.writer.SourceDataWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.PathResource;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public XlsxRowProcessor xlsxRowProcessor;

    @Autowired
    private SourceDataWriter sourceDataWriter;

    @Autowired
    private XlsxFilesDirReader xlsxFilesDirReader;

    @Autowired
    private XlsxRowMapper xlsxRowMapper;

    @Bean
    public Job xlsxFilesJob() throws IOException {
        return jobBuilderFactory.get("XlsxFilesJob")
                .incrementer(new RunIdIncrementer())
                .start(xlsxFileStep()).build();
    }

    @Bean
    public Step xlsxFileStep() throws IOException {
        return stepBuilderFactory.get("XlsxFileStep")
                .<Map<String, WorksheetCell>, Map<String, WorksheetCell>>chunk(1)
                .reader(xlsxRowReader())
                .processor(xlsxRowProcessor)
                .writer(sourceDataWriter)
                .build();
    }

    @Bean
    public XlsxRowReader xlsxRowReader() throws IOException {
        PathResource pathResource = xlsxFilesDirReader.getPathResources()[0];
        return new XlsxRowReader(pathResource, xlsxRowMapper);
    }
}
