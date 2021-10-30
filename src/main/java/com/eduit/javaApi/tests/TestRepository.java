package com.eduit.javaApi.tests;

import com.eduit.javaApi.repositories.db.ArticleRepository;
import com.eduit.javaApi.repositories.interfaces.I_ArticleRepository;
import com.eduit.javaApi.connector.Connector;
import com.eduit.javaApi.entities.Article;

public class TestRepository {
	public static void main (String[] args) {
		I_ArticleRepository art = new ArticleRepository(Connector.getConnection());
		

		art.save(new Article("Carpa", 600, 20));
		art.save(new Article("Lampara", 450, 10));
		art.save(new Article("Conservadora", 200, 6));

		art.getAll().forEach(System.out::println);
		System.out.println("Proceso terminado");
	}
}
