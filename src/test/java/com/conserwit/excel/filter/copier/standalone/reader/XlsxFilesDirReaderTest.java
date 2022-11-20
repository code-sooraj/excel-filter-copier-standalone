package com.conserwit.excel.filter.copier.standalone.reader;

import com.conserwit.excel.filter.copier.standalone.validate.ColumnDefValidator;
import com.conserwit.excel.filter.copier.standalone.validate.XlsxColumnDefValidator;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.io.PathResource;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class XlsxFilesDirReaderTest {

    @Mock
    private ColumnDefValidator columnDefValidator;

    @Test
    void testGetValidFiles() throws IOException {
        reset(columnDefValidator);
        when(columnDefValidator.validate(any(Path.class))).thenReturn(true);
        XlsxFilesDirReader xlsxFilesDirReader = new XlsxFilesDirReader();
        xlsxFilesDirReader.setInputDir(Paths.get("src",
                "test", "resources", "filteredReaderDir").toString());
        xlsxFilesDirReader.setColumnDefValidator(columnDefValidator);
        PathResource[] paths = xlsxFilesDirReader.getPathResources();
        assertEquals(1, paths.length);
    }
}
