<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../include/header.jsp"/>

<div class="container mt-5">
    <h1 class="mb-4">View Shopping Cart</h1>

    <c:if test="${not empty order and not empty order}">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Order ID: ${order.id}</h5>
                <p class="card-text">Order Status: ${order.status}</p>

                <!-- Add more order details as needed -->

                <h3>Order Details:</h3>
                <c:if test="${not empty orderdetail}">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Product</th>
                                <th>Quantity</th>
                                <!-- Add more columns as needed -->
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="detail" items="${orderdetail}">
                                <tr>
                                    <td>${detail.product.productName}</td>
                                    <td>${detail.quantityOrdered}</td>
                                    <!-- Add more cells as needed -->
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>

                <h3>Total Order Details:</h3>
                <c:if test="${not empty orderdetail1}">
                    <p>Total Quantity Ordered: ${orderdetail1.totalQuantity}</p>
                    <p>Total Price: $${orderdetail1.totalPrice}</p>
                </c:if>
            </div>
        </div>
    </c:if>

    <c:if test="${empty order}">
        <p>Your shopping cart is empty.</p>
        <a href="/product/search" class="btn btn-secondary">Start Shopping</a>
    </c:if>
</div>

<jsp:include page="../include/footer.jsp"/>
