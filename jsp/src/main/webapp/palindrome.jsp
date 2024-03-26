<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<form action="">
<table>
<tr> <td>Num </td>
<td> <input type="text" name="num1"> </td>
 </tr>
</table>
<input type="submit" value="Verify">
</form>
</div>
 <%! int num1, res,copy; %>
 
 <% String inp=request.getParameter("num1");
 if(inp!=null){
 num1=Integer.parseInt(inp);
 copy=num1;
 while(num1>0){
	 int rem=num1%10;
	 res=(res*10)+rem;
	 num1/=10;
 }
 }
 if(res==copy){
	 System.out.println("number is palindrome");
 }
 else{
  System.out.println("number is not palindrome");
 
 %>
 <div>
 <h3>  </h3>
 </div>
 <% } %>

</body>
</html>