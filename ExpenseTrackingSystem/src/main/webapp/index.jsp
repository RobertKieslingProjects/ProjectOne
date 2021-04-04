<!DOCTYPE html>
<html>
    <head>
        <!-- required meta tags-->
        <meta charser="utf-8">
        <meta name="viewport" content="width=device-width, inititial-scale=1">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    
        <title>Input Expense</title>
    </head>
    <body class="p-3 mb-2 bg-secondary text-blue">
      <h3>Expense Tracking Login</h3>
        <form action="Login" method="POST">
          <div class="d-grid gap-3 p-2 border border-dark bg-primary text-gray">
            <div class="form-group col-5 mx-auto">
              <input placeholder="User ID"
                     class="form-control" name="userid" id="userid">
            </div>
            
            <div class="form-group col-5 mx-auto">
              <input placeholder="Password"
                     type="password" size="40"
                     class="form-control" name="password" id="password">
            </div>

          </div>
	  <input type="hidden" name="dbinit">
          <br>
          <div class="border border-dark bg-primary row align-items-center">
            <div class="col-1 mx-auto p-3">
              <button type="submit">Login</button>
            </div>
          </div>
        </form>
       
        
        <!-- Bootstrap bundle with popper-->
        <!-- To import individual components, see https://getbootstrap.com/docs/4.0/getting-started/introduction/ -->
         <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
        
    </body>
</html>
