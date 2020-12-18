package com.debarz.recipeblogapp.services.datajpa;

import com.debarz.recipeblogapp.domain.Person;
import com.debarz.recipeblogapp.repositories.PersonRepository;
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

    private final PersonRepository personRepository;

    @Override
    @Transactional
    public void saveImageFile(Long id, MultipartFile file) {
        try {
            Person person = personRepository.findById(id).get();

            Byte[] byteObjects = new Byte[file.getBytes().length];

            int i = 0;

            for (byte b : file.getBytes()){
                byteObjects[i++] = b;
            }

            person.setAvatarImage(byteObjects);

            personRepository.save(person);
        } catch (IOException e) {
            //todo handle better
            log.error("Error occurred", e);

            e.printStackTrace();
        }
    }
}
