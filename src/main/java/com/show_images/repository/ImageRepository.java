package com.show_images.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.show_images.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long>{
	 List<Image> findByIduser(String id_user);//, String id_user
	 List<Image> findByPrivacy(boolean privacy);
}
