<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="employe" value="${employe}" scope="request"/>
<c:set var="techniciens" value="${employe.getTechniciens()}" scope="request"/>
<c:set var="pilotes" value="${employe.getPilotes()}" scope="request"/>
<c:set var="adresses" value="${adresses}" scope="request"/>
<c:set var="isUpdating" value="${isUpdating}" scope="request"/>

<html lang="en">
    <jsp:include page="../shared/_head.jsp"/>
    <body>
        <jsp:include page="../shared/_navbar.jsp"/>
        <div class="container">
            <div class="row mt-4">
                <h2>Employé #${employe.matricule}</h2>
            </div>
            <div class="row mt-4">
                <div class="container-fluid">
                    <form:form method="POST" action="/employe/save/${employe.matricule}" modelAttribute="employe">
                        <div class="row">
                            <div class="col-11">
                                <dl class="row">
                                    <dt class="col-sm-6 col-lg-4">Prénom : </dt>
                                    <dd class="col-sm-6 col-lg-8">
                                        <c:choose>
                                            <c:when test="${isUpdating}">
                                                <form:input type="text" class="form-control" id="inputPrenom" path="prenom" cssErrorClass="form-control is-invalid" maxlength="45"/>
                                                <form:errors path="prenom" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                                            </c:when>
                                            <c:otherwise>
                                                ${employe.prenom}
                                            </c:otherwise>
                                        </c:choose>
                                    </dd>

                                    <dt class="col-sm-6 col-lg-4">Nom : </dt>
                                    <dd class="col-sm-6 col-lg-8">
                                        <c:choose>
                                            <c:when test="${isUpdating}">
                                                <form:input type="text" class="form-control" id="inputNom" path="nom" cssErrorClass="form-control is-invalid" maxlength="45"/>
                                                <form:errors path="nom" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                                            </c:when>
                                            <c:otherwise>
                                                ${employe.nom}
                                            </c:otherwise>
                                        </c:choose>
                                    </dd>

                                    <dt class="col-sm-6 col-lg-4">Adresse : </dt>
                                    <dd class="col-sm-6 col-lg-8">
                                        <c:choose>
                                            <c:when test="${isUpdating}">
                                                <form:select class="form-select" id="inputAdresse" path="adresse" cssErrorClass="form-control is-invalid">
                                                    <form:option value="-1" label="Sélectionnez une adresse ..."/>
                                                    <form:options items="${adresses}" itemValue="id" />
                                                </form:select>
                                                <form:errors path="adresse" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                                            </c:when>
                                            <c:otherwise>
                                                <a href="<spring:url value="/adresse/adresse/${employe.adresse.id}" />">
                                                        ${employe.adresse}
                                                </a>
                                            </c:otherwise>
                                        </c:choose>
                                    </dd>

                                    <dt class="col-sm-6 col-lg-4">Numéro de téléphone : </dt>
                                    <dd class="col-sm-6 col-lg-8">
                                        <c:choose>
                                            <c:when test="${isUpdating}">
                                                <form:input type="text" class="form-control" id="inputTelephone" path="telephone" cssErrorClass="form-control is-invalid" maxlength="45"/>
                                                <form:errors path="telephone" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                                            </c:when>
                                            <c:otherwise>
                                                ${employe.telephone}
                                            </c:otherwise>
                                        </c:choose>
                                    </dd>

                                    <dt class="col-sm-6 col-lg-4">Date d'embauche : </dt>
                                    <dd class="col-sm-6 col-lg-8">
                                        <c:choose>
                                            <c:when test="${isUpdating}">
                                                <form:input type="date" class="form-control" id="inputDateEngagement" path="dateEngagement" cssErrorClass="form-control is-invalid"/>
                                                <form:errors path="dateEngagement" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                                            </c:when>
                                            <c:otherwise>
                                                ${employe.getLocalDate()}
                                            </c:otherwise>
                                        </c:choose>
                                    </dd>

                                    <dt class="col-sm-6 col-lg-4">Salaire : </dt>
                                    <dd class="col-sm-6 col-lg-8">
                                        <c:choose>
                                            <c:when test="${isUpdating}">
                                                <form:input type="number" class="form-control" id="inputSalaire" path="salaire" cssErrorClass="form-control is-invalid" min="0.00" max="9999999999.99" step=".01"/>
                                                <form:errors path="salaire" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                                            </c:when>
                                            <c:otherwise>
                                                ${employe.getSalaireFormatted()}
                                            </c:otherwise>
                                        </c:choose>
                                    </dd>
                                </dl>
                            </div>
                            <div class="col-1">
                                <c:choose>
                                    <c:when test="${!isUpdating}">
                                        <a class="btn btn-outline-success" href="<spring:url value="/employe/update/${employe.matricule}" />">
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
                                        <a class="btn btn-outline-danger" href="<spring:url value="/employe/employe/${employe.matricule}" />">
                                            Annuler
                                        </a>
                                        <button type="submit" class="btn btn-success btn-block" href="<spring:url value="/employe/save/${employe.matricule}" />">
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
                <c:when test="${techniciens != null && !techniciens.isEmpty()}">
                    <div class="row mt-4">
                        <hr/>
                        <h4>Technicien associé avec cet employé:</h4>
                        <jsp:include page="../technicien/_technicienList.jsp"/>
                    </div>
                </c:when>
            </c:choose>
            <c:choose>
                <c:when test="${pilotes != null && !pilotes.isEmpty()}">
                    <div class="row mt-4">
                        <hr/>
                        <h4>Pilote associé avec cet employé:</h4>
                        <jsp:include page="../pilote/_piloteList.jsp"/>
                    </div>
                </c:when>
            </c:choose>
            <a href="<spring:url value="/employe/employes" />">
                <i class="fa fa-arrow-left"></i><span class="mx-2">Retour à la liste</span>
            </a>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>