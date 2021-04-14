package com.github.marivaldosena.mercadolivre.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(CategoryController.RESOURCE_URL)
public class CategoryController {
    public final static String RESOURCE_URL = "/api/v1/categories";
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<NewCategoryDto> createCategory(@RequestBody @Valid CreateCategoryRequest request, UriComponentsBuilder uriBuilder) {
        Category newCategory = request.toEntity();

        // If request has parentCategory, it means it has passed validation
        if (StringUtils.hasText(request.getParentCategory())) {
            Optional<Category> parentCategory = categoryRepository.findByName(request.getParentCategory());
            newCategory.setParentCategory(parentCategory.get());
        }

        categoryRepository.save(newCategory);
        URI uri = uriBuilder.path(RESOURCE_URL + "/{id}").buildAndExpand(newCategory.getId()).toUri();

        return ResponseEntity.ok().location(uri).body(new NewCategoryDto(newCategory));
    }
}
