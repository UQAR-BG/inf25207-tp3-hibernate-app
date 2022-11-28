<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
    <c:when test="${pilotes != null || !pilotes.isEmpty()}">
        <table class="table">
            <colgroup>
                <col class="col-md-1" />
                <col class="col-md-2" />
                <col class="col-md-7" />
                <col class="col-md-1" />
                <col class="col-md-1" />
            </colgroup>
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Matricule du pilote</th>
                <th scope="col">Employé</th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pilotes}" var="pilote" varStatus="loop">
                <tr>
                    <th scope="row">${loop.index + 1}</th>
                    <td>${pilote.matricule}</td>
                    <td>
                        <a href="<spring:url value="/empoye/empoye/${pilote.employe.matricule}" />">
                                ${pilote.employe}
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-outline-primary" href="<spring:url value="/pilote/pilote/${pilote.matricule}" />">
                            <i class="fa fa-book-reader"></i>
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-outline-danger" href="<spring:url value="/pilote/delete/${pilote.matricule}" />">
                            <i class="fa fa-trash-can"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
</c:choose>