package com.conserwit.excel.filter.copier.standalone.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class FileDataCleanService {

    @Autowired
    private JobLauncher jobLauncher;

    public String clean(String fileExtension) {
        return null;
    }
}
