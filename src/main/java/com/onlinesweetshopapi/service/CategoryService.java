package com.onlinesweetshopapi.service;

import com.onlinesweetshopapi.domain.Category;
import com.onlinesweetshopapi.domain.Sweet;

public interface CategoryService {

	public Category save(Category category);
	public Iterable<Category> getCategories();
	public Category findCategoryByCategoryIdentifier(String categoryIdentifier);
	public void deleteCategoryByCategoryIdentifier(String categoryIdentifier);
}
