import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class Login extends HttpServlet {
	public Login() {
		String url = "jbdc:mysql://localhost:3308/login";
		String user = "root";
		String password = "";
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con = DriverManager.getConnection(url, user, password);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs;
		String command = "select * from login where username='" + username + "' and password='" + password + "'";
		rs = st.executeQuery(command);

		if(rs.next()) {
			RequestDispatcher rd = request.getRequestDispatcher("buttons.html");
			out.print("<input type='hidden' name='id' value='" + rs.getString(1) + "'>");
			rd.forward(request, response);
			out.close();
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			out.print("Invalid login");
			rd.include(request, response);
			out.close();
		}

		st.close();
		con.close();
	}
}