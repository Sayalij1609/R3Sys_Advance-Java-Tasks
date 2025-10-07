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
 * Servlet implementation class AddReminder
 */
public class AddReminder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReminder() {
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
		
		String rtitle  = request.getParameter("rtitle");
		String rdesc = request.getParameter("rdesc");
		String rdate = request.getParameter("rdate");
		int id = 0;
		int uid = GetSet.getUid();
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("Insert into reminders values (?,?,?,?,?)");
			pstmt.setInt(1,id);
			pstmt.setString(2 ,rtitle );
			pstmt.setString(3,rdesc);
			pstmt.setString(4 ,rdate );
			pstmt.setInt(5,uid);
		
			int i = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("dashboard.html");
		
		
		
		doGet(request, response);
	}

}
