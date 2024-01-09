<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pub/css/detail.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<jsp:include page="../include/header.jsp"/>
    <div class="container mt-5">
    <h1 class="mb-4 text-dark">Your Last Order</h1>
    </div>
    <c:if test="${not empty order}">
        Order ID: ${order.id} <br/>
        Order Date: ${order.orderDate} <br/>
        Order Status: ${order.status} <br/>
        Order Details: <br/>
        <table class="table">
                    <thead>
                        <tr>
                            <th>Product</th>
                            <th>Quantity</th>
                            <th>Price</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="orderDetail" items="${orderDetails}">
                            <tr>
                                <td>${orderDetail.product.productName}</td>
                                <td>${orderDetail.quantityOrdered}</td>
                                <td>${orderDetail.priceEach}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
    </c:if>

    <c:if test="${empty order}">
        <p>You do not have any orders.</p>
    </c:if>
    </div>


<jsp:include page="../include/footer.jsp"/>

