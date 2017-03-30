<%-- 
    Document   : logout
    Created on : Mar 23, 2017, 10:31:52 AM
    Author     : Hatta NR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../layout/taglib.jsp" %>

<!DOCTYPE html>
<h1>Latest news</h1>

    <table class="table table-bordered table-hover table-striped">
        <thead>
            <tr>
                <th>Date</th>               
                <th>Item</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${items}" var="item">
            <tr>
                <td><c:out value="${item.publishDate}"/>
                    <br />
                    <c:out value="${item.blog.name}"/>
                </td>

            <td>
                <a href="<c:out value="${item.link}"/>" target="_blank">
            <c:out value="${item.title}"/>
            </a>
            <br />
            ${item.description}
            </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
