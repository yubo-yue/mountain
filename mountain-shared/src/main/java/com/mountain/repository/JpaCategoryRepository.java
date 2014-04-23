package com.mountain.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.mountain.domain.Category;

public class JpaCategoryRepository  implements CategoryRepository{


	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Category> findAll() {
		String hql = "select c from Category c order by c.name";
		TypedQuery<Category> query = this.entityManager.createQuery(hql, Category.class);
		return query.setHint("org.hibernate.cacheable", true).getResultList();
	}

	@Override
	public Category findById(long id) {
		return this.entityManager.find(Category.class, id);
	}

	@Override
	public void storeCategory(Category category) {
		entityManager.persist(category);
	}

}
