<!DOCTYPE html>
<html>

<head>
    <title>Login</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-image: url('https://www.aihr.com/wp-content/uploads/employee-data-collection-cover.png');
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
            height: 100vh; /* Set the body to full viewport height */
        }

        .container {
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .login-card {
            width: 350px; /* Adjust the width to make it larger */
            padding: 20px;
            background-color: rgba(0, 0, 0, 0.7); /* Semi-transparent black background */
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3); /* Drop shadow */
        }

        .login-card .card-header {
            background-color: #007bff; /* Blue header background */
            color: white;
            text-align: center;
            padding: 10px;
            border-radius: 10px 10px 0 0;
        }

        .login-card .card-body .form-group {
            margin-bottom: 20px;
        }
    </style>
</head>

<body>
    <div class="container">
        <div class="login-card card">
            <div class="card-header">
                Login
            </div>
            <div class="card-body">
                <form action="loginprocces" method="post">
                    <div class="form-group">
                        <input type="text" name="email" class="form-control" placeholder="Enter Username">
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control" placeholder="Enter Password">
                    </div>
                    <div class="form-group text-center">
                        <input type="submit" value="Login" class="btn btn-primary" />
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>

</html>
