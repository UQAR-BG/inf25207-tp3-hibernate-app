<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="adresse" value="${adresse}" scope="request"/>
<c:set var="employes" value="${adresse.employes}" scope="request"/>
<c:set var="isUpdating" value="${isUpdating}" scope="request"/>

<html lang="en">
    <jsp:include page="../shared/_head.jsp"/>
    <body>
        <jsp:include page="../shared/_navbar.jsp"/>
        <div class="container">
            <div class="row mt-4">
                <h2>Adresse #${adresse.id}</h2>
            </div>
            <div class="row mt-4">
                <div class="container-fluid">
                    <form:form method="POST" action="/adresse/save/${adresse.id}" modelAttribute="adresse">
                    <div class="row">
                        <div class="col-11">
                            <dl class="row">
                                <dt class="col-sm-6 col-lg-4">Numéro de rue : </dt>
                                <dd class="col-sm-6 col-lg-8">
                                    <c:choose>
                                        <c:when test="${isUpdating}">
                                            <form:input type="number" class="form-control" id="inputNumeroRue" path="numeroRue" cssErrorClass="form-control is-invalid" min="1" max="999"/>
                                            <form:errors path="numeroRue" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                                        </c:when>
                                        <c:otherwise>
                                            ${adresse.numeroRue}
                                        </c:otherwise>
                                    </c:choose>
                                </dd>

                                <dt class="col-sm-6 col-lg-4">Nom de rue: </dt>
                                <dd class="col-sm-6 col-lg-8">
                                    <c:choose>
                                        <c:when test="${isUpdating}">
                                            <form:input type="text" class="form-control" id="inputNomRue" path="nomRue" cssErrorClass="form-control is-invalid"/>
                                            <form:errors path="nomRue" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                                        </c:when>
                                        <c:otherwise>
                                            ${adresse.nomRue}
                                        </c:otherwise>
                                    </c:choose>
                                </dd>

                                <dt class="col-sm-6 col-lg-4">Ville : </dt>
                                <dd class="col-sm-6 col-lg-8">
                                    <c:choose>
                                        <c:when test="${isUpdating}">
                                            <form:input type="text" class="form-control" id="inputVille" path="ville" cssErrorClass="form-control is-invalid"/>
                                            <form:errors path="ville" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                                        </c:when>
                                        <c:otherwise>
                                            ${adresse.ville}
                                        </c:otherwise>
                                    </c:choose>
                                </dd>

                                <dt class="col-sm-6 col-lg-4">Province : </dt>
                                <dd class="col-sm-6 col-lg-8">
                                    <c:choose>
                                        <c:when test="${isUpdating}">
                                            <form:input type="text" class="form-control" id="inputProvince" path="province" cssErrorClass="form-control is-invalid"/>
                                            <form:errors path="province" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                                        </c:when>
                                        <c:otherwise>
                                            ${adresse.province}
                                        </c:otherwise>
                                    </c:choose>
                                </dd>

                                <dt class="col-sm-6 col-lg-4">Pays : </dt>
                                <dd class="col-sm-6 col-lg-8">
                                    <c:choose>
                                        <c:when test="${isUpdating}">
                                            <form:input type="text" class="form-control" id="inputPays" path="pays" cssErrorClass="form-control is-invalid"/>
                                            <form:errors path="pays" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                                        </c:when>
                                        <c:otherwise>
                                            ${adresse.pays}
                                        </c:otherwise>
                                    </c:choose>
                                </dd>

                                <dt class="col-sm-6 col-lg-4">Code postal : </dt>
                                <dd class="col-sm-6 col-lg-8">
                                    <c:choose>
                                        <c:when test="${isUpdating}">
                                            <form:input type="text" class="form-control" id="inputCodePostal" path="codePostal" cssErrorClass="form-control is-invalid"/>
                                            <form:errors path="codePostal" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                                        </c:when>
                                        <c:otherwise>
                                            ${adresse.codePostal}
                                        </c:otherwise>
                                    </c:choose>
                                </dd>
                            </dl>
                        </div>
                        <div class="col-1">
                            <c:choose>
                                <c:when test="${!isUpdating}">
                                    <a class="btn btn-outline-success" href="<spring:url value="/adresse/update/${adresse.id}" />">
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
                                    <a class="btn btn-outline-danger" href="<spring:url value="/adresse/adresse/${adresse.id}" />">
                                        Annuler
                                    </a>
                                    <button type="submit" class="btn btn-success btn-block" href="<spring:url value="/adresse/save/${adresse.id}" />">
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
                <c:when test="${employes != null && !employes.isEmpty()}">
                    <div class="row mt-4">
                        <hr/>
                        <h4>Employés associés avec cette adresse:</h4>
                        <jsp:include page="../employe/_employeList.jsp"/>
                    </div>
                </c:when>
            </c:choose>
            <a href="<spring:url value="/adresse/adresses" />">
                <i class="fa fa-arrow-left"></i><span class="mx-2">Retour à la liste</span>
            </a>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>