
<%@ include file = "../includes/adminheader.jsp" %>


<h2 style="margin-left: 10%"> Admin overview </h2>
<div style="margin-left: auto; margin-right: auto; width: 85%;">
<div style="background-image: linear-gradient(deeppink, blue); opacity: 0.7; margin: 20px; height: 150px; width: 300px;  border-radius: 20px;display: inline-block;">
    <i style="display: inline-block; margin: 10px" class="medium material-icons white-text">person</i>
    <h5 style="display: inline-block; margin-left: 10%;" class="white-text">${sessionScope.antalKunder}</h5>
    <h6 style="margin-left: 35%" class="white-text">Antal brugere</h6>
</div>
<div style="background-image: linear-gradient(lightgreen, darkgreen);opacity: 0.8; margin: 20px;height: 150px; width: 300px; border-radius: 20px; display: inline-block;">
    <i style="display: inline-block; margin: 10px" class="medium material-icons white-text">group</i>
    <h5 style="display: inline-block;margin-left: 10%;" class="white-text">${sessionScope.antalAdmins}</h5>
    <h6 style="margin-left: 35%"  class="white-text">Antal Admin</h6>
</div>
<div style="background-image: linear-gradient(orange, deeppink);opacity: 0.7; margin: 20px; height: 150px; width: 300px; border-radius: 20px; display: inline-block;">
    <i style="display: inline-block; margin: 10px" class="medium material-icons white-text">move_to_inbox</i>
    <h5 style="display: inline-block; margin-left: 10%;" class="white-text">${sessionScope.antalOrdre}</h5>
    <h6 style="margin-left: 35%" class="white-text">Antal Ordre</h6>
</div>
</div>


<%@ include file = "../includes/footer.jsp" %>
