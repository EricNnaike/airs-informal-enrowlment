package com.app.AIRS.service;

import com.app.AIRS.entity.ImageResolution;

import java.util.List;

public interface ImageResolutionService {
    ImageResolution findByFileCodeAndWidth(String code, int width);

    ImageResolution findByFileCodeAndHeight(String code, int height);

    ImageResolution findByFileCode(String code);

    List<ImageResolution> findByCode(String code);
}
