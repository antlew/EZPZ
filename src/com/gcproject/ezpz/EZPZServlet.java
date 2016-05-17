package com.gcproject.ezpz;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		String meat = request.getParameter("meat");
		String meal = request.getParameter("meal");
		System.out.println(meat);
		System.out.println(meal);
		String[] meals = new String[3];
		String[] nutrition = new String[5];
		Scanner in = new Scanner(System.in);
		
		try {
			meals = EZPZDao.getData(meat);
			request.setAttribute("meals", meals);
			
			
			String veggie = meals[2];
			
			nutrition = EZPZDao.getNutrition(veggie);
			request.setAttribute("nutrition", nutrition);
		

			getServletContext().getRequestDispatcher("/meals.jsp").forward(request, response);
			
			
			
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
