<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="examination" value="${examination}" scope="request"/>
<c:set var="pilote" value="${examination.pilote}" scope="request"/>
<c:set var="examen" value="${examination.examen}" scope="request"/>

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
                    <dl class="row mt-4">
                        <dt class="col-sm-6 col-lg-4">Pilote : </dt>
                        <dd class="col-sm-6 col-lg-8">
                            <a href="<spring:url value="/pilote/pilote/${pilote.matricule}" />">
                                ${pilote}
                            </a>
                        </dd>

                        <dt class="col-sm-6 col-lg-4">Examen : </dt>
                        <dd class="col-sm-6 col-lg-8">
                            <a href="<spring:url value="/examen/examen/${examen.idExamen}" />">
                                ${examen}
                            </a>
                        </dd>

                        <dt class="col-sm-6 col-lg-4">Date : </dt>
                        <dd class="col-sm-6 col-lg-8">${examination.getLocalDate()}</dd>

                        <dt class="col-sm-6 col-lg-4">Rapport : </dt>
                        <dd class="col-sm-6 col-lg-8">${examination.rapport}</dd>
                    </dl>
                </div>
            </div>
            <a href="<spring:url value="/examination/examinations" />">
                <i class="fa fa-arrow-left"></i><span class="mx-2">Retour à la liste</span>
            </a>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>