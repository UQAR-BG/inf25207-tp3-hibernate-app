<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
    <c:when test="${examens != null || !examens.isEmpty()}">
        <table class="table">
            <colgroup>
                <col class="col-md-1" />
                <col class="col-md-9" />
                <col class="col-md-1" />
                <col class="col-md-1" />
            </colgroup>
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Description</th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${examens}" var="examen" varStatus="loop">
                <tr>
                    <th scope="row">${loop.index + 1}</th>
                    <td>${examen.description}</td>
                    <td>
                        <a class="btn btn-outline-primary" href="<spring:url value="/examen/examen/${examen.idExamen}" />">
                            <i class="fa fa-book-reader"></i>
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-outline-danger" href="<spring:url value="/examen/delete/${examen.idExamen}" />">
                            <i class="fa fa-trash-can"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
</c:choose>