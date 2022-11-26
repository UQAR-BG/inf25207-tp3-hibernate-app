<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<jsp:include page="../shared/head.jsp"/>
<body>
<jsp:include page="../shared/navbar.jsp"/>
<div class="container">
    <div class="row mt-4">
        <h2>Adresse #${adresse.id}</h2>
    </div>
    <div class="row mt-4">
        <div class="container-fluid">
            <dl class="row mt-4">
                <dt class="col-sm-6 col-lg-4">Numéro de rue : </dt>
                <dd class="col-sm-6 col-lg-8">${adresse.numeroRue}</dd>

                <dt class="col-sm-6 col-lg-4">Nom de rue: </dt>
                <dd class="col-sm-6 col-lg-8">${adresse.nomRue}</dd>

                <dt class="col-sm-6 col-lg-4">Ville : </dt>
                <dd class="col-sm-6 col-lg-8">${adresse.ville}</dd>

                <dt class="col-sm-6 col-lg-4">Province : </dt>
                <dd class="col-sm-6 col-lg-8">${adresse.province}</dd>

                <dt class="col-sm-6 col-lg-4">Pays : </dt>
                <dd class="col-sm-6 col-lg-8">${adresse.pays}</dd>

                <dt class="col-sm-6 col-lg-4">Code postal : </dt>
                <dd class="col-sm-6 col-lg-8">${adresse.codePostal}</dd>
            </dl>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>