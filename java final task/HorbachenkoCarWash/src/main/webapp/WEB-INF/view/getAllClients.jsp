<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
<%@ page import="model.entities.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clients</title>
<style type="text/css">
   body {
   background:pink;
   }
   td {
    align:center;
   }

  </style>
</head>
<body>
<h2>Clients</h2>
<table style="border: 3px; border-style: solid;" >
<tr>
    <th>Name</th>
    <th>Gender</th>
    <th>Car count</th>
    <th>Service count</th>
    <th>Phone number</th>
  </tr>
<%
  ArrayList<Client> clients=(ArrayList<Client>) request.getAttribute("clients"); 

  for (Client c:clients) {   
%>
  <tr>
   <td><a href="./client?id=<%=c.getId_client() %>"><%=c.getName()%></a></td>
   <td><%=c.getGender()%></td>
   <td><%=c.getCar_count() %></td>
   <td><%=c.getService_count() %></td>
   <td><%=c.getPhone_number() %></td>
   </tr>
<%}%>
</table>
<br>
<a href="./client?id=new"><input type="submit" value="Create new client"></input></a>
<br><br>
<a href="./cars"><input type="submit" value="View all cars"></input></a>
</body>
</html>