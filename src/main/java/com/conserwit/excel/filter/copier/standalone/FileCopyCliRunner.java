package com.conserwit.excel.filter.copier.standalone;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
public class FileCopyCliRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        if (Objects.isNull(args) || args.length == 0) {
            log.error("Pass at least one file extension as CLI parameter");
        }

    }
}
