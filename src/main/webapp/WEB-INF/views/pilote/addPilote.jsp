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
                    <h2>Ajouter un examen</h2>
                    <form:form class="form my-4" method="POST" action="/examen/save" modelAttribute="examen">
                        <div class="form-group mt-3">
                            <form:label path="description">Description</form:label>
                            <form:input type="text" class="form-control" id="inputDescription" path="description" cssErrorClass="form-control is-invalid" maxlength="45"/>
                            <form:errors path="description" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                        </div>
                        <div class="form-group mt-3">
                            <form:label path="examenCol">Observations</form:label>
                            <form:textarea class="form-control" id="inputExamenCol" path="examenCol" cssErrorClass="form-control is-invalid" rows="4"/>
                            <form:errors path="examenCol" cssClass="error" cssStyle="color: #ff0000; font-size: small;"/>
                        </div>
                        <div class="form-group mt-3">
                            <button type="submit" class="btn btn-primary mb-2">Ajouter</button>
                        </div>
                    </form:form>
                    <a href="<spring:url value="/examen/examens" />">
                        <i class="fa fa-arrow-left"></i><span class="mx-2">Retour à la liste</span>
                    </a>
                </div>
                <div class="col-3"></div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>