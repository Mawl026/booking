<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Teacher Page
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        You are now logged in as a TEACHER of our wonderful site.

        <div class="d-flex justify-content-center mt-5">
            <br>
            <a href="${pageContext.request.contextPath}/fc/listofallstudentspage" type="button" class="btn btn-primary btn-lg ms-5">liste over studerende</a>
        </div>

        <div class="d-flex justify-content-center mt-5">
            <br>
            <a href="${pageContext.request.contextPath}/fc/listofallitemspage" type="button" class="btn btn-primary btn-lg ms-5">liste over udstyr</a>
        </div>

    </jsp:body>
</t:genericpage>
