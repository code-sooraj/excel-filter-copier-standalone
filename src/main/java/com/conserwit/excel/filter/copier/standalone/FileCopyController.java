package com.conserwit.excel.filter.copier.standalone;

import com.conserwit.excel.filter.copier.standalone.service.FileDataCopyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
public class FileCopyController {

    @Autowired
    private FileDataCopyService fileDataCopyService;

    /**
     * Start spreadsheet copy process.
     * @param fileExtension - extension of the files to be processed. put * for all extensions.
     * @return message.
     */
    @RequestMapping(value = "/file/{fileExtension}", method = RequestMethod.GET)
    public String process(@PathVariable String fileExtension) throws IOException,
            JobInstanceAlreadyCompleteException,
            JobExecutionAlreadyRunningException,
            JobParametersInvalidException,
            JobRestartException {
        return fileDataCopyService.copy(fileExtension);
    }

    /**
     * Delete the historical data of spreadsheet copy process.
     * @param fileExtension - extension of the files to be processed. put * for all extensions.
     * @return message.
     */
    @RequestMapping(value = "/file/{fileExtension}", method = RequestMethod.DELETE)
    private String clean(@PathVariable String fileExtension) {
        return null;
    }
}
