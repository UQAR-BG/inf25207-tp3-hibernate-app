<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="<spring:url value="/" />">TP3 Hibernate App</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="<spring:url value="/" />">Accueil</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Entités
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="<spring:url value="/adresse/adresses" />">Adresse</a>
                        <a class="dropdown-item" href="<spring:url value="/avion/avions" />">Avion</a>
                        <a class="dropdown-item" href="<spring:url value="/avion_test/avion_tests" />">AvionTest</a>
                        <a class="dropdown-item" href="<spring:url value="/employe/employes" />">Employé</a>
                        <a class="dropdown-item" href="<spring:url value="/examen/examens" />">Examen</a>
                        <a class="dropdown-item" href="<spring:url value="/examination/examinations" />">Examination</a>
                        <a class="dropdown-item" href="<spring:url value="/pilote/pilotes" />">Pilote</a>
                        <a class="dropdown-item" href="<spring:url value="/piloter/liste_piloter" />">Piloter</a>
                        <a class="dropdown-item" href="<spring:url value="/qualification/qualifications" />">Qualification</a>
                        <a class="dropdown-item" href="<spring:url value="/reparation/reparations" />">Réparation</a>
                        <a class="dropdown-item" href="<spring:url value="/specialisation/specialisations" />">Spécialisation</a>
                        <a class="dropdown-item" href="<spring:url value="/technicien/techniciens" />">Technicien</a>
                        <a class="dropdown-item" href="<spring:url value="/test/tests" />">Test</a>
                        <a class="dropdown-item" href="<spring:url value="/type/types" />">Type</a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>