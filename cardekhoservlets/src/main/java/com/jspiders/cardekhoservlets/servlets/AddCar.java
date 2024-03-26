package com.jspiders.cardekhoservlets.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspiders.cardekhoservlets.jdbc.CarJDBC;

@WebServlet("/add_car")
public class AddCar extends HttpServlet {

	private static final long serialVersionUID = 1L;
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  int id=Integer.parseInt(req.getParameter("id"));
  String name=req.getParameter("name");
  String brand=req.getParameter("brand");
  Double price=Double.parseDouble(req.getParameter("price"));
  int res=CarJDBC.addCar(id,name,brand,price);
  if (res==1) {
	req.setAttribute("message", "CAR ADDED");
}
  else {
	req.setAttribute("message", "CAR NOT ADDED");
}
  RequestDispatcher requestDispatcher=req.getRequestDispatcher("add_car.jsp");
  requestDispatcher.forward(req, resp);

  }
}
