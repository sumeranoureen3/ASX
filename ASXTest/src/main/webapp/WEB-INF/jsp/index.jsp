<%@ taglib prefix="c" 
       uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fn" 
       uri="http://java.sun.com/jsp/jstl/functions" %>
       <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp"></jsp:include>

<h3>Trading Services</h3>
<br>
<form action='/index/recordDateCheck' method='post'>


    <table class='table table-hover table-responsive table-bordered'>
 
        <tr>
            <td><b>Record Date</b></td> 
       
            <td><input type='text' name='recordDate' class='form-control' pattern="[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}" required/>
          
            

            </td>
        </tr>
 
        <tr>
            <td><b>Payment Date</b></td>
            <td><input type='text' name='paymentDate' class='form-control' required /></td>
        </tr>
 
        
 
 
       		 <tr>
            <td colspan="3"><button type="submit" class="btn btn-primary">recordDateCheck </button>
               <button type="submit" class="btn btn-primary">paymentDateCheck </button></td>
            
        </tr>

    </table>


</form>



<h3>Non- Trading Days</h3>
<br>

<table class="table table-hover">

    <thead>
    <tr><td>${checkMessage}</td></tr>
      <tr>
        <th><b>Date</b></th>
        <th><b>Trading Date</b></th>

      </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="lou">
      <tr>
        <td><c:out value="${lou.recordDate}"></c:out></td>
        <td><c:out value="${lou.paymentDate}"></c:out></td>


      </tr>

          </c:forEach>
    </tbody>
  </table>
</div>
