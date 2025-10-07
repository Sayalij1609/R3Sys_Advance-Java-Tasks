package reminder_application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection con = DBConnect.connect();
		
		String uname  = request.getParameter("name");
		String ucontact = request.getParameter("contact");
		String uemail = request.getParameter("email");
		String upassword = request.getParameter("password");
		int uid = 0;
		
		System.out.println(uname);
		System.out.println(uemail);
		System.out.println(upassword);
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("Insert into users values (?,?,?,?,?)");
			pstmt.setInt(1,uid);
			pstmt.setString(2 ,uname );
			pstmt.setString(3,ucontact);
			pstmt.setString(4 ,uemail );
			pstmt.setString(5,upassword);
		
			int i = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("index.html");
		

		
		
		doGet(request, response);
	}

}
