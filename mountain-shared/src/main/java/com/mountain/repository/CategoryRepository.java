package com.mountain.repository;

import java.util.List;

import com.mountain.domain.Category;

public interface CategoryRepository {
	List<Category> findAll();

	Category findById(long id);

	void storeCategory(Category category);
}
