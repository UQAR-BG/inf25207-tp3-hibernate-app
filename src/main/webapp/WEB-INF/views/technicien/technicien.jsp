<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="technicien" value="${technicien}" scope="request"/>
<c:set var="employe" value="${technicien.employe}" scope="request"/>
<c:set var="specialisations" value="${specialisations}" scope="request"/>
<c:set var="reparations" value="${reparations}" scope="request"/>
<c:set var="employes" value="${employes}" scope="request"/>
<c:set var="isUpdating" value="${isUpdating}" scope="request"/>

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
                    <form:form method="POST" action="/technicien/save/${technicien.matricule}" modelAttribute="technicien">
                        <div class="row">
                            <div class="col-11">
                                <dl class="row">
                                    <dl class="row mt-4">
                                        <dt class="col-sm-6 col-lg-4">Employé : </dt>
                                        <dd class="col-sm-6 col-lg-8">
                                            <c:choose>
                                                <c:when test="${isUpdating}">
                                                    <form:select class="form-select" id="inputEmploye" path="employe" cssErrorClass="form-control is-invalid">
                                                        <form:option value="-1" label="Sélectionnez un employé ..."/>
                                                        <form:options items="${employes}" itemValue="matricule" />
                                                    </form:select>
                                                    <form:errors path="employe" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                                                </c:when>
                                                <c:otherwise>
                                                    <a href="<spring:url value="/employe/employe/${employe.matricule}" />">
                                                            ${employe}
                                                    </a>
                                                </c:otherwise>
                                            </c:choose>
                                        </dd>

                                        <dt class="col-sm-6 col-lg-4">Adresse : </dt>
                                        <dd class="col-sm-6 col-lg-8">
                                            <a href="<spring:url value="/adresse/adresse/${employe.adresse.id}" />">
                                                    ${employe.adresse}
                                            </a>
                                        </dd>
                                    </dl>
                                </dl>
                            </div>
                            <div class="col-1">
                                <c:choose>
                                    <c:when test="${!isUpdating}">
                                        <a class="btn btn-outline-success" href="<spring:url value="/technicien/update/${technicien.matricule}" />">
                                            <i class="fa fa-pen-to-square"></i>
                                        </a>
                                    </c:when>
                                </c:choose>
                            </div>
                        </div>
                        <c:choose>
                            <c:when test="${isUpdating}">
                                <div class="row">
                                    <div class="col-4">
                                        <a class="btn btn-outline-danger" href="<spring:url value="/technicien/technicien/${technicien.matricule}" />">
                                            Annuler
                                        </a>
                                        <button type="submit" class="btn btn-success btn-block" href="<spring:url value="/technicien/save/${technicien.matricule}" />">
                                            Modifier
                                        </button>
                                    </div>
                                </div>
                            </c:when>
                        </c:choose>
                    </form:form>
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