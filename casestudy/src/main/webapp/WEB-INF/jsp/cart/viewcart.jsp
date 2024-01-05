<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>


 <h2>Order Details</h2>

    <c:forEach var="orderDetail" items="${orderDetails}">
        <p>Product ID: ${orderDetail.product.id}</p>
        <p>Order ID: ${orderDetail.order.id}</p>
        <p>Quantity Ordered: ${orderDetail.quantityOrdered}</p>
        <p>Price Each: ${orderDetail.priceEach}</p>
        <!-- Add more details as needed -->
    </c:forEach>

<jsp:include page="../include/footer.jsp"/>