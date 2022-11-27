<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<jsp:include page="../shared/head.jsp"/>
<body>
<jsp:include page="../shared/navbar.jsp"/>
<div class="container">
    <div class="row mt-4">
        <h2>Adresse #${adresse.id}</h2>
    </div>
    <div class="row mt-4">
        <div class="container-fluid">
            <dl class="row mt-4">
                <dt class="col-sm-6 col-lg-4">Numéro de rue : </dt>
                <dd class="col-sm-6 col-lg-8">${adresse.numeroRue}</dd>

                <dt class="col-sm-6 col-lg-4">Nom de rue: </dt>
                <dd class="col-sm-6 col-lg-8">${adresse.nomRue}</dd>

                <dt class="col-sm-6 col-lg-4">Ville : </dt>
                <dd class="col-sm-6 col-lg-8">${adresse.ville}</dd>

                <dt class="col-sm-6 col-lg-4">Province : </dt>
                <dd class="col-sm-6 col-lg-8">${adresse.province}</dd>

                <dt class="col-sm-6 col-lg-4">Pays : </dt>
                <dd class="col-sm-6 col-lg-8">${adresse.pays}</dd>

                <dt class="col-sm-6 col-lg-4">Code postal : </dt>
                <dd class="col-sm-6 col-lg-8">${adresse.codePostal}</dd>
            </dl>
        </div>
    </div>
    <c:choose>
        <c:when test="${adresse.employes != null && !adresse.employes.isEmpty()}">
            <div class="row mt-4">
                <hr/>
                <h4>Employés associés avec cette adresse:</h4>
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
                    <c:forEach items="${adresse.employes}" var="employe">
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
            </div>
        </c:when>
    </c:choose>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>