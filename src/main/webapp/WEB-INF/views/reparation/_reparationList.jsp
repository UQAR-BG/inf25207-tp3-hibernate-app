<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
    <c:when test="${reparations != null || !reparations.isEmpty()}">
        <table class="table">
            <colgroup>
                <col class="col-md-1" />
                <col class="col-md-4" />
                <col class="col-md-3" />
                <col class="col-md-1" />
                <col class="col-md-1" />
                <col class="col-md-1" />
                <col class="col-md-1" />
            </colgroup>
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Avion</th>
                <th scope="col">Technicien</th>
                <th scope="col">Date</th>
                <th scope="col">Coût total</th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${reparations}" var="reparation" varStatus="loop">
                <tr>
                    <th scope="row">${loop.index + 1}</th>
                    <td>
                        <a href="<spring:url value="/avion/avion/${reparation.avion.matricule}" />">
                                ${reparation.avion}
                        </a>
                    </td>
                    <td>
                        <a href="<spring:url value="/technicien/technicien/${reparation.technicien.matricule}" />">
                                ${reparation.technicien}
                        </a>
                    </td>
                    <td>${reparation.getLocalDate()}</td>
                    <td>${reparation.getCoutTotalFormatted()}</td>
                    <td>
                        <a class="btn btn-outline-primary" href="<spring:url value="/reparation/reparation/${reparation.id}" />">
                            <i class="fa fa-book-reader"></i>
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-outline-danger" href="<spring:url value="/reparation/delete/${reparation.id}" />">
                            <i class="fa fa-trash-can"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
</c:choose>