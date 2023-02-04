package com.app.AIRS.service;

import com.app.AIRS.dto.FileUploadDto;
import com.app.AIRS.entity.FileModel;
import com.app.AIRS.entity.ImageResolution;

public interface FileUploadService {

    FileModel save(FileUploadDto fileUploadDto, String parentFileCode);

    FileModel findByCode(String code);

//    FileModel findByPortalAccount(String portalUserId);

    ImageResolution findByCodeAndWidthAndHeight(String code, int width, int height);

    void refresh(FileModel fileModel);
}
