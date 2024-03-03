package com.phase2.javaProject_Phase2.clr.clrCategory;

import com.phase2.javaProject_Phase2.Repository.CategoryRepository;
import com.phase2.javaProject_Phase2.beans.Category;
import com.phase2.javaProject_Phase2.beans.EnumCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Order(16)
public class addCategory implements CommandLineRunner {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("------------- CATEGORIES -------------");
        Category category1 = Category.builder()
                .enumCategory(EnumCategory.ELECTRICITY)
                .build();

        Category category2 = Category.builder()
                .enumCategory(EnumCategory.FOOD)
                .build();

        Category category3 = Category.builder()
                .enumCategory(EnumCategory.RESTAURANT)
                .build();

        Category category4 = Category.builder()
                .enumCategory(EnumCategory.VACATION)
                .build();

        categoryRepository.saveAll(Arrays.asList(category1,category2,category3,category4));
        System.out.println("Categories added!");
        System.out.println();
    }
}
