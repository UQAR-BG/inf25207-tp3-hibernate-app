<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
    <jsp:include page="shared/_head.jsp"/>
    <body>
        <jsp:include page="shared/_navbar.jsp"/>
        <div class="container">
            <div class="row mt-4">
                <h2>Bienvenue sur mon application Spring Boot MVC avec Hibernate !</h2>
            </div>
            <div class="row mt-4">
                <span>Veuillez sélectionner l'entité à consulter.</span>
                <ul class="mt-3 mx-5">
                    <li><a href="<spring:url value="/adresse/adresses" />">Consulter la page : Adresse</a></li>
                    <li><a href="<spring:url value="/avion/avions" />">Consulter la page : Avion</a></li>
                    <li><a href="<spring:url value="/avionTest/avionTests" />">Consulter la page : AvionTest</a></li>
                    <li><a href="<spring:url value="/employe/employes" />">Consulter la page : Employé</a></li>
                    <li><a href="<spring:url value="/examen/examens" />">Consulter la page : Examen</a></li>
                    <li><a href="<spring:url value="/examination/examinations" />">Consulter la page : Examination</a></li>
                    <li><a href="<spring:url value="/pilote/pilotes" />">Consulter la page : Pilote</a></li>
                    <li><a href="<spring:url value="/piloter/listePiloter" />">Consulter la page : Piloter</a></li>
                    <li><a href="<spring:url value="/qualification/qualifications" />">Consulter la page : Qualification</a></li>
                    <li><a href="<spring:url value="/reparation/reparations" />">Consulter la page : Réparation</a></li>
                    <li><a href="<spring:url value="/specialisation/specialisations" />">Consulter la page : Spécialisation</a></li>
                    <li><a href="<spring:url value="/technicien/techniciens" />">Consulter la page : Technicien</a></li>
                    <li><a href="<spring:url value="/test/tests" />">Consulter la page : Test</a></li>
                    <li><a href="<spring:url value="/type/types" />">Consulter la page : Type</a></li>
                </ul>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>