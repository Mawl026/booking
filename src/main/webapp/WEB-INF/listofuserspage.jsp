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

        <h3>Du er logget ind som rolle: ${sessionScope.user_role}</h3>
        <h3>Teacher ID: ${sessionScope.user_id}</h3>

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
            <c:forEach var="users" items="${requestScope.listOfStudents}">
                <tr>
                    <td>${users.user_id}</td>
                    <td>${users.user_mail}</td>
                    <td>${users.user_phone}</td>
                    <td>${users.user_credit}</td>
                    <td>${users.user_role}</td>
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

