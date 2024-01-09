<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pub/css/detail.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<jsp:include page="../include/header.jsp"/>

<section>
    <div class="bg-light2 pt-5 pb-5">
        <div class="row">
            <div class="col-12 text-center">
                <h1 class="m-0 text-dark">Check out</h1>

                <table class="table">
                            <thead>
                                <tr>
                                    <th>Product</th>
                                    <th>Quantity</th>
                                    <th>Price</th>
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
                        Total Price: ${totalPrice}
            </div>
        </div>
    </div>
</section>
<a href="/cart/place_order" class="btn btn-primary">Place Order</a>

<jsp:include page="../include/footer.jsp"/>
