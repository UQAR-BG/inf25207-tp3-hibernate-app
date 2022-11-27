<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
    <c:when test="${employes != null && !employes.isEmpty()}">
        <table class="table m-4">
            <colgroup>
                <col class="col-md-1" />
                <col class="col-md-1" />
                <col class="col-md-1" />
                <col class="col-md-3" />
                <col class="col-md-1" />
                <col class="col-md-2" />
                <col class="col-md-1" />
                <col class="col-md-1" />
                <col class="col-md-1" />
            </colgroup>
            <thead>
            <tr>
                <th scope="col">Matricule</th>
                <th scope="col">Prénom</th>
                <th scope="col">Nom</th>
                <th scope="col">Adresse</th>
                <th scope="col">Tél.</th>
                <th scope="col">Date d'embauche</th>
                <th scope="col">Salaire</th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${employes}" var="employe">
                <tr>
                    <th scope="row">${employe.matricule}</th>
                    <td>${employe.prenom}</td>
                    <td>${employe.nom}</td>
                    <td>
                        <a href="<spring:url value="/adresse/adresse/${employe.adresse.id}" />">
                                ${employe.adresse}
                        </a>
                    </td>
                    <td>${employe.telephone}</td>
                    <td>${employe.getLocalDate()}</td>
                    <td>${employe.getSalaireFormatted()}</td>
                    <td>
                        <a class="btn btn-outline-primary" href="<spring:url value="/employe/employe/${employe.matricule}" />">
                            <i class="fa fa-book-reader"></i>
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-outline-danger" href="<spring:url value="/employe/delete/${employe.matricule}" />">
                            <i class="fa fa-trash-can"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
</c:choose>