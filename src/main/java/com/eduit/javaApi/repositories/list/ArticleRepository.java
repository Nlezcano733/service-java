package com.eduit.javaApi.repositories.list;

import java.util.ArrayList;
import java.util.List;

import com.eduit.javaApi.entities.Article;
import com.eduit.javaApi.repositories.interfaces.I_ArticleRepository;

public class ArticleRepository implements I_ArticleRepository {
	
	private List<Article> list = new ArrayList();

	@Override
	public void save(Article article) {
		list.add(article);		
	}

	@Override
	public void remove(Article article) {
		list.remove(article);
		
	}

	@Override
	public List<Article> getAll() {
		return list;
	}

	@Override
	public Article getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
