<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="examen" value="${examen}" scope="request"/>
<c:set var="examinations" value="${examen.examinations}" scope="request"/>
<c:set var="pilotes" value="${pilotes}" scope="request"/>

<html lang="en">
    <jsp:include page="../shared/_head.jsp"/>
    <body>
        <jsp:include page="../shared/_navbar.jsp"/>
        <div class="container">
            <div class="row mt-4">
                <h2>Examen #${examen.idExamen}</h2>
            </div>
            <div class="row mt-4">
                <div class="container-fluid">
                    <dl class="row mt-4">
                        <dt class="col-sm-6 col-lg-4">Description : </dt>
                        <dd class="col-sm-6 col-lg-8">${examen.description}</dd>

                        <dt class="col-sm-6 col-lg-4">Observations : </dt>
                        <dd class="col-sm-6 col-lg-8">${examen.examenCol}</dd>
                    </dl>
                </div>
            </div>
            <c:choose>
                <c:when test="${examinations != null && !examinations.isEmpty()}">
                    <div class="row mt-4">
                        <hr/>
                        <h4>Examinations associées avec cet examen:</h4>
                        <jsp:include page="../examination/_piloteList.jsp"/>
                    </div>
                </c:when>
            </c:choose>
            <c:choose>
                <c:when test="${pilotes != null && !pilotes.isEmpty()}">
                    <div class="row mt-4">
                        <hr/>
                        <h4>Pilotes associés avec cet examen:</h4>
                        <jsp:include page="../pilote/_piloteList.jsp"/>
                    </div>
                </c:when>
            </c:choose>
            <a href="<spring:url value="/examen/examens" />">
                <i class="fa fa-arrow-left"></i><span class="mx-2">Retour à la liste</span>
            </a>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>