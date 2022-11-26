<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
    <head>
        <title>Welcome</title>
        <link href="webjars/bootstrap/5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div>
            <div>
                <h1>Spring Boot JSP Example</h1>
                <h2>Hello ${message}</h2>

                <p>Adresses ${adresses}</p>

                Click on this <strong><a href="next">link</a></strong> to visit another page.
            </div>
        </div>
        <script src="webjars/bootstrap/5.2.1/dist/js/bootstrap.min.js"></script>
    </body>
</html>