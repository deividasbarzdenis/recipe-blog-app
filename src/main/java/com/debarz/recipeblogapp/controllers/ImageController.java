package com.debarz.recipeblogapp.controllers;

import com.debarz.recipeblogapp.domain.Person;
import com.debarz.recipeblogapp.services.ImageService;
import com.debarz.recipeblogapp.services.PersonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
@AllArgsConstructor
@Controller
public class ImageController {

    private final ImageService imageService;
    private final PersonService personService;

    @GetMapping("person/{id}/image")
    public String showUploadForm(@PathVariable String id, Model model){
        model.addAttribute("person", personService.findById(Long.valueOf(id)));
        return "user/imageuploadform";
    }

    @PostMapping("person/{id}/image")
    public String handleImagePost(@PathVariable String id,
                                  @RequestParam("imagefile") MultipartFile file){

        imageService.saveImageFile(Long.valueOf(id), file);

        return "redirect:/person/" + id + "/show";
    }

    @GetMapping("person/{id}/personImage")
    public void renderImageFromDB(@PathVariable String id,
                                  HttpServletResponse response) throws IOException {
        Person person = personService.findById(Long.valueOf(id));
        if (person.getAvatarImage() != null) {
            byte[] byteArray = new byte[person.getAvatarImage().length];
            int i = 0;

            for (Byte wrappedByte : person.getAvatarImage()){
                byteArray[i++] = wrappedByte; //auto unboxing
            }

            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, response.getOutputStream());
        }
    }
}
