package com.mountain.domain.support;

import com.mountain.domain.Category;

public class CategoryBuilder extends EntityBuilder<Category>{

	@Override
	void initProduct() {
	}

	@Override
	Category assembleProduct() {
		return product;
	}
	
	public CategoryBuilder name(String name)
	{
		this.product = new Category(name);
		return this;
	}

}
