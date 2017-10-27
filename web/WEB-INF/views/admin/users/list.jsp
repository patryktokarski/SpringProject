<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:admin-layout title="Users" userName="Admin">
    <jsp:attribute name="content">
            <c:forEach items="${users}" var="user">
                <ul>
                    <li>${user.email}</li>
                </ul>
            </c:forEach>
    </jsp:attribute>
</t:admin-layout>
