import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class FirstServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");

		out.print("Welcome123 " + firstname);
		out.print("<form action='servlet2'>");
		out.print("<input type='hidden' name='lastname' value='" + lastname + "'>");
		out.print("<input type='submit' value='go'>");
		out.print("</form>");
		out.close();
	}
}