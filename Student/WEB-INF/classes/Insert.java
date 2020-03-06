import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Insert extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");
		RequestDispatcher rd = request.getRequestDispatcher("insert_grades.html");
		out.print("<input type='hidden' name='id' value='" + id + "'>");
		rd.forward(request, response);
	}
}