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

       <script>
            document.addEventListener('DOMContentLoaded', function () {
                    // Retrieve the stored menu item value
                 var selectedMenuItem = sessionStorage.getItem('selectedMenuItem');

                    // If a menu item is stored, apply bold style
                    if (selectedMenuItem) {
                        highlightMenuItem(document.querySelector('.navbar-nav .nav-link[href="' + selectedMenuItem + '"]'));
                    }
                });

                function highlightMenuItem(element) {
                    // Remove the 'active' class from all menu items
                    var menuItems = document.querySelectorAll('.navbar-nav .nav-item');
                    menuItems.forEach(item => {
                        item.classList.remove('active');
                        item.querySelector('.nav-link').style.fontWeight = 'normal'; // Reset font weight
                    });

                    // Add the 'active' class and set bold style to the clicked menu item
                    var parentItem = element.parentNode;
                    parentItem.classList.add('active');
                    element.style.fontWeight = 'bold'; // Set bold font weight

                    // Store the clicked menu item in sessionStorage
                    sessionStorage.setItem('selectedMenuItem', element.getAttribute('href'));
                }
       </script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light custom-navbar">
    <div class="container-fluid">
        <a class="navbar-brand" href="/product/search">Home</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>

        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                 <li class="nav-item">
                      <a class="nav-link" href="/product/search" onclick="highLightMenuItem(this)">Search by product name</a>
                  </li>
                <sec:authorize access="hasAnyAuthority('ADMIN')">
                 <li class="nav-item">
                    <a class="nav-link" href="/product/create" onclick="highLightMenuItem(this)">Create Product</a>
                 </li>
                      </sec:authorize>
                      <sec:authorize access="!isAuthenticated()">
                       <li class="nav-item">
                               <a class="nav-link" href="/auth/register1" onclick="highLightMenuItem(this)">User Registration</a>
                        </li>
                     <li class="nav-item">
                                <a class="nav-link" href="/auth/login1" onclick="highLightMenuItem(this)">Login page</a>
                      </li>
                      </sec:authorize>
                    <sec:authorize access="hasAnyAuthority('ADMIN')">
                      <li class="nav-item">
                            <a class="nav-link" href="/admin/index" onclick="highLightMenuItem(this)">Admin</a>
                      </li>
                    </sec:authorize>
                      <sec:authorize access="isAuthenticated()">
                      <li class="nav-item">
                           <a class="nav-link" href="/cart/shopping_cart" onclick="highLightMenuItem(this)">View Cart</a>
                                   </li>
                      <li class="nav-item">
                             <a class="nav-link" href="/order/details" onclick="highLightMenuItem(this)">View Last Order</a>
                                     </li>
                                     </ul>
                       <ul class="navbar-nav ms-auto">
                     <li class="nav-item">
                             <a class="nav-link" href="/auth/logout" onclick="highLightMenuItem(this)">Logout</a>
                                     </li>
                      <li class="nav-item">
                                <a class="nav-link" href=""><sec:authentication property="principal.username" /></a>
                           </li>
                     </sec:authorize>

            </ul>
        </div>
    </div>
</nav>