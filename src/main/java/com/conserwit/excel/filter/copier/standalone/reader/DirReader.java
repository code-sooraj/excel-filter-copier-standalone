package com.conserwit.excel.filter.copier.standalone.reader;

import org.springframework.core.io.PathResource;

import java.io.IOException;

public interface DirReader {

    public String getFileExtension();
    public PathResource[] getPathResources() throws IOException;
}
