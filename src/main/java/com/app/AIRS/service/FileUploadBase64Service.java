package com.app.AIRS.service;

import com.app.AIRS.Enum.DataStorageConstant;
import com.app.AIRS.Utils.Base64ToMultipartFile;
import com.app.AIRS.dto.Nimc.ImageResolutionDto;
import com.app.AIRS.entity.FileModel;
import com.app.AIRS.service.cloud.FileLocationConstant;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class FileUploadBase64Service {
    private final Logger logger = Logger.getLogger(FileUploadBase64Service.class.getSimpleName());

    private final InitializeFileUploadService initializeFileUploadService;

    public FileUploadBase64Service(InitializeFileUploadService initializeFileUploadService) {
        this.initializeFileUploadService = initializeFileUploadService;
    }

    public FileModel upload(String base64) throws Exception {

        try {

            String dataStorageType = "";
            String fileLocation = "";
            String fileCode = "";

            try {
                dataStorageType = DataStorageConstant.DROP_BOX.toString();
                fileLocation = FileLocationConstant.MAIN_FOLDER_LOCATION;

            } catch (Exception e) {
                e.printStackTrace();
            }
            List<ImageResolutionDto> imageResolutionDtos = new ArrayList<ImageResolutionDto>();
            fileCode = this.initializeFileUploadService.generateFileUploadSequence();

            String dataUir = "data:image/png;base64";
            base64 = base64.replace("\n", "")
                    .replace("\r", "");
            base64 = base64.replaceAll(" ", "");
            // logger.info(base64);
            MultipartFile multipartFile = new Base64ToMultipartFile(base64, dataUir);
            logger.info(multipartFile.getContentType());
            logger.info(multipartFile.getOriginalFilename());

            return initializeFileUploadService.saveFile(
                    multipartFile,
                    "file_server",
                    imageResolutionDtos,
                    DataStorageConstant.valueOf(dataStorageType),
                    fileLocation,
                    fileCode);

        } catch (Exception e) {
            logger.info(e.getMessage());
            throw e;
        }

    }
}
