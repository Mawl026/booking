<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         List Of Items Page.
    </jsp:attribute>

    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>

        <h3>Du er logget ind som rolle: ${sessionScope.role}</h3>
        <h3>Teacher ID: ${sessionScope.id}</h3>

        <table class="table mt-5">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Description</th>
                <th scope="col">Type</th>
                <th scope="col">Room Number</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${requestScope.item}">
                <tr>
                    <td>${item.item_id}</td>
                    <td>${item.item_name}</td>
                    <td>${item.item_description}</td>
                    <td>${item.item_type}</td>
                    <td>${item.fk_room_number}</td>
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

