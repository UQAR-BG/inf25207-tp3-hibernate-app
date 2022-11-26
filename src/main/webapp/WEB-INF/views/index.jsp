<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
    <jsp:include page="head.jsp"/>
    <body>
        <jsp:include page="navbar.jsp"/>
        <div class="container">
            <div class="row mt-4">
                <h1>Spring Boot JSP Example</h1>
                <h2>Hello ${message}</h2>

                <span>Click on this <strong><a href="next">link</a></strong> to visit another page.</span>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>