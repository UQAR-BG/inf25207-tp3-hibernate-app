<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="adresses" value="${adresses}" scope="request"/>

<html lang="en">
    <jsp:include page="../shared/_head.jsp"/>
    <body>
        <jsp:include page="../shared/_navbar.jsp"/>
        <div class="container">
            <div class="row mt-4">
                <div class="col-3"></div>
                <div class="col-6">
                    <h2>Ajouter un employé</h2>
                    <form:form class="form my-4" method="POST" action="/employe/save" modelAttribute="employe">
                        <div class="form-group mt-3">
                            <form:label path="prenom">Prénom</form:label>
                            <form:input type="text" class="form-control" id="inputPrenom" path="prenom" cssErrorClass="form-control is-invalid" maxlength="45"/>
                            <form:errors path="prenom" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                        </div>
                        <div class="form-group mt-3">
                            <form:label path="nom">Nom</form:label>
                            <form:input type="text" class="form-control" id="inputNom" path="nom" cssErrorClass="form-control is-invalid" maxlength="45"/>
                            <form:errors path="nom" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                        </div>
                        <div class="form-group mt-3">
                            <form:label path="adresse">Adresse</form:label>
                            <form:select class="form-select" id="inputAdresse" path="adresse" cssErrorClass="form-control is-invalid">
                                <form:option value="-1" label="Sélectionnez une adresse ..."/>
                                <form:options items="${adresses}" itemValue="id" />
                            </form:select>
                            <form:errors path="adresse" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                        </div>
                        <div class="form-group mt-3">
                            <form:label path="telephone">Numéro de téléphone</form:label>
                            <form:input type="text" class="form-control" id="inputTelephone" path="telephone" cssErrorClass="form-control is-invalid" maxlength="45"/>
                            <form:errors path="telephone" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                        </div>
                        <div class="form-group mt-3">
                            <form:label path="dateEngagement">Date d'embauche</form:label>
                            <form:input type="date" class="form-control" id="inputDateEngagement" path="dateEngagement" cssErrorClass="form-control is-invalid"/>
                            <form:errors path="dateEngagement" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                        </div>
                        <div class="form-group mt-3">
                            <form:label path="salaire">Salaire</form:label>
                            <form:input type="number" class="form-control" id="inputSalaire" path="salaire" cssErrorClass="form-control is-invalid" min="0.00" max="9999999999.99"/>
                            <form:errors path="salaire" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                        </div>
                        <div class="form-group mt-3">
                            <button type="submit" class="btn btn-primary mb-2">Ajouter</button>
                        </div>
                    </form:form>
                    <a href="<spring:url value="/employe/employes" />">
                        <i class="fa fa-arrow-left"></i><span class="mx-2">Retour à la liste</span>
                    </a>
                </div>
                <div class="col-3"></div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>