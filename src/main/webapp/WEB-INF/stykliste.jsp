<%--
  Created by IntelliJ IDEA.
  User: zie
  Date: 4/23/20
  Time: 3:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file = "../includes/adminheader.jsp" %>

${sessionScope.page}
<br>
<br>

<a class="btn center waves-effect waves-light blue" href="FrontController?target=sendstkliste&oid=${requestScope.oid}&bid=${requestScope.bid}" > Send tilbud til kunde</a>

<%@ include file = "../includes/footer.jsp" %>
