package com.phase2.javaProject_Phase2.Repository;

import com.phase2.javaProject_Phase2.beans.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
