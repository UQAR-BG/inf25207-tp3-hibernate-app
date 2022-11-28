<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
    <c:when test="${examinations != null || !examinations.isEmpty()}">
        <table class="table">
            <colgroup>
                <col class="col-md-1" />
                <col class="col-md-4" />
                <col class="col-md-4" />
                <col class="col-md-1" />
                <col class="col-md-1" />
                <col class="col-md-1" />
            </colgroup>
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Pilote</th>
                <th scope="col">Examen</th>
                <th scope="col">Date</th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${examinations}" var="examination" varStatus="loop">
                <tr>
                    <th scope="row">${loop.index + 1}</th>
                    <td>
                        <a href="<spring:url value="/pilote/pilote/${examination.pilote.matricule}" />">
                                ${examination.pilote}
                        </a>
                    </td>
                    <td>
                        <a href="<spring:url value="/examen/examen/${examination.examen.idExamen}" />">
                                ${examination.examen}
                        </a>
                    </td>
                    <td>${examination.getLocalDate()}</td>
                    <td>
                        <a class="btn btn-outline-primary" href="<spring:url value="/examination/examination/${examination.idExamination}" />">
                            <i class="fa fa-book-reader"></i>
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-outline-danger" href="<spring:url value="/examination/delete/${examination.idExamination}" />">
                            <i class="fa fa-trash-can"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
</c:choose>