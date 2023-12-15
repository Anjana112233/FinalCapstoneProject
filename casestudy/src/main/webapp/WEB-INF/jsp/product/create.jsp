<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<h1>Create Product</h1>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>


<section>
    <div class="container">
          <form method="get" action="/product/createSubmit">
            <input type = "hidden" name = "id" value="${form.id}">
            <div class="mb-3">
                           <label for="productName" class="form-label">Product Name </label>
                           <input type="text" class="form-control" id="productName" name="productName" value="${form.productName}">
                       </div>
                       <div class="mb-3">
                            <label for="productDescription" class="form-label"> Description of Product</label>
                             <input type="text" class="form-control" id="productDescription" name="productDescription" value="${form.productDescription}">
                        </div>
                        <div class="mb-3">
                           <label for="imageUrl" class="form-label">Picture of product</label>
                           <input type="text" class="form-control" id="imageUrl" name="imageUrl" value="${form.imageUrl}">
                         </div>

                          <div class="mb-3">
                                <label for="price" class="form-label">Price of product</label>
                               <input type="number" class="form-control" id="price" name="price" value="${form.price}">
                           </div>


                       <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>