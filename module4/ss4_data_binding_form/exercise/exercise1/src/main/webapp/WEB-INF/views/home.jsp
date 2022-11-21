<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<style>
    .divider:after,
    .divider:before {
        content: "";
        flex: 1;
        height: 1px;
        background: #eee;
    }

    .h-custom {
        height: calc(100% - 73px);
    }

    @media (max-width: 450px) {
        .h-custom {
            height: 100%;
        }
    }
</style>
<body>
<h3>Home</h3>
<section class="vh-100">
    <div class="container-fluid h-custom">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-md-9 col-lg-6 col-xl-5">
                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
                     class="img-fluid" alt="Sample image">
            </div>
            <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                <form:form action="login" method="post" modelAttribute="login">

                    <!-- Email input -->
                    <div class="form-outline mb-4">
                        <form:input type="email" path="account" class="form-control form-control-lg"
                               placeholder="Enter a valid email address"/>
                        <form:label class="form-label" path="account">Account</form:label>
                    </div>

                    <!-- Password input -->
                    <div class="form-outline mb-3">
                        <form:input type="password" path="password" class="form-control form-control-lg"
                               placeholder="Enter password"/>
                        <form:label class="form-label" path="password">Password</form:label>
                    </div>

                    <div class="text-center text-lg-start mt-4 pt-2">
                        <form:button type="button" class="btn btn-primary btn-lg"
                                style="padding-left: 2.5rem; padding-right: 2.5rem;">Login
                        </form:button>
                    </div>

                </form:form>
            </div>
        </div>
    </div>
</section>
</body>
</html>