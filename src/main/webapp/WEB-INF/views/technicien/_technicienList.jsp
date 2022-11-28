<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
    <c:when test="${techniciens != null || !techniciens.isEmpty()}">
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
                <th scope="col">Matricule du technicien</th>
                <th scope="col">Employ�</th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${techniciens}" var="technicien" varStatus="loop">
                <tr>
                    <th scope="row">${loop.index + 1}</th>
                    <td>${technicien.matricule}</td>
                    <td>
                        <a href="<spring:url value="/employe/employe/${technicien.employe.matricule}" />">
                                ${technicien.employe}
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-outline-primary" href="<spring:url value="/technicien/technicien/${technicien.matricule}" />">
                            <i class="fa fa-book-reader"></i>
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-outline-danger" href="<spring:url value="/technicien/delete/${technicien.matricule}" />">
                            <i class="fa fa-trash-can"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
</c:choose>