package com.conserwit.excel.filter.copier.standalone.service;

import com.conserwit.excel.filter.copier.standalone.reader.DirReader;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.PathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class FileDataCopyService {

    @Value("${input.dir}")
    @Getter
    private String inputDir;

    @Autowired
    private DirReader dirReader;

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    public String copy(String fileExtension) throws IOException, JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        PathResource[] paths = dirReader.getPathResources();
        if (paths.length == 0) {
            //TODO: Use parameters in log statement
            log.warn("No files found with extension " + fileExtension);
            return "No files found with extension " + fileExtension;
        }

        for (PathResource pathResource : paths) {
            JobParameters jobParameters = new JobParametersBuilder().addString("extension", fileExtension)
                    .addString("path", pathResource.getPath().toString()).toJobParameters();
            JobExecution execution = jobLauncher.run(job, jobParameters);
        }

        return null;
    }

}
