package com.eduit.javaApi.repositories.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.eduit.javaApi.entities.Article;
import com.eduit.javaApi.repositories.interfaces.I_ArticleRepository;

public class ArticleRepository implements I_ArticleRepository {

	private Connection conn;
	
	public ArticleRepository (Connection conn) {
		this.conn = conn;
	}

	@Override
	public void save(Article article) {
		if(article == null) return;
		String statement = "insert into articles (name, price, stock) values (?, ?, ?);";
		try (PreparedStatement ps = conn.prepareStatement(statement, PreparedStatement.RETURN_GENERATED_KEYS)){
			ps.setString(1, article.getName());
			ps.setDouble(2, article.getPrice());
			ps.setInt(3, article.getStock());
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			while(rs.next()) {
				article.setId(rs.getInt(1));
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void remove(Article article) {
		throw new UnsupportedOperationException("Not supported yet.");	
	}

	@Override
	public List<Article> getAll() {
		List<Article> list = new ArrayList<>();
		String statement = "select * from articles";
		try(ResultSet rs = conn.createStatement().executeQuery(statement)){
			while(rs.next()) {
				list.add(
					new Article(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getDouble("price"),
						rs.getInt("stock")
					)
				);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return list;
	}

	@Override
	public Article getById(int id) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	
}
