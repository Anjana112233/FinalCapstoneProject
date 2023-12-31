<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>

       <link href="/pub/css/global-style.css" rel="stylesheet">

       <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
             crossorigin="anonymous">

       <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
               crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light custom-navbar">
    <div class="container-fluid">
        <a class="navbar-brand" href="/product/search">Himalayan Traditional Store</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>

        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                 <li class="nav-item">
                      <a class="nav-link" href="/product/search">Search by product name</a>
                  </li>
                <sec:authorize access="hasAnyAuthority('ADMIN')">
                 <li class="nav-item">
                    <a class="nav-link" href="/product/create">Create Product</a>
                 </li>
                      </sec:authorize>
                      <sec:authorize access="!isAuthenticated()">
                       <li class="nav-item">
                               <a class="nav-link" href="/auth/register1">User Registration</a>
                        </li>
                     <li class="nav-item">
                                <a class="nav-link" href="/auth/login1">Login page</a>
                      </li>
                      </sec:authorize>
                    <sec:authorize access="hasAnyAuthority('ADMIN')">
                      <li class="nav-item">
                            <a class="nav-link" href="/admin/index">Admin</a>
                      </li>
                    </sec:authorize>
                      <sec:authorize access="isAuthenticated()">
                      <li class="nav-item">
                           <a class="nav-link" href="/cart/shopping_cart">View Cart</a>
                                   </li>
                      <li class="nav-item">
                             <a class="nav-link" href="/order/details">View Last Order</a>
                                     </li>
                     <li class="nav-item">
                             <a class="nav-link" href="/auth/logout">Logout</a>
                                     </li>
                      <li class="nav-item">
                                <a class="nav-link" href=""><sec:authentication property="principal.username" /></a>
                           </li>
                     </sec:authorize>
            </ul>
        </div>
    </div>
</nav>