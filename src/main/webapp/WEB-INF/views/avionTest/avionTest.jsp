<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="avionTest" value="${avionTest}" scope="request"/>
<c:set var="avion" value="${avionTest.avion}" scope="request"/>
<c:set var="test" value="${avionTest.test}" scope="request"/>
<c:set var="avions" value="${avions}" scope="request"/>
<c:set var="tests" value="${tests}" scope="request"/>
<c:set var="isUpdating" value="${isUpdating}" scope="request"/>

<html lang="en">
    <jsp:include page="../shared/_head.jsp"/>
    <body>
        <jsp:include page="../shared/_navbar.jsp"/>
        <div class="container">
            <div class="row mt-4">
                <h2>Test pour un avion #${avionTest.id}</h2>
            </div>
            <div class="row mt-4">
                <div class="container-fluid">
                    <form:form method="POST" action="/avionTest/save/${avionTest.id}" modelAttribute="avionTest">
                        <div class="row">
                            <div class="col-11">
                                <dl class="row">
                                    <dt class="col-sm-6 col-lg-4">Avion : </dt>
                                    <dd class="col-sm-6 col-lg-8">
                                        <c:choose>
                                            <c:when test="${isUpdating}">
                                                <form:select class="form-select" id="inputAvion" path="avion" cssErrorClass="form-control is-invalid">
                                                    <form:option value="-1" label="Sélectionnez un avion ..."/>
                                                    <form:options items="${avions}" itemValue="matricule" />
                                                </form:select>
                                                <form:errors path="avion" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                                            </c:when>
                                            <c:otherwise>
                                                <a href="<spring:url value="/avion/avion/${avion.matricule}" />">
                                                        ${avion}
                                                </a>
                                            </c:otherwise>
                                        </c:choose>
                                    </dd>

                                    <dt class="col-sm-6 col-lg-4">Test : </dt>
                                    <dd class="col-sm-6 col-lg-8">
                                        <c:choose>
                                            <c:when test="${isUpdating}">
                                                <form:select class="form-select" id="inputTest" path="test" cssErrorClass="form-control is-invalid">
                                                    <form:option value="-1" label="Sélectionnez un test ..."/>
                                                    <form:options items="${tests}" itemValue="numero" />
                                                </form:select>
                                                <form:errors path="test" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                                            </c:when>
                                            <c:otherwise>
                                                <a href="<spring:url value="/test/test/${test.numero}" />">
                                                        ${test}
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
                                                ${avionTest.getLocalDate()}
                                            </c:otherwise>
                                        </c:choose>
                                    </dd>
                                </dl>
                            </div>
                            <div class="col-1">
                                <c:choose>
                                    <c:when test="${!isUpdating}">
                                        <a class="btn btn-outline-success" href="<spring:url value="/avionTest/update/${avionTest.id}" />">
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
                                        <a class="btn btn-outline-danger" href="<spring:url value="/avionTest/avionTest/${avionTest.id}" />">
                                            Annuler
                                        </a>
                                        <button type="submit" class="btn btn-success btn-block" href="<spring:url value="/avionTest/save/${avionTest.id}" />">
                                            Modifier
                                        </button>
                                    </div>
                                </div>
                            </c:when>
                        </c:choose>
                    </form:form>
                </div>
            </div>
            <a href="<spring:url value="/avionTest/avionTests" />">
                <i class="fa fa-arrow-left"></i><span class="mx-2">Retour à la liste</span>
            </a>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>