package com.debarz.recipeblogapp.services;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    void saveImageFile(Long id, MultipartFile file);

}
