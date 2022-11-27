<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="adresse" value="${adresse}" scope="request"/>
<c:set var="employes" value="${adresse.employes}" scope="request"/>

<html lang="en">
    <jsp:include page="../shared/_head.jsp"/>
    <body>
        <jsp:include page="../shared/_navbar.jsp"/>
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
                <c:when test="${employes != null && !employes.isEmpty()}">
                    <div class="row mt-4">
                        <hr/>
                        <h4>Employés associés avec cette adresse:</h4>
                        <jsp:include page="../employe/_employeList.jsp"/>
                    </div>
                </c:when>
            </c:choose>
            <a href="<spring:url value="/adresse/adresses" />">
                <i class="fa fa-arrow-left"></i><span class="mx-2">Retour à la liste</span>
            </a>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>