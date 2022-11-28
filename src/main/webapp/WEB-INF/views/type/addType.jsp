<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="employes" value="${employes}" scope="request"/>

<html lang="en">
<jsp:include page="../shared/_head.jsp"/>
<body>
<jsp:include page="../shared/_navbar.jsp"/>
<div class="container">
    <div class="row mt-4">
        <div class="col-3"></div>
        <div class="col-6">
            <h2>Ajouter un type d'avion</h2>
            <form:form class="form my-4" method="POST" action="/type/save" modelAttribute="type">
                <div class="form-group mt-3">
                    <form:label path="nom">Nom</form:label>
                    <form:input type="text" class="form-control" id="inputNom" path="nom" cssErrorClass="form-control is-invalid" maxlength="255"/>
                    <form:errors path="nom" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                </div>
                <div class="form-group mt-3">
                    <form:label path="capacite">Capacité</form:label>
                    <form:input type="number" class="form-control" id="inputCapacite" path="capacite" cssErrorClass="form-control is-invalid" min="1" max="999"/>
                    <form:errors path="capacite" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                </div>
                <div class="form-group mt-3">
                    <form:label path="poids">Poids</form:label>
                    <form:input type="number" class="form-control" id="inputPoids" path="poids" cssErrorClass="form-control is-invalid" min="0.00" max="99999999.99"/>
                    <form:errors path="poids" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                </div>
                <div class="form-group mt-3">
                    <form:label path="rayonAction">Rayon d'action</form:label>
                    <form:input type="number" class="form-control" id="inputRayonAction" path="rayonAction" cssErrorClass="form-control is-invalid" min="0.00" max="99999999.99"/>
                    <form:errors path="rayonAction" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                </div>
                <div class="form-group mt-3">
                    <button type="submit" class="btn btn-primary mb-2">Ajouter</button>
                </div>
            </form:form>
            <a href="<spring:url value="/type/types" />">
                <i class="fa fa-arrow-left"></i><span class="mx-2">Retour à la liste</span>
            </a>
        </div>
        <div class="col-3"></div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>