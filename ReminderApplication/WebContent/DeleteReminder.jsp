<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="reminder_application.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%
try {
    int id = Integer.parseInt(request.getParameter("id"));
    Connection con = DBConnect.connect();
    PreparedStatement pstmt = con.prepareStatement("DELETE FROM reminders WHERE rid = ?");
    pstmt.setInt(1, id);
    int i = pstmt.executeUpdate();
    if (i > 0) {
        response.sendRedirect("ViewReminder.jsp");
    } else {
        out.println("No record found to delete.");
    }
} catch(Exception e) {
    
}
%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>View Reminders</title>
</head>
<body>
<center>
<%
  Connection con = DBConnect.connect();
  int uid = GetSet.getUid();
  PreparedStatement ps = con.prepareStatement("SELECT * FROM reminders where uid = ?");
  ps.setInt(1,uid);
  ResultSet rs = ps.executeQuery();
%>
<br>
<br>
<br>
<br>
<table border="2">
  <tr>
    <th>Rid</th>
    <th>RTitle</th>
    <th>RDescription</th>
    <th>RDate</th>
    <th>User id</th>
    <th>Delete</th>
  </tr>
<%
  while(rs.next()) {
%>
  <tr>
    <td><%= rs.getInt(1) %></td>
    <td><%= rs.getString(2) %></td>
    <td><%= rs.getString(3) %></td>
    <td><%= rs.getString(4) %></td>
    <td><%= rs.getInt(5) %></td>
    <td><a href="DeleteReminder.jsp?id=<%= rs.getInt(1) %>">Delete</a></td>
  </tr>
<%
  }
%>
</table>
<h3><a href = "dashboard.html">Back</a></h3>
</center>


</body>
</html>
