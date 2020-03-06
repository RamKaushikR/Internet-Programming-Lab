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

		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs;
		String command = "select * from student where id='" + id + "'";
		rs = st.executeQuery(command);

		if(rs.next()) {
			String g1 = rs.getString(2);
			String g2 = rs.getString(3);
			String g3 = rs.getString(4);
			String g4 = rs.getString(5);
			String g5 = rs.getString(6);

			
		}

		RequestDispatcher rd = request.getRequestDispatcher("buttons.html");
		out.print("<input type='hidden' name='id' value='" + rs.getString(1) + "'>");
		rd.forward(request, response);

		st.close();
		con.close();
	}
}