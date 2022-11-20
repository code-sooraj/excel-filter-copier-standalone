package com.conserwit.excel.filter.copier.standalone.reader;

import com.conserwit.excel.filter.copier.standalone.validate.ColumnDefValidator;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.PathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
@Data
public class XlsxFilesDirReader implements DirReader {

    @Value("${input.dir}")
    private String inputDir;

    @Autowired
    private ColumnDefValidator columnDefValidator;

    @Override
    public String getFileExtension() {
        return "xlsx";
    }

    @Override
    public PathResource[] getPathResources() throws IOException {
        try (Stream<Path> stream = Files.list(Paths.get(getInputDir()))) {
            return stream.filter(path -> !Files.isDirectory(path))
                    .filter(path -> path.getFileName().toString().endsWith("." + getFileExtension()))
                    .filter(path -> columnDefValidator.validate(path))
                    .map(path -> new PathResource(path))
                    .toArray(PathResource[]::new);
        }
    }

}
