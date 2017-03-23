<%-- 
    Document   : users
    Created on : Mar 20, 2017, 1:15:08 PM
    Author     : Hatta NR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../layout/taglib.jsp" %>
<!DOCTYPE html>

<table class="table table-bordered table-hover table-striped">
    <thead>
        <tr>
            <th>Username</th>
        </tr>
    </thead>
    <body>
        <c:forEach items="${users}" var="user">
        <tr>
            <td>
                <a href="<spring:url value="/users/${user.id}.html"/>">
                ${user.name}
                </a>
            </td>
        </tr>
        </c:forEach>
    </body>
</table>
