package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.GuestBookDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateGuestBook")
public class UpdateGuestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateGuestBook() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestBookDAO db = new GuestBookDAO();
		PrintWriter out = response.getWriter();

		int Key = Integer.parseInt(request.getParameter("Key"));
		String Name = (String) request.getParameter("Name");
		String Message = (String) request.getParameter("Message");

		try {
			if (db.UpdateGuestBook(Key, Name, Message)) {
				response.sendRedirect("GuestBook.jsp");
			}
			else{
				response.setContentType("text/html");
				out.println("<html lang=\"en\"><head><meta charset=\"utf-8\"><title>Error</title></head><body>");
				out.println("<p>Error</p>");
				out.println("<a href=\"GuestBook.jsp\">Go back....!</a>");
				out.println("</body></html>");
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			response.setContentType("text/html");
			out.println("<html lang=\"en\"><head><meta charset=\"utf-8\"><title>Error</title></head><body>");
			out.println("<p>Error</p>");
			out.println("<a href=\"GuestBook.jsp\">Go back....!</a>");
			out.println("</body></html>");
		}
	}

}
