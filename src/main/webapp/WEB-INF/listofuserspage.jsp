<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Login page
    </jsp:attribute>

    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>

        <h3>Du er logget ind som rolle: ${sessionScope.role}</h3>
        <h3>Teacher ID: ${sessionScope.id}</h3>

        <table class="table mt-5">
            <thead>
            <tr>
                <th scope="col">Student ID</th>
                <th scope="col">Email</th>
                <th scope="col">Telefon</th>
                <th scope="col">Credit</th>
                <th scope="col">Rolle</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${requestScope.user}">
                <tr>
                    <td>${user.user_id}</td>
                    <td>${user.user_email}</td>
                    <td>${user.user_phone}</td>
                    <td>${user.user_credit}</td>
                    <td>${user.user_role}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <div class="d-flex justify-content-center mt-5">
            <br>
            <a href="teacherpage" type="button" class="btn btn-danger btn-lg ms-5">Go back</a>
        </div>


    </jsp:body>
</t:genericpage>
