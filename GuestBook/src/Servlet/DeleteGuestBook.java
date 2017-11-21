package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.GuestBookDAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteGuestBook")
public class DeleteGuestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteGuestBook() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	GuestBookDAO db = new GuestBookDAO();
		PrintWriter out = response.getWriter();	
		
		try {
			int Key = Integer.parseInt(request.getParameter("Key"));
			if (db.DeleteGuestBook(Key)) {
				response.sendRedirect("GuestBook.jsp");
			}
			else {
				response.setContentType("text/html");
				out.println("<html lang=\"en\"><head><meta charset=\"utf-8\"><title>Error</title></head><body>");
				out.println("<p>Error 1</p>");
				out.println("<a href=\"GuestBook.jsp\">Go back....!</a>");
				out.println("</body></html>");
			}
		}catch (Exception e) {
			response.setContentType("text/html");
			out.println("<html lang=\"en\"><head><meta charset=\"utf-8\"><title>Error</title></head><body>");
			out.println("<p>Error</p>");
			out.println("<a href=\"GuestBook.jsp\">Go back....!</a>");
			out.println("</body></html>");
		}
	}

}
