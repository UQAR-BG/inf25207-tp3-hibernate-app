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
            <h2>Ajouter un technicien</h2>
            <form:form class="form my-4" method="POST" action="/technicien/save" modelAttribute="technicien">
                <div class="form-group mt-3">
                    <form:label path="employe">Employé</form:label>
                    <form:select class="form-select" id="inputEmploye" path="employe" cssErrorClass="form-control is-invalid">
                        <form:option value="-1" label="Sélectionnez un employé ..."/>
                        <form:options items="${employes}" itemValue="matricule" />
                    </form:select>
                    <form:errors path="employe" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                </div>
                <div class="form-group mt-3">
                    <button type="submit" class="btn btn-primary mb-2">Ajouter</button>
                </div>
            </form:form>
            <a href="<spring:url value="/technicien/techniciens" />">
                <i class="fa fa-arrow-left"></i><span class="mx-2">Retour à la liste</span>
            </a>
        </div>
        <div class="col-3"></div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>