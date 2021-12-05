package com.onlinesweetshopapi.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinesweetshopapi.domain.Category;
import com.onlinesweetshopapi.exception.AdminIDException;
import com.onlinesweetshopapi.exception.CategoryIDException;
import com.onlinesweetshopapi.repository.CategoryRepository;
import com.onlinesweetshopapi.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category save(Category category) throws CategoryIDException {
		// TODO Auto-generated method stub
		try {
			category.setCategoryIdentifier(category.getCategoryIdentifier().toUpperCase());
		return categoryRepository.save(category);
		}
		catch(Exception ex)
		{
			throw new AdminIDException("CategoryId" + category.getCategoryIdentifier() + "is already available");
		}
	}

	@Override
	public Category findCategoryByCategoryIdentifier(String categoryIdentifier) {
		// TODO Auto-generated method stub
		Category category = categoryRepository.findByCategoryIdentifier(categoryIdentifier);
		return category;
	}

	@Override
	public void deleteCategoryByCategoryIdentifier(String categoryIdentifier) {
		// TODO Auto-generated method stub
		Category category = categoryRepository.findByCategoryIdentifier(categoryIdentifier);
		categoryRepository.delete(category);
		
	}

	@Override
	public Iterable<Category> getCategories() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}
	
	
	
}
