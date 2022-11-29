<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="specialisation" value="${specialisation}" scope="request"/>
<c:set var="type" value="${specialisation.type}" scope="request"/>
<c:set var="technicien" value="${specialisation.technicien}" scope="request"/>

<html lang="en">
    <jsp:include page="../shared/_head.jsp"/>
    <body>
        <jsp:include page="../shared/_navbar.jsp"/>
        <div class="container">
            <div class="row mt-4">
                <h2>Spécialisation</h2>
            </div>
            <div class="row mt-4">
                <div class="container-fluid">
                    <dl class="row mt-4">
                        <dt class="col-sm-6 col-lg-4">Type : </dt>
                        <dd class="col-sm-6 col-lg-8">
                            <a href="<spring:url value="/type/type/${type.id}" />">
                                ${type}
                            </a>
                        </dd>

                        <dt class="col-sm-6 col-lg-4">Technicien : </dt>
                        <dd class="col-sm-6 col-lg-8">
                            <a href="<spring:url value="/examen/examen/${technicien.matricule}" />">
                                ${technicien}
                            </a>
                        </dd>
                    </dl>
                </div>
            </div>
            <a href="<spring:url value="/specialisation/specialisations" />">
                <i class="fa fa-arrow-left"></i><span class="mx-2">Retour à la liste</span>
            </a>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>