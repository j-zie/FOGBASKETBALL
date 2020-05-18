<%--
  Created by IntelliJ IDEA.
  User: zie
  Date: 4/23/20
  Time: 3:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file = "../includes/Adminheader.jsp" %>

<p class="flow-text">Styk-listen laves lige nu med følgende antagelser:</p>
<ul>
    <li>56 centimeter mellem spær</li>
    <li>Afstand mellem stolper er 180 cm</li>
    <li>Der skal være minimum 4 stolper</li>
    <li>Defaulter til en tagtype:'EternittagB7-Sort'</li>
    <li>2 Vinkelbeslag per spær</li>
    <li>Stoler er cementerede med sokkelsko</li>
    <li>Ingen priser lige nu</li>
</ul>

${sessionScope.page}



<br>
<br>

<a class="btn center" href="FrontController?target=sendstkliste&oid=${requestScope.oid}&bid=${requestScope.bid}" > Send tilbud til kunde</a>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

<%@ include file = "../includes/footer.jsp" %>
