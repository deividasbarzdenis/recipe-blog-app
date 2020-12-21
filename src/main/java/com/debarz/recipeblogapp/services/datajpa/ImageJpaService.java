package com.debarz.recipeblogapp.services.datajpa;

import com.debarz.recipeblogapp.domain.User;
import com.debarz.recipeblogapp.repositories.UserRepository;
import com.debarz.recipeblogapp.services.ImageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@AllArgsConstructor
@Service
public class ImageJpaService implements ImageService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public void saveImageFile(Long id, MultipartFile file) {
        try {
            User user = userRepository.findById(id).get();

            Byte[] byteObjects = new Byte[file.getBytes().length];

            int i = 0;

            for (byte b : file.getBytes()){
                byteObjects[i++] = b;
            }

            user.setAvatarImage(byteObjects);

            userRepository.save(user);
        } catch (IOException e) {
            //todo handle better
            log.error("Error occurred", e);

            e.printStackTrace();
        }
    }
}
