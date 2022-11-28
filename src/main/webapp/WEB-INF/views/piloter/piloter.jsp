<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="pilote" value="${pilote}" scope="request"/>
<c:set var="employe" value="${pilote.employe}" scope="request"/>
<c:set var="examinations" value="${examinations}" scope="request"/>
<c:set var="experiences" value="${experiences}" scope="request"/>
<c:set var="qualifications" value="${qualifications}" scope="request"/>

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
                    <dl class="row mt-4">
                        <dt class="col-sm-6 col-lg-4">Employé : </dt>
                        <dd class="col-sm-6 col-lg-8">
                            <a href="<spring:url value="/employe/employe/${employe.matricule}" />">
                                ${employe}
                            </a>
                        </dd>

                        <dt class="col-sm-6 col-lg-4">Adresse : </dt>
                        <dd class="col-sm-6 col-lg-8">
                            <a href="<spring:url value="/adresse/adresse/${employe.adresse.id}" />">
                                ${employe.adresse}
                            </a>
                        </dd>
                    </dl>
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
                <c:when test="${experiences != null && !experiences.isEmpty()}">
                    <div class="row mt-4">
                        <hr/>
                        <h4>Expériences de vol associées avec ce pilote:</h4>
                        <jsp:include page="../piloter/_piloterList.jsp"/>
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