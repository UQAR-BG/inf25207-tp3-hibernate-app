<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="avions" value="${avions}" scope="request"/>
<c:set var="pilotes" value="${pilotes}" scope="request"/>

<html lang="en">
    <jsp:include page="../shared/_head.jsp"/>
    <body>
        <jsp:include page="../shared/_navbar.jsp"/>
        <div class="container">
            <div class="row mt-4">
                <div class="col-3"></div>
                <div class="col-6">
                    <h2>Ajouter une expérience de vol</h2>
                    <form:form class="form my-4" method="POST" action="/piloter/save" modelAttribute="piloter">
                        <div class="form-group mt-3">
                            <form:label path="avion">Avion</form:label>
                            <form:select class="form-select" id="inputAvion" path="avion" cssErrorClass="form-control is-invalid">
                                <form:option value="-1" label="Sélectionnez un avion ..."/>
                                <form:options items="${avions}" itemValue="matricule" />
                            </form:select>
                            <form:errors path="avion" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                        </div>
                        <div class="form-group mt-3">
                            <form:label path="pilote">Pilote</form:label>
                            <form:select class="form-select" id="inputPilote" path="pilote" cssErrorClass="form-control is-invalid">
                                <form:option value="-1" label="Sélectionnez un pilote ..."/>
                                <form:options items="${pilotes}" itemValue="matricule" />
                            </form:select>
                            <form:errors path="pilote" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                        </div>
                        <div class="form-group mt-3">
                            <button type="submit" class="btn btn-primary mb-2">Ajouter</button>
                        </div>
                    </form:form>
                    <a href="<spring:url value="/piloter/listePiloter" />">
                        <i class="fa fa-arrow-left"></i><span class="mx-2">Retour à la liste</span>
                    </a>
                </div>
                <div class="col-3"></div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>