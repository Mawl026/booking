<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         List Of Bookings Page.
    </jsp:attribute>

    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>

        <h3>Du er logget ind som rolle: ${sessionScope.role}</h3>
        <h3>Teacher ID: ${sessionScope.id}</h3>

        <table class="table mt-5">
            <thead>
            <tr>
                <th scope="col">Booking ID</th>
                <th scope="col">Dato</th>
                <th scope="col">Dage</th>
                <th scope="col">Kommentar</th>
                <th scope="col">Status</th>
                <th scope="col">Bruger ID</th>
                <th scope="col">Udstyr ID</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${requestScope.item}">
                <tr>
                    <td>${booking.booking_id}</td>
                    <td>${booking.booking_date}</td>
                    <td>${booking.booking_days}</td>
                    <td>${booking.booking_comment}</td>
                    <td>${booking.booking_status}</td>
                    <td>${booking.fk_user_id}</td>
                    <td>${booking.fk_item_id}</td>
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

