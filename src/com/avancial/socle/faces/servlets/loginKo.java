package com.avancial.socle.faces.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.avancial.socle.resources.constants.SOCLE_constants;

/**
 * Servlet implementation class loginKo
 */
@WebServlet("/loginKo")
public class loginKo extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public loginKo() {
      super();
      // TODO Auto-generated constructor stub
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      request.getSession().invalidate();

      response.addHeader("Pragma", "no-cache");
      response.addHeader("Robots", "none");
      response.addHeader("Cache-Control", "no-cache");
      response.setHeader("Cache-Control", "no-store");
      response.addHeader("Cache-Control", "must-revalidate");
      // response.addHeader("Expires", "-1");
      response.addHeader("cache-Control", "private");
      response.sendRedirect(request.getServletContext().getContextPath() + SOCLE_constants.NAVIGATION_LOGIN.getPagePath());
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}
