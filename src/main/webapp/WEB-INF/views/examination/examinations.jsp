<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="examens" value="${examens}" scope="request"/>

<html lang="en">
    <jsp:include page="../shared/_head.jsp"/>
    <body>
        <jsp:include page="../shared/_navbar.jsp"/>
        <div class="container">
            <div class="row mt-4">
                <h2>Liste des examens</h2>
            </div>
            <div class="row mt-4">
                <c:choose>
                    <c:when test="${examens == null || examens.isEmpty()}">
                        <h4>Aucun examen.</h4>
                    </c:when>
                    <c:otherwise>
                        <jsp:include page="_examinationList.jsp"/>
                    </c:otherwise>
                </c:choose>
                <a href="<spring:url value="/examen/add" />">
                    <i class="fa fa-plus"></i><span class="mx-2">Ajouter un examen</span>
                </a>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>