<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>


<section>
    <div class="bg-light2 pt-5 pb-5">
        <div class="row">
            <div class="col-12 text-center">
                <h1 class="m-0">Add to cart</h1>
            </div>
        </div>
    </div>
</section>


<section>
    <table>
        <div class="card" style="width: 18rem;">

                <a href="/cart/additem?id=${product.id}" class="btn btn-primary">Add to cart</a>
            </div>
        </div>

    </table>
</section>




<jsp:include page="../include/footer.jsp"/>