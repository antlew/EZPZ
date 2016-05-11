package com.site.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EZPZServlet")
public class EZPZServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String meat = request.getParameter("meat");
		ArrayList<String> meals = new ArrayList<String>();
		String meal = "";
		ArrayList<String> veggie = new ArrayList<String>();
		Scanner in =new Scanner(System.in);
		
		try {
			meals = EZPZDao.getMeals(meat);
			request.setAttribute("meals", meals);

			getServletContext().getRequestDispatcher("/page2.jsp").forward(request, response);
			
			
			
			//meal = meals.get(index);
			
			//veggie = EZPZDao.getVeggies(meal);
			//for(String b : veggie){
			//	System.out.println(b);
			//}
			
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
