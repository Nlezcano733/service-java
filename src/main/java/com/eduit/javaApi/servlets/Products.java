package com.eduit.javaApi.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduit.javaApi.connector.Connector;
import com.eduit.javaApi.repositories.db.ArticleRepository;
import com.eduit.javaApi.repositories.interfaces.I_ArticleRepository;
import com.google.gson.Gson;

@WebServlet("/products")
public class Products extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private I_ArticleRepository art = new ArticleRepository(Connector.getConnection());
	
	protected void proccessRequest (HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		res.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = res.getWriter()) {
            out.print(new Gson().toJson(art.getAll()));
        } catch (Exception e) {
        	System.out.println(e);
        }
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Products() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proccessRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
