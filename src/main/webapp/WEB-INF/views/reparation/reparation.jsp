<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="reparation" value="${reparation}" scope="request"/>
<c:set var="avion" value="${reparation.avion}" scope="request"/>
<c:set var="technicien" value="${reparation.technicien}" scope="request"/>

<html lang="en">
    <jsp:include page="../shared/_head.jsp"/>
    <body>
        <jsp:include page="../shared/_navbar.jsp"/>
        <div class="container">
            <div class="row mt-4">
                <h2>Réparation #${reparation.id}</h2>
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

                        <dt class="col-sm-6 col-lg-4">Technicien : </dt>
                        <dd class="col-sm-6 col-lg-8">
                            <a href="<spring:url value="/examen/examen/${technicien.matricule}" />">
                                ${technicien}
                            </a>
                        </dd>

                        <dt class="col-sm-6 col-lg-4">Date : </dt>
                        <dd class="col-sm-6 col-lg-8">${reparation.getLocalDate()}</dd>

                        <dt class="col-sm-6 col-lg-4">Coût total : </dt>
                        <dd class="col-sm-6 col-lg-8">${reparation.getCoutTotalFormatted()}</dd>
                    </dl>
                </div>
            </div>
            <a href="<spring:url value="/reparation/reparations" />">
                <i class="fa fa-arrow-left"></i><span class="mx-2">Retour à la liste</span>
            </a>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>