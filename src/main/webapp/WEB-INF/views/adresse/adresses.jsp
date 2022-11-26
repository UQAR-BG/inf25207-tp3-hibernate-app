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
        <h2>Liste des adresses</h2>
    </div>
    <div class="row mt-4">
        <c:choose>
            <c:when test="${adresses == null || adresses.isEmpty()}">
                <h4>Aucune adresse.</h4>
            </c:when>
            <c:otherwise>
                <table class="table">
                    <colgroup>
                        <col class="col-md-1" />
                        <col class="col-md-1" />
                        <col class="col-md-3" />
                        <col class="col-md-2" />
                        <col class="col-md-1" />
                        <col class="col-md-1" />
                        <col class="col-md-1" />
                        <col class="col-md-1" />
                        <col class="col-md-1" />
                    </colgroup>
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Num.</th>
                        <th scope="col">Rue</th>
                        <th scope="col">Ville</th>
                        <th scope="col">Province</th>
                        <th scope="col">Pays</th>
                        <th scope="col">Code postal</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${adresses}" var="adresse" varStatus="loop">
                        <tr>
                            <th scope="row">${loop.index + 1}</th>
                            <td>${adresse.numeroRue}</td>
                            <td>${adresse.nomRue}</td>
                            <td>${adresse.ville}</td>
                            <td>${adresse.province}</td>
                            <td>${adresse.pays}</td>
                            <td>${adresse.codePostal}</td>
                            <td>
                                <a class="btn btn-outline-primary" href="<spring:url value="/adresse/adresse/${adresse.id}" />">
                                    <i class="fa fa-book-reader"></i>
                                </a>
                            </td>
                            <td>
                                <a class="btn btn-outline-danger" href="<spring:url value="/adresse/delete/${adresse.id}" />">
                                    <i class="fa fa-trash-can"></i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>
        <a href="<spring:url value="/adresse/add" />">
            <i class="fa fa-plus"></i><span class="mx-2">Ajouter une adresse</span>
        </a>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>