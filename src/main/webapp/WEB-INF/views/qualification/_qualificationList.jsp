<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
    <c:when test="${qualifications != null || !qualifications.isEmpty()}">
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
                <th scope="col">Type d'avion</th>
                <th scope="col">Pilote</th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${qualifications}" var="qualification" varStatus="loop">
                <tr>
                    <th scope="row">${loop.index + 1}</th>
                    <td>
                        <a href="<spring:url value="/type/type/${qualification.type.id}" />">
                                ${qualification.type}
                        </a>
                    </td>
                    <td>
                        <a href="<spring:url value="/pilote/pilote/${qualification.pilote.matricule}" />">
                                ${qualification.pilote}
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-outline-primary" href="<spring:url value="/qualification/qualification/${qualification.id}" />">
                            <i class="fa fa-book-reader"></i>
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-outline-danger" href="<spring:url value="/qualification/delete/${qualification.id}" />">
                            <i class="fa fa-trash-can"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
</c:choose>