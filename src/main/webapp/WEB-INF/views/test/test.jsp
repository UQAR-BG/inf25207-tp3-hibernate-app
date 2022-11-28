<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="test" value="${test}" scope="request"/>
<c:set var="avionTests" value="${avionTests}" scope="request"/>

<html lang="en">
    <jsp:include page="../shared/_head.jsp"/>
    <body>
        <jsp:include page="../shared/_navbar.jsp"/>
        <div class="container">
            <div class="row mt-4">
                <h2>Type #${test.numero}</h2>
            </div>
            <div class="row mt-4">
                <div class="container-fluid">
                    <dl class="row mt-4">
                        <dt class="col-sm-6 col-lg-4">Nom : </dt>
                        <dd class="col-sm-6 col-lg-8">${test.nom}</dd>

                        <dt class="col-sm-6 col-lg-4">Seuil : </dt>
                        <dd class="col-sm-6 col-lg-8">${test.seuil}</dd>
                    </dl>
                </div>
            </div>
            <c:choose>
                <c:when test="${avionTests != null && !avionTests.isEmpty()}">
                    <div class="row mt-4">
                        <hr/>
                        <h4>Instances de test associées avec ce test:</h4>
                        <jsp:include page="../avionTest/_avionTestList.jsp"/>
                    </div>
                </c:when>
            </c:choose>
            <a href="<spring:url value="/avionTest/add" />">
                <i class="fa fa-plus"></i><span class="mx-2">Ajouter un test sur un avion</span>
            </a>
            <a href="<spring:url value="/test/tests" />">
                <i class="fa fa-arrow-left"></i><span class="mx-2">Retour à la liste</span>
            </a>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>