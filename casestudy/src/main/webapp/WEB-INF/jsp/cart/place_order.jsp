<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pub/css/detail.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<jsp:include page="../include/header.jsp"/>

<section>
    <div class="bg-light2 pt-5 pb-5">
        <div class="row">
            <div class="col-12 text-center">
               Your order has been placed.
            </div>

            <div class="col-12 text-center">
               Order Details:

               Order ID: ${order.id}

               <table class="table">
                           <thead>
                               <tr>
                                   <th>Product</th>
                                   <th>Quantity</th>
                               </tr>
                           </thead>
                           <tbody>
                               <c:forEach var="orderedItem" items="${orderedItems}">
                                   <tr>
                                       <td>${orderedItem.product.productName}</td>
                                       <td>${orderedItem.quantity}</td>
                                   </tr>
                               </c:forEach>
                           </tbody>
                       </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>
