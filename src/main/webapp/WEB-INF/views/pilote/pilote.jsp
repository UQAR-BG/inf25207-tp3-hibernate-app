<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="pilote" value="${pilote}" scope="request"/>
<c:set var="employe" value="${pilote.employe}" scope="request"/>
<c:set var="examinations" value="${examinations}" scope="request"/>
<c:set var="listePiloter" value="${listePiloter}" scope="request"/>
<c:set var="qualifications" value="${qualifications}" scope="request"/>
<c:set var="employes" value="${employes}" scope="request"/>
<c:set var="isUpdating" value="${isUpdating}" scope="request"/>

<html lang="en">
    <jsp:include page="../shared/_head.jsp"/>
    <body>
        <jsp:include page="../shared/_navbar.jsp"/>
        <div class="container">
            <div class="row mt-4">
                <h2>Pilote #${pilote.matricule}</h2>
            </div>
            <div class="row mt-4">
                <div class="container-fluid">
                    <form:form method="POST" action="/pilote/save/${pilote.matricule}" modelAttribute="pilote">
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
                                        <a class="btn btn-outline-success" href="<spring:url value="/pilote/update/${pilote.matricule}" />">
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
                                        <a class="btn btn-outline-danger" href="<spring:url value="/pilote/pilote/${pilote.matricule}" />">
                                            Annuler
                                        </a>
                                        <button type="submit" class="btn btn-success btn-block" href="<spring:url value="/pilote/save/${pilote.matricule}" />">
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
                <c:when test="${examinations != null && !examinations.isEmpty()}">
                    <div class="row mt-4">
                        <hr/>
                        <h4>Examinations associées avec ce pilote:</h4>
                        <jsp:include page="../examination/_examinationList.jsp"/>
                    </div>
                </c:when>
            </c:choose>
            <c:choose>
                <c:when test="${listePiloter != null && !listePiloter.isEmpty()}">
                    <div class="row mt-4">
                        <hr/>
                        <h4>Expériences de vol associées avec ce pilote:</h4>
                        <jsp:include page="../piloter/_piloterList.jsp"/>
                    </div>
                </c:when>
            </c:choose>
            <c:choose>
                <c:when test="${qualifications != null && !qualifications.isEmpty()}">
                    <div class="row mt-4">
                        <hr/>
                        <h4>Qualifications associées avec ce pilote:</h4>
                        <jsp:include page="../qualification/_qualificationList.jsp"/>
                    </div>
                </c:when>
            </c:choose>
            <a href="<spring:url value="/examination/add" />">
                <i class="fa fa-plus"></i><span class="mx-2">Ajouter une examination</span>
            </a>
            <a href="<spring:url value="/piloter/add" />">
                <i class="fa fa-plus"></i><span class="mx-2">Ajouter une expérience</span>
            </a>
            <a href="<spring:url value="/qualification/add" />">
                <i class="fa fa-plus"></i><span class="mx-2">Ajouter une qualification</span>
            </a>
            <a href="<spring:url value="/pilote/pilotes" />">
                <i class="fa fa-arrow-left"></i><span class="mx-2">Retour à la liste</span>
            </a>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>