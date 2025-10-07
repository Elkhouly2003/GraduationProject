package com.example.GraduationBackend.services.Image;

import com.example.GraduationBackend.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageService  implements IImage{
   private final ImageRepository imageRepository;

}
