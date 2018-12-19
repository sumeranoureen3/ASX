<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<<jsp:include page="header.jsp"></jsp:include>

<div class="container">

<h3>Form Submission</h3>
<form action='' method='Get'>

    <table class='table table-hover table-responsive table-bordered'>

            <tr>
            <td><b>Message</b></td>
            <td>${checkMessage}</td>
        </tr>
            <tr>
            <td><b>Payment Date Message:</b></td>
            <td>${payDateMessage}</td>
        </tr>
 
        <tr>
            <td><b>Record Date</b></td>
            <td>${user.recordDate}</td>
        </tr>
 
        <tr>
            <td><b>Payment Date</b></td>
            <td><%= request.getParameter("paymentDate") %></td>
        </tr>
 
        
 
 			<input type='hidden' id='id' rows='5' class='form-control' name='id' value="${user.id}"/>

 
    </table>
</form>


</div>

