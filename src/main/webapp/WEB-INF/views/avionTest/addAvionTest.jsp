<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="avions" value="${avions}" scope="request"/>
<c:set var="tests" value="${tests}" scope="request"/>

<html lang="en">
    <jsp:include page="../shared/_head.jsp"/>
    <body>
        <jsp:include page="../shared/_navbar.jsp"/>
        <div class="container">
            <div class="row mt-4">
                <div class="col-3"></div>
                <div class="col-6">
                    <h2>Ajouter un test pour un avion</h2>
                    <form:form class="form my-4" method="POST" action="/avionTest/save" modelAttribute="avionTest">
                        <div class="form-group mt-3">
                            <form:label path="avion">Avion</form:label>
                            <form:select class="form-select" id="inputAvion" path="avion" cssErrorClass="form-control is-invalid">
                                <form:option value="-1" label="Sélectionnez un avion ..."/>
                                <form:options items="${avions}" itemValue="matricule" />
                            </form:select>
                            <form:errors path="avion" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                        </div>
                        <div class="form-group mt-3">
                            <form:label path="test">Test</form:label>
                            <form:select class="form-select" id="inputTest" path="test" cssErrorClass="form-control is-invalid">
                                <form:option value="-1" label="Sélectionnez un test ..."/>
                                <form:options items="${tests}" itemValue="numero" />
                            </form:select>
                            <form:errors path="test" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                        </div>
                        <div class="form-group mt-3">
                            <form:label path="date">Date</form:label>
                            <form:input type="date" class="form-control" id="inputDate" path="date" cssErrorClass="form-control is-invalid"/>
                            <form:errors path="date" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                        </div>
                        <div class="form-group mt-3">
                            <button type="submit" class="btn btn-primary mb-2">Ajouter</button>
                        </div>
                    </form:form>
                    <a href="<spring:url value="/avionTest/avionTests" />">
                        <i class="fa fa-arrow-left"></i><span class="mx-2">Retour à la liste</span>
                    </a>
                </div>
                <div class="col-3"></div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>