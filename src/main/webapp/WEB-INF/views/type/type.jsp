<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="type" value="${type}" scope="request"/>
<c:set var="techniciens" value="${techniciens}" scope="request"/>
<c:set var="pilotes" value="${pilotes}" scope="request"/>

<html lang="en">
    <jsp:include page="../shared/_head.jsp"/>
    <body>
        <jsp:include page="../shared/_navbar.jsp"/>
        <div class="container">
            <div class="row mt-4">
                <h2>Type d'avion #${type.id}</h2>
            </div>
            <div class="row mt-4">
                <div class="container-fluid">
                    <dl class="row mt-4">
                        <dt class="col-sm-6 col-lg-4">Nom : </dt>
                        <dd class="col-sm-6 col-lg-8">${type.nom}</dd>

                        <dt class="col-sm-6 col-lg-4">Capacité : </dt>
                        <dd class="col-sm-6 col-lg-8">${type.capacite} passagers</dd>

                        <dt class="col-sm-6 col-lg-4">Poids : </dt>
                        <dd class="col-sm-6 col-lg-8">${type.poids} Kg</dd>

                        <dt class="col-sm-6 col-lg-4">Rayon d'action : </dt>
                        <dd class="col-sm-6 col-lg-8">${type.rayonAction} Km</dd>
                    </dl>
                </div>
            </div>
            <c:choose>
                <c:when test="${techniciens != null && !techniciens.isEmpty()}">
                    <div class="row mt-4">
                        <hr/>
                        <h4>Techniciens spécialisés dans ce type d'avion:</h4>
                        <jsp:include page="../technicien/_technicienList.jsp"/>
                    </div>
                </c:when>
            </c:choose>
            <c:choose>
                <c:when test="${pilotes != null && !pilotes.isEmpty()}">
                    <div class="row mt-4">
                        <hr/>
                        <h4>Pilotes qualifiés dans ce type d'avion:</h4>
                        <jsp:include page="../pilote/_piloteList.jsp"/>
                    </div>
                </c:when>
            </c:choose>
            <a href="<spring:url value="/specialisation/add" />">
                <i class="fa fa-plus"></i><span class="mx-2">Ajouter une spécialisation</span>
            </a>
            <a href="<spring:url value="/qualification/add" />">
                <i class="fa fa-plus"></i><span class="mx-2">Ajouter une qualification</span>
            </a>
            <a href="<spring:url value="/type/types" />">
                <i class="fa fa-arrow-left"></i><span class="mx-2">Retour à la liste</span>
            </a>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>