<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section>
    <div class="bg-light2 pt-3 pb-3">
        <div class="row">
            <div class="col-12 text-center">
                <h1 class="m-0 text-dark">Login</h1>
            </div>
        </div>
    </div>
</section>

 <c:if test="${param['error'] eq ''}">
    <section class="pt-5">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-6">
                    <div class="alert alert-danger w-100 mb-0">Invalid Username or Password</div>
                </div>
            </div>
        </div>
    </section>
</c:if>

<section class="pt-5 pb-5 m-o" style="background-image: url('/pub/images/loginpage.jpg');  background-repeat: no-repeat; background-size: cover; font-weight: 700; color:white; min-height: 72vh; display: flex; flex-direction: column;">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-6">
                <!-- the action attribute on the form tag is the URL that the form will submit to when then user clicks the submit button -->
                <form method="post" action="/auth/loginSubmit">

                    <div class="mt-3">
                        <label for="username" class="form-label">Username</label>
                        <input type="text" class="form-control" id="username" name="username">
                    </div>

                    <div class="mt-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" class="form-control" id="password" name="password">
                    </div>

                  <button type="submit" class="btn btn-primary mt-4">Submit</button>
                    <!-- <a href="/product/search" class="btn btn-primary">Submit</a> -->
                </form>

            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>





