package com.eduit.javaApi.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.eduit.javaApi.entities.Article;



public interface I_ArticleRepository {
	void save (Article article);
	void remove (Article article);
	List<Article> getAll ();
	Optional<Article> getById (int id);
	default List<Article> getLikeDescription (String description){
		if(description == null) return new ArrayList<Article>();
		return getAll()
					.stream()
					.filter(a -> a.getName().toLowerCase().contains(description.toLowerCase()))
					.collect(Collectors.toList());
	};
}
