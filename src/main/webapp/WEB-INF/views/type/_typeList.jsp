<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
    <c:when test="${types != null || !types.isEmpty()}">
        <table class="table">
            <colgroup>
                <col class="col-md-1" />
                <col class="col-md-3" />
                <col class="col-md-3" />
                <col class="col-md-2" />
                <col class="col-md-1" />
                <col class="col-md-1" />
                <col class="col-md-1" />
            </colgroup>
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Nom</th>
                <th scope="col">Capacit�</th>
                <th scope="col">Poids</th>
                <th scope="col">Rayon d'action</th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${types}" var="type" varStatus="loop">
                <tr>
                    <th scope="row">${loop.index + 1}</th>
                    <td>${type.nom}</td>
                    <td>${type.capacite} passager(s)</td>
                    <td>${type.poids} Kg</td>
                    <td>${type.rayonAction} Km</td>
                    <td>
                        <a class="btn btn-outline-primary" href="<spring:url value="/type/type/${type.id}" />">
                            <i class="fa fa-book-reader"></i>
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-outline-danger" href="<spring:url value="/type/delete/${type.id}" />">
                            <i class="fa fa-trash-can"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
</c:choose>