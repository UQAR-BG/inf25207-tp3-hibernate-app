<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="examination" value="${examination}" scope="request"/>
<c:set var="pilote" value="${examination.pilote}" scope="request"/>
<c:set var="examen" value="${examination.examen}" scope="request"/>
<c:set var="pilotes" value="${pilotes}" scope="request"/>
<c:set var="examens" value="${examens}" scope="request"/>
<c:set var="isUpdating" value="${isUpdating}" scope="request"/>

<html lang="en">
    <jsp:include page="../shared/_head.jsp"/>
    <body>
        <jsp:include page="../shared/_navbar.jsp"/>
        <div class="container">
            <div class="row mt-4">
                <h2>Examen d'un pilote #${examination.idExamination}</h2>
            </div>
            <div class="row mt-4">
                <div class="container-fluid">
                    <form:form method="POST" action="/examination/save/${examination.idExamination}" modelAttribute="examination">
                        <div class="row">
                            <div class="col-11">
                                <dl class="row">
                                    <dt class="col-sm-6 col-lg-4">Pilote : </dt>
                                    <dd class="col-sm-6 col-lg-8">
                                        <c:choose>
                                            <c:when test="${isUpdating}">
                                                <form:select class="form-select" id="inputPilote" path="pilote" cssErrorClass="form-control is-invalid">
                                                    <form:option value="-1" label="Sélectionnez un pilote ..."/>
                                                    <form:options items="${pilotes}" itemValue="matricule" />
                                                </form:select>
                                                <form:errors path="pilote" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                                            </c:when>
                                            <c:otherwise>
                                                <a href="<spring:url value="/pilote/pilote/${pilote.matricule}" />">
                                                        ${pilote}
                                                </a>
                                            </c:otherwise>
                                        </c:choose>
                                    </dd>

                                    <dt class="col-sm-6 col-lg-4">Examen : </dt>
                                    <dd class="col-sm-6 col-lg-8">
                                        <c:choose>
                                            <c:when test="${isUpdating}">
                                                <form:select class="form-select" id="inputExamen" path="examen" cssErrorClass="form-control is-invalid">
                                                    <form:option value="-1" label="Sélectionnez un examen ..."/>
                                                    <form:options items="${examens}" itemValue="idExamen" />
                                                </form:select>
                                                <form:errors path="examen" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                                            </c:when>
                                            <c:otherwise>
                                                <a href="<spring:url value="/examen/examen/${examen.idExamen}" />">
                                                        ${examen}
                                                </a>
                                            </c:otherwise>
                                        </c:choose>
                                    </dd>

                                    <dt class="col-sm-6 col-lg-4">Date : </dt>
                                    <dd class="col-sm-6 col-lg-8">
                                        <c:choose>
                                            <c:when test="${isUpdating}">
                                                <form:input type="date" class="form-control" id="inputDate" path="date" cssErrorClass="form-control is-invalid"/>
                                                <form:errors path="date" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                                            </c:when>
                                            <c:otherwise>
                                                ${examination.getLocalDate()}
                                            </c:otherwise>
                                        </c:choose>
                                    </dd>

                                    <dt class="col-sm-6 col-lg-4">Rapport : </dt>
                                    <dd class="col-sm-6 col-lg-8">
                                        <c:choose>
                                            <c:when test="${isUpdating}">
                                                <form:textarea class="form-control" id="inputRapport" path="rapport" cssErrorClass="form-control is-invalid" rows="4"/>
                                                <form:errors path="rapport" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                                            </c:when>
                                            <c:otherwise>
                                                ${examination.rapport}
                                            </c:otherwise>
                                        </c:choose>
                                    </dd>
                                </dl>
                            </div>
                            <div class="col-1">
                                <c:choose>
                                    <c:when test="${!isUpdating}">
                                        <a class="btn btn-outline-success" href="<spring:url value="/examination/update/${examination.idExamination}" />">
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
                                        <a class="btn btn-outline-danger" href="<spring:url value="/examination/examination/${examination.idExamination}" />">
                                            Annuler
                                        </a>
                                        <button type="submit" class="btn btn-success btn-block" href="<spring:url value="/examination/save/${examination.idExamination}" />">
                                            Modifier
                                        </button>
                                    </div>
                                </div>
                            </c:when>
                        </c:choose>
                    </form:form>
                </div>
            </div>
            <a href="<spring:url value="/examination/examinations" />">
                <i class="fa fa-arrow-left"></i><span class="mx-2">Retour à la liste</span>
            </a>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>