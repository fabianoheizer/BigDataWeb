package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.QtdPedidosOrigemModel;


@WebServlet("/gerarGraficos")
public class GerarGraficosController extends HttpServlet
{
	private static final long serialVersionUID = -2624732500435674330L;
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		QtdPedidosOrigemModel qtdPedidosOrigem = new QtdPedidosOrigemModel();
			
		Gson gson = new Gson();
		response.setContentType("application/json");
			
		PrintWriter out = response.getWriter();
		out.println(gson.toJson(qtdPedidosOrigem.findAll()));
	}
}
