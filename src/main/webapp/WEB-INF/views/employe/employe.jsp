<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="employe" value="${employe}" scope="request"/>
<c:set var="techniciens" value="${employe.getTechniciens()}" scope="request"/>
<c:set var="pilotes" value="${employe.getPilotes()}" scope="request"/>

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
                    <dl class="row mt-4">
                        <dt class="col-sm-6 col-lg-4">Prénom : </dt>
                        <dd class="col-sm-6 col-lg-8">${employe.prenom}</dd>

                        <dt class="col-sm-6 col-lg-4">Nom : </dt>
                        <dd class="col-sm-6 col-lg-8">${employe.nom}</dd>

                        <dt class="col-sm-6 col-lg-4">Adresse : </dt>
                        <dd class="col-sm-6 col-lg-8">
                            <a href="<spring:url value="/adresse/adresse/${employe.adresse.id}" />">
                                ${employe.adresse}
                            </a>
                        </dd>

                        <dt class="col-sm-6 col-lg-4">Date d'embauche : </dt>
                        <dd class="col-sm-6 col-lg-8">${employe.getLocalDate()}</dd>

                        <dt class="col-sm-6 col-lg-4">Salaire : </dt>
                        <dd class="col-sm-6 col-lg-8">${employe.getSalaireFormatted()}</dd>
                    </dl>
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