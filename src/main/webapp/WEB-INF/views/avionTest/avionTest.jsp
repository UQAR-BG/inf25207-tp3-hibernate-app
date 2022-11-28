<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="avionTest" value="${avionTest}" scope="request"/>
<c:set var="avion" value="${avionTest.avion}" scope="request"/>
<c:set var="test" value="${avionTest.test}" scope="request"/>

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
                    <dl class="row mt-4">
                        <dt class="col-sm-6 col-lg-4">Avion : </dt>
                        <dd class="col-sm-6 col-lg-8">
                            <a href="<spring:url value="/avion/avion/${avion.matricule}" />">
                                ${avion}
                            </a>
                        </dd>

                        <dt class="col-sm-6 col-lg-4">Test : </dt>
                        <dd class="col-sm-6 col-lg-8">
                            <a href="<spring:url value="/test/test/${test.numero}" />">
                                ${test}
                            </a>
                        </dd>

                        <dt class="col-sm-6 col-lg-4">Date : </dt>
                        <dd class="col-sm-6 col-lg-8">${avionTest.getLocalDate()}</dd>
                    </dl>
                </div>
            </div>
            <a href="<spring:url value="/avionTest/avionTests" />">
                <i class="fa fa-arrow-left"></i><span class="mx-2">Retour � la liste</span>
            </a>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>