package com.show_images.controller;

import com.show_images.model.Image;
import com.show_images.model.Render;
import com.show_images.repository.ImageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@RestController
// @RequestMapping("/api")
public class ImageController {

    @Autowired
    ImageRepository imageRepository;

    @GetMapping
    public final String hola() throws UnknownHostException {
        return "Hola! Puedes encontrarme en " + InetAddress.getLocalHost().getHostAddress();
    }

    @GetMapping("/images")
    public ResponseEntity<Render> getAllImagesPublic() {
        List<Image> images = imageRepository.findByPrivacy(false);
        Render render = new Render();
        if (images.isEmpty()) {
            render.setData(images);
            render.setErrors("{errors}");
            return new ResponseEntity(render, HttpStatus.OK);
        }else{
            render.setData(images);
            render.setErrors("{}");
            return new ResponseEntity<Render>(render, HttpStatus.OK);
        }
	}
	
    @GetMapping("/images/{id_user}")
    public ResponseEntity<Render> getAllImagesPublic(@PathVariable(value = "id_user") String id_user) {
        List<Image> images =  imageRepository.findByIduser(id_user); 	   		
        Render render = new Render();
        if (images.isEmpty()) {
            if(id_user!=null){
                render.setData(images);
                render.setErrors("{Id user no puede ser nulo}");
                return new ResponseEntity(render, HttpStatus.OK);
            }else{
                render.setData(images);
                render.setErrors("{No se encontró imagenes para este usuario}");
                return new ResponseEntity(render, HttpStatus.OK);
            }
        }else{
            render.setData(images);
            render.setErrors("{}");
            return new ResponseEntity<Render>(render, HttpStatus.OK);
        }
    }
}
