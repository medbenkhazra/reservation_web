<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
HttpSession httpSession = request.getSession();
httpSession.invalidate();
RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
dispatcher.include(request, response);
%>
    