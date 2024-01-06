<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pub/css/detail.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<jsp:include page="../include/header.jsp"/>
    <div class="container mt-5">
    <h1 class="mb-4">Your Shopping Cart</h1>
    </div>

     <table class="table">
            <thead>
                <tr>
                    <th>Product</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Total Price</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cartItem" items="${cartItems}">
                    <tr>
                        <td>${cartItem.product.productName}</td>
                        <td>${cartItem.quantity}</td>
                        <td>${cartItem.product.price}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>


<jsp:include page="../include/footer.jsp"/>

