package org.example.warehouse10c.service;

import org.example.warehouse10c.dto.CategoryDto;
import org.example.warehouse10c.model.Category;
import org.example.warehouse10c.model.Result;
import org.example.warehouse10c.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;


    public List<Category> getAllCategory() {
        List<Category> list = categoryRepository.findAll();
        return list;
    }

    public Result create(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setCategoryId(categoryDto.getCategoryId());
        category.setActive(categoryDto.isActive());
        categoryRepository.save(category);
        return new Result(true, "Successfully");
    }

    public Result update(Integer id, CategoryDto categoryDto) {
        Optional<Category> optionalCategory
                = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            category.setName(categoryDto.getName());
            category.setCategoryId(categoryDto.getCategoryId());
            category.setActive(categoryDto.isActive());
            categoryRepository.save(category);
            return new Result(true, "Updated");
        }
        return new Result(false, "not found");
    }

    public Result delete(Integer id) {
        categoryRepository.deleteById(id);
        return new Result(true, "deleted");
    }


}
