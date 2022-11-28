<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
    <c:when test="${avions != null || !avions.isEmpty()}">
        <table class="table">
            <colgroup>
                <col class="col-md-1" />
                <col class="col-md-1" />
                <col class="col-md-3" />
                <col class="col-md-2" />
                <col class="col-md-2" />
                <col class="col-md-1" />
                <col class="col-md-1" />
                <col class="col-md-1" />
            </colgroup>
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Matricule de l'avion</th>
                <th scope="col">Type d'avion</th>
                <th scope="col">Capacité</th>
                <th scope="col">Poids</th>
                <th scope="col">Rayon d'action</th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${avions}" var="avion" varStatus="loop">
                <tr>
                    <th scope="row">${loop.index + 1}</th>
                    <td>${avion.matricule}</td>
                    <td>
                        <a href="<spring:url value="/type/type/${avion.type.id}" />">
                                ${avion.type.nom}
                        </a>
                    </td>
                    <td>${avion.type.capacite} passager(s)</td>
                    <td>${avion.type.poids} Kg</td>
                    <td>${avion.type.rayonAction} Km</td>
                    <td>
                        <a class="btn btn-outline-primary" href="<spring:url value="/avion/avion/${avion.matricule}" />">
                            <i class="fa fa-book-reader"></i>
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-outline-danger" href="<spring:url value="/avion/delete/${avion.matricule}" />">
                            <i class="fa fa-trash-can"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
</c:choose>