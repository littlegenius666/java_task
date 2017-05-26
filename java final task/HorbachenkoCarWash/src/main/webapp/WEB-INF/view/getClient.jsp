<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="java.util.ArrayList" %>
<%@ page import="model.entities.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client</title>
<style type="text/css">
   body {
   background:pink;
   }
   td {
    align:center;
   }
	label { display: inline-block; width: 100px; }
  </style>
     <script type="text/javascript">            
     $(function() {                
    	 $("input[name='update']").click(function(e) {                    
    		 e.preventDefault(); //prevent default action of submission of form when submit button is clicked                    
    		 var this_element = $(this);                   
    		 $(this).prop('disabled', true)                            
    		 .val("wait");                    
    		 setTimeout(function() {                       
    			 this_element.parent().submit(); // start submission after 3 seconds of parent form                    
    			 }, 3000);                
    		 });            
    	 });        
     </script>
     
</head>
<body>
<%
  Client client=(Client) request.getAttribute("client");
	
  ArrayList<Car> clientCars=(ArrayList<Car>) request.getAttribute("clientCars"); 
  %>
  <form action="./client?id=<%=client.getId_client() %>" method="post">
 	<p><label>Name: </label><input name="name" type="text" value="<%=client.getName()%>"></input></p>

 	<p><label>Gender: </label><input name="gender" type="text" value="<%=client.getGender()%>"></input></p>

 	<p><label>Car count: </label><input name="carCount" type="text" value="<%=client.getCar_count()%>"></input></p>

 	<p><label>Service count: </label><input name="serviceCount" type="text" value="<%=client.getService_count()%>"></input></p>

 	<p><label>Phone number: </label><input name="phoneNumber" type="text" value="<%=client.getPhone_number()%>"></input></p>
<%if (client.getId_client()!=-1) { %>
<input type="submit" name="act" value="Update"></input>
<input type="submit" name="act" value="Delete"></input>
<% } else {%>
<input type="submit" name="act" value="Insert"></input>
<%} %>
</form>
<%if (!clientCars.isEmpty()) { %>
<br><div><b><a href="./">Cars:</a></b></div><br>
 <table style="border: 3px; border-style: solid; width:300px;" >
<tr>
    <th>Plate numbers</th>
    <th>Type</th>
  </tr>
  
  
  <% 
  for (Car c:clientCars) {   
%>
 <tr>
   <td><%=c.getPlate_numbers()%></td>
   <td><%=c.getType()%></td>
   </tr>
 <%}
 %>
 </table>
 <%} %>
</body>
</html>