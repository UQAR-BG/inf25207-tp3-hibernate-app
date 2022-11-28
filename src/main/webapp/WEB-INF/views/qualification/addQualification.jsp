<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
    <jsp:include page="../shared/_head.jsp"/>
    <body>
        <jsp:include page="../shared/_navbar.jsp"/>
        <div class="container">
            <div class="row mt-4">
                <div class="col-3"></div>
                <div class="col-6">
                    <h2>Ajouter une adresse</h2>
                    <form:form class="form my-4" method="POST" action="/adresse/save" modelAttribute="adresse">
                        <div class="form-group mt-3">
                            <form:label path="numeroRue">Code civique</form:label>
                            <form:input type="number" class="form-control" id="inputNumeroRue" path="numeroRue" cssErrorClass="form-control is-invalid" min="1" max="999"/>
                            <form:errors path="numeroRue" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                        </div>
                        <div class="form-group mt-3">
                            <form:label path="nomRue">Nom de rue</form:label>
                            <form:input type="text" class="form-control" id="inputNomRue" path="nomRue" cssErrorClass="form-control is-invalid"/>
                            <form:errors path="nomRue" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                        </div>
                        <div class="form-group mt-3">
                            <form:label path="ville">Ville</form:label>
                            <form:input type="text" class="form-control" id="inputVille" path="ville" cssErrorClass="form-control is-invalid"/>
                            <form:errors path="ville" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                        </div>
                        <div class="form-group mt-3">
                            <form:label path="province">Province</form:label>
                            <form:input type="text" class="form-control" id="inputProvince" path="province" cssErrorClass="form-control is-invalid"/>
                            <form:errors path="province" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                        </div>
                        <div class="form-group mt-3">
                            <form:label path="pays">Pays</form:label>
                            <form:input type="text" class="form-control" id="inputPays" path="pays" cssErrorClass="form-control is-invalid"/>
                            <form:errors path="pays" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                        </div>
                        <div class="form-group mt-3">
                            <form:label path="codePostal">Code postal</form:label>
                            <form:input type="text" class="form-control" id="inputCodePostal" path="codePostal" cssErrorClass="form-control is-invalid"/>
                            <form:errors path="codePostal" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                        </div>
                        <div class="form-group mt-3">
                            <button type="submit" class="btn btn-primary mb-2">Ajouter</button>
                        </div>
                    </form:form>
                    <a href="<spring:url value="/adresse/adresses" />">
                        <i class="fa fa-arrow-left"></i><span class="mx-2">Retour à la liste</span>
                    </a>
                </div>
                <div class="col-3"></div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>