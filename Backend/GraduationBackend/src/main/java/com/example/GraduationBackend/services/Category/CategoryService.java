package com.example.GraduationBackend.services.Category;

import com.example.GraduationBackend.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategory {

   private final CategoryRepository categoryRepository;


}
