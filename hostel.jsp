<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hostel Management</title>
    <link rel="stylesheet" href="hostel.css">
    <link
          rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
          crossorigin="anonymous"
        />
        <script
          src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
          integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
          crossorigin="anonymous"
        ></script>
        <script
          src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
          integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
          crossorigin="anonymous"
        ></script>
        <script
          src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
          integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
          crossorigin="anonymous"
        ></script>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">
            <img src="https://img.collegepravesh.com/2022/05/SVCE-Sriperumbudur-Logo.png" class="logo" alt="SVCE logo"/>
        </a>
        <div class="collapse navbar-collapse">
            <div class="navbar-nav ml-auto">
                <a class="nav-link active" href="hostel.html">Home</a>
             <a class="nav-link" href="#">
              
                <p type="button"  data-toggle="modal" data-target="#exampleModal">
                  About Us
                </p>
        
                <!-- Modal -->
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                  <div class="modal-dialog">
                    <div class="modal-content">
                      <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">About Us</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                          <span aria-hidden="true">&times;</span>
                        </button>
                      </div>
                      <div class="modal-body">
                        <h3 style="font-family: 'Roboto';"> Hostel Website is created by</h3>
                        <ol style="font-family:'playfair display';font-weight:bold;">
                          <li>Prakash M</li>
                          <li>Lakshmi Narayanan K</li>
                          <li>Raghavendhar R</li>
                        </ol>
                      </div>
                      <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                      </div>
                    </div>
                  </div>
                </div>
             
              </a>
                <a class="nav-link" href="StudentForm.jsp">Student</a> <!-- Servlet link -->
                <a class="nav-link" href="adminLogin.html">Admin</a> <!-- Servlet link -->
             	
            </div>
        </div>
    </nav>
    <h1 class="text-primary text-center">Welcome to Hostel Registration System</h1> 
   <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
    
        <ol class="carousel-indicators">
            
          <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            
        
        </ol>
        
        <div class="carousel-inner size">
            
          <div class="carousel-item active">
            <img src="https://www.svce.ac.in/wp-content/uploads/2022/01/hostel-svce.jpg" class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
            <img src="https://www.svce.ac.in/wp-content/uploads/2022/01/svce-hostel-1.jpg" class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
            <img src="https://www.svce.ac.in/wp-content/uploads/2022/01/svce-hostel-b2.jpg" class="d-block w-100" alt="...">
          </div>
        </div>
        <button class="carousel-control-prev" type="button" data-target="#carouselExampleIndicators" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </button>
        <button class="carousel-control-next" type="button" data-target="#carouselExampleIndicators" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </button>
    </div>
</body>
</html>
