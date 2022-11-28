<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="technicien" value="${technicien}" scope="request"/>
<c:set var="employe" value="${technicien.employe}" scope="request"/>
<c:set var="specialisations" value="${specialisations}" scope="request"/>
<c:set var="reparations" value="${reparations}" scope="request"/>

<html lang="en">
<jsp:include page="../shared/_head.jsp"/>
<body>
<jsp:include page="../shared/_navbar.jsp"/>
<div class="container">
    <div class="row mt-4">
        <h2>Technicien #${technicien.matricule}</h2>
    </div>
    <div class="row mt-4">
        <div class="container-fluid">
            <dl class="row mt-4">
                <dt class="col-sm-6 col-lg-4">Employé : </dt>
                <dd class="col-sm-6 col-lg-8">
                    <a href="<spring:url value="/employe/employe/${employe.matricule}" />">
                        ${employe}
                    </a>
                </dd>

                <dt class="col-sm-6 col-lg-4">Adresse : </dt>
                <dd class="col-sm-6 col-lg-8">
                    <a href="<spring:url value="/adresse/adresse/${employe.adresse.id}" />">
                        ${employe.adresse}
                    </a>
                </dd>
            </dl>
        </div>
    </div>
    <c:choose>
        <c:when test="${specialisations != null && !specialisations.isEmpty()}">
            <div class="row mt-4">
                <hr/>
                <h4>Spécialisations associées avec ce technicien:</h4>
                <jsp:include page="../specialisation/_specialisationList.jsp"/>
            </div>
        </c:when>
    </c:choose>
    <c:choose>
        <c:when test="${reparations != null && !reparations.isEmpty()}">
            <div class="row mt-4">
                <hr/>
                <h4>Réparations de vol associées avec ce technicien:</h4>
                <jsp:include page="../reparation/_reparationList.jsp"/>
            </div>
        </c:when>
    </c:choose>
    <c:choose>
    <a href="<spring:url value="/specialisation/add" />">
        <i class="fa fa-plus"></i><span class="mx-2">Ajouter une spécialisation</span>
    </a>
    <a href="<spring:url value="/reparation/add" />">
        <i class="fa fa-plus"></i><span class="mx-2">Ajouter une réparation</span>
    </a>
    <a href="<spring:url value="/technicien/techniciens" />">
        <i class="fa fa-arrow-left"></i><span class="mx-2">Retour à la liste</span>
    </a>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>