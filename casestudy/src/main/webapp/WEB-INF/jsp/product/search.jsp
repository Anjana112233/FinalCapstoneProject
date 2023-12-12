<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section>
 <div class="bg-light2 pt-5 pb-5">
        <div class="row">
            <div class="col-12 text-center">
                <h1 class="m-0">Product Search</h1>
            </div>
        </div>
    </div>
</section>

<%--  if we want to add table on searchbyname then we can make similar table like below: --%>
<section class="bg-light1 pt-5 pb-5">
    <div class="container">
<h1 class="pb-1"> Product search by name</h1>
    <form action="/customer/search">
     <div class="row justify-content-center">
             <div class="col-3 col-sm-3 col-md-2 col-lg-2 text-end">
      <label for="ProductNameSearch" class="col-3 col-sm-3 col-md-2 col-lg-2 text-end">Product Name</label>
      </div>
      <div class="col-8 col-sm-9 col-md-6 col-lg-4">
               <input type="text" name="productname" placeholder="Search by product Name" value="${ProducttNameSearch}">
               </div>
        <div class="row justify-content-center pt-4">
                     <div class="col-12 text-center">
                 <input class="btn btn-primary" type="submit" value="Submit">
                  </div>
                   </div>
           </form>
           <c:if test="${not empty productsVar}">
           <h1> Products Found ${productsVar.size()}</h1>
            <table class="table">
                           <tr>
                               <td>Id</td>
                               <td>Product Name</td>
                               <td>Product Description</td>
                               <td>Image</td>
                               <td>Price</td>
                                <td>Edit</td>


                           </tr>
                           <c:forEach items="${productsVar}" var="product">
                               <tr>
                                   <td>${product.id}</td>
                                   <td>${product.productName}</td>
                                   <td>${product.productDescription}</td>
                                   <td>${product.imageUrl}</td>
                                   <td>${product.price}</td>
                                   <td><img src="${product.imageUrl}" style="max-width:100px"></td>
                                  <!-- <td><a href="/product/edit/${product.id}">Edit</a></td> -->
                               </tr>
                           </c:forEach>
                       </table>
           </c:if>
           </div>
           </section>

 <jsp:include page="../include/footer.jsp"/>