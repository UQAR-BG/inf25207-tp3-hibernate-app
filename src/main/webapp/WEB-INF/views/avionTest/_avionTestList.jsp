<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
    <c:when test="${avionTests != null || !avionTests.isEmpty()}">
        <table class="table">
            <colgroup>
                <col class="col-md-1" />
                <col class="col-md-4" />
                <col class="col-md-4" />
                <col class="col-md-1" />
                <col class="col-md-1" />
                <col class="col-md-1" />
            </colgroup>
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Avion</th>
                <th scope="col">Test</th>
                <th scope="col">Date</th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${avionTests}" var="avionTest" varStatus="loop">
                <tr>
                    <th scope="row">${loop.index + 1}</th>
                    <td>
                        <a href="<spring:url value="/avion/avion/${avionTest.avion.matricule}" />">
                                ${avionTest.avion}
                        </a>
                    </td>
                    <td>
                        <a href="<spring:url value="/test/test/${avionTest.test.numero}" />">
                                ${avionTest.test}
                        </a>
                    </td>
                    <td>${avionTest.getLocalDate()}</td>
                    <td>
                        <a class="btn btn-outline-primary" href="<spring:url value="/avionTest/avionTest/${avionTest.id}" />">
                            <i class="fa fa-book-reader"></i>
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-outline-danger" href="<spring:url value="/avionTest/delete/${avionTest.id}" />">
                            <i class="fa fa-trash-can"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
</c:choose>