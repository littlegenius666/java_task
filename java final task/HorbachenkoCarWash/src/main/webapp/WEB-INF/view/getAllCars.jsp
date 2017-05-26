<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
<%@ page import="model.entities.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cars</title>
<style type="text/css">
   body {
   background:pink;
   }

  </style>

</head>
<body>
<h2>Cars</h2>
<table style="border: 3px; border-style: solid;" >
<tr>
    <th>Plate numbers</th>
    <th>Type</th>
    <th>Owner</th>
    <th>Phone number</th>
  </tr>
<%
  ArrayList<Car> cars=(ArrayList<Car>) request.getAttribute("cars"); 

  for (Car c:cars) {   
%>
  <tr>
   <td><%=c.getPlate_numbers()%></td>
   <td><%=c.getType()%></td>
   <td><a href="./client?id=<%=c.getOwner().getId_client()%>"><%=c.getOwner().getName() %></a></td>
   <td><%=c.getOwner().getPhone_number() %></td>
   </tr>
<%}%>
</table>
<br>
<a href="./clients"><input type="submit" value="View all clients"></input></a>
</body>
</html>