<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<h1>Create Order</h1>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>


<section>
    <div class="container">
          <form method="get" action="/order/createSubmit">
            <input type = "hidden" name = "id" value="${form.id}">
            <div class="mb-3">
                           <label for="orderDate" class="form-label">Order Date </label>
                           <input type="date" class="form-control" id="orderDate" name="orderDate" value="${form.orderDate}">
            </div>
            <div class="mb-3">
                          <label for="requiredDate" class="form-label">Required Date </label>
                          <input type="date" class="form-control" id="requiredDate" name="requiredDate" value="${form.requiredDate}">
            </div>
            <div class="mb-3">
                           <label for="shippedDate" class="form-label">Shipped Date </label>
                           <input type="date" class="form-control" id="shippedDate" name="shippedDate" value="${form.shippedDate}">
             </div>

              <div class="mb-3">
                                <label for="status" class="form-label">Status</label>
                               <input type="text" class="form-control" id="status" name="status" value="${form.status}">
               </div>


                       <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>