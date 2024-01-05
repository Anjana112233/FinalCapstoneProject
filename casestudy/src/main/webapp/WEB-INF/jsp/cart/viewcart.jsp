<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>
<h2>Your Cart Details</h2>

<c:if test="${not empty order and not empty Order.orderdetails}">
     <table class="table">
                <thead>
                    <tr>
                        <th>ProductName</th>
                        <th>Product Image</th>
                        <th>Quantity Ordered</th>
                        <th>Price</th>
                        <!-- Add more columns as needed -->
                    </tr>
                </thead>
                <tbody>
    <p>Order ID: ${order.id}</p>
    <p>Order Status: ${order.status}</p>

</c:if>

<c:if test="${not empty orderdetail}">
    <h3>Order Details</h3>
    <table border="1">
        <thead>
            <tr>
                <th>Product ID</th>
                <th>Quantity Ordered</th>
                <!-- Add more headers as needed -->
            </tr>
        </thead>
        <tbody>
            <c:forEach var="detail" items="${orderdetail}">
                <tr>
                    <td>${detail.product.id}</td>
                    <td>${detail.quantityOrdered}</td>
                    <!-- Add more cells as needed -->
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>

<c:if test="${not empty orderdetail1}">
    <h3>Total Order Details</h3>
    <p>Total Quantity Ordered: ${orderdetail1.totalQuantity}</p>
    <p>Total Price: ${orderdetail1.totalPrice}</p>
</c:if>
<jsp:include page="../include/footer.jsp"/>