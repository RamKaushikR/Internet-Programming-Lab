import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class InsertGrades extends HttpServlet {
	public InsertGrades() {
		String url = "jbdc:mysql://localhost:3308/login";
		String user = "root";
		String password = "";
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con = DriverManager.getConnection(url, user, password);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String g1 = request.getParameter("g1");
		String g2 = request.getParameter("g2");
		String g3 = request.getParameter("g3");
		String g4 = request.getParameter("g4");
		String g5 = request.getParameter("g5");

		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs;
		String command = "insert into student values('" + id + "', '" + g1 + "', '" + g2 + "', '" + g3 + "', '" + g4 + "', '" + g5 + "')";
		st.executeUpdate(command);

		RequestDispatcher rd = request.getRequestDispatcher("buttons.html");
		out.print("<input type='hidden' name='id' value='" + rs.getString(1) + "'>");
		rd.forward(request, response);

		st.close();
		con.close();
	}
}