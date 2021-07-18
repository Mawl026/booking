<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:genericpage>
    <jsp:attribute name="header">
         Tilføj ny sælger.
    </jsp:attribute>
  <jsp:attribute name="footer">
    </jsp:attribute>

  <jsp:body>


    <form action="${pageContext.request.contextPath}/fc/addnewstudentpage" method="post">
      <div class="container mt-2">

        <label class="mt-2">Email</label>
        <input type="text" name="email" class="form-control mt-2">

        <label class="mt-2">Kodeord</label>
        <input type="text" name="address" class="form-control mt-2">

        <label class="mt-2">Telefon</label>
        <input type="text" name="phone" class="form-control mt-2">

        <label class="mt-2">Rolle</label>
        <input type="text" name="role" class="form-control mt-2">


        <a href="teacherpage" type="button" class="mt-3 btn btn-danger float-left">Gå tilbage</a>

        <button type="submit" class="mt-3 btn btn-success float-end">Tilføj</button>
      </div>
    </form>


  </jsp:body>

</t:genericpage>