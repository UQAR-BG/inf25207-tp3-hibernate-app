<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
    <c:when test="${listePiloter != null || !listePiloter.isEmpty()}">
        <table class="table">
            <colgroup>
                <col class="col-md-1" />
                <col class="col-md-4" />
                <col class="col-md-3" />
                <col class="col-md-1" />
                <col class="col-md-1" />
            </colgroup>
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Avion</th>
                <th scope="col">Pilote</th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listePiloter}" var="piloter" varStatus="loop">
                <tr>
                    <th scope="row">${loop.index + 1}</th>
                    <td>
                        <a href="<spring:url value="/type/type/${piloter.avion.matricule}" />">
                                ${piloter.avion}
                        </a>
                    </td>
                    <td>
                        <a href="<spring:url value="/pilote/pilote/${piloter.pilote.matricule}" />">
                                ${piloter.pilote}
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-outline-primary" href="<spring:url value="/piloter/piloter?avion_matricule=${piloter.avion.matricule}&pilote_matricule=${piloter.pilote.matricule}" />">
                            <i class="fa fa-book-reader"></i>
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-outline-danger" href="<spring:url value="/piloter/delete?avion_matricule=${piloter.avion.matricule}&pilote_matricule=${piloter.pilote.matricule}" />">
                            <i class="fa fa-trash-can"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
</c:choose>