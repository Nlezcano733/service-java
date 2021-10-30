package com.eduit.javaApi.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduit.javaApi.connector.Connector;
import com.eduit.javaApi.entities.Article;
import com.eduit.javaApi.repositories.db.ArticleRepository;
import com.eduit.javaApi.repositories.interfaces.I_ArticleRepository;
import com.google.gson.Gson;


@WebServlet("/new")
public class NewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn =  Connector.getConnection();
	private I_ArticleRepository art = new ArticleRepository(conn);

	protected void proccessRequest (HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		res.setContentType("application/json;charset=UTF-8");
		try(PrintWriter out = res.getWriter()){
			String name = req.getParameter("name");
			double price = Double.parseDouble(req.getParameter("price"));
			int stock = Integer.parseInt(req.getParameter("stock"));
			
			Article article = new Article(name, price, stock);
			art.save(article);
			int idArticle = article.getId();
			Optional<Article> newArticle = art.getById(idArticle);
			
			out.print(new Gson().toJson(newArticle));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
       

    public NewProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.proccessRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
