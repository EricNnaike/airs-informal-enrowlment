package com.app.AIRS.service;

import com.app.AIRS.Enum.DataStorageConstant;

import java.io.File;
import java.io.IOException;

public interface FileUploadToRemoteServerService {
    DataStorageConstant getName();

    String upload(File localFile) throws IOException;
}
