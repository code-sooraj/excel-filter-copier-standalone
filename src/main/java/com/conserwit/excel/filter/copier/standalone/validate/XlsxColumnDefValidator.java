package com.conserwit.excel.filter.copier.standalone.validate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.file.Path;

@Component
public class XlsxColumnDefValidator implements ColumnDefValidator {

    @Value("${input.columnsDef}")
    private String columnDef;

    @Override
    public boolean validate(Path path) {
        return true;
    }
}
