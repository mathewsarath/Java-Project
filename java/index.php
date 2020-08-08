<?php
require_once 'connect.php';

?>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
    <link rel="stylesheet" href="node_modules/mdbootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="node_modules/mdbootstrap/css/mdb.min.css">
    <link rel="stylesheet" href="node_modules/mdbootstrap/css/style.css">
    <style>
        .nav-link {
            color: white;
        }

        .md-tabs {
            position: relative;
            z-index: 1;
            padding: .7rem;
            margin-right: 1rem;
            margin-bottom: -20px;
            margin-left: 1rem;
            background-color: #2bbbad;
            border: 0;
            border-radius: .25rem;
            -webkit-box-shadow: 0 5px 11px 0 rgba(0, 0, 0, 0.18), 0 4px 15px 0 rgba(0, 0, 0, 0.15);
            box-shadow: 0 5px 11px 0 rgba(0, 0, 0, 0.18), 0 4px 15px 0 rgba(0, 0, 0, 0.15);
        }

        /* .active {
            color: black;
            font-weight: bold;
        } */

        .img {
            width: 100%;
            height: 100vh;
        }

        .seedoc {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            /* color: white!important; */
        }

        .seedoc:hover {
            background-color: black !important;
            color: white !important;
        }
    </style>
</head>

<body>
    <!--Modal: Login / Register Form-->
    <div class="modal fade" id="modalLRForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog cascading-modal" role="document">
            <!--Content-->
            <div class="modal-content">
                <!--Modal cascading tabs-->
                <div class="modal-c-tabs">
                    <!-- Nav tabs -->
                    <ul class="nav nav-tabs md-tabs tabs-2 light-blue darken-3" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" data-toggle="tab" href="#panel7" role="tab"><i class="fas fa-user mr-1"></i>
                                Login</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-toggle="tab" href="#panel8" role="tab"><i class="fas fa-user-plus mr-1"></i>
                                Register</a>
                        </li>
                    </ul>

                    <!-- Tab panels -->
                    <div class="tab-content">

                        <!--Panel 7-->
                        <div class="tab-pane fade in show active" id="panel7" role="tabpanel">
                            <div class="text-center text-danger invisible" id="logerror">
                                Login Error
                            </div>
                            <!--Body-->
                            <div class="modal-body mb-1">
                                <div class="md-form form-sm mb-5">
                                    <i class="fas fa-envelope prefix"></i>
                                    <input type="email" id="loginemail" class="form-control form-control-sm validate">
                                    <label data-error="wrong" data-success="right" for="modalLRInput10">Your email</label>
                                </div>

                                <div class="md-form form-sm mb-4">
                                    <i class="fas fa-lock prefix"></i>
                                    <input type="password" id="loginpassword" class="form-control form-control-sm validate">
                                    <label data-error="wrong" data-success="right" for="modalLRInput11">Your password</label>
                                </div>
                                <div class="text-center mt-2">
                                    <button class="btn btn-info" id="login">Log in <i class="fas fa-sign-in ml-1"></i></button>
                                </div>
                            </div>
                            <!--Footer-->
                            <div class="modal-footer">
                                <div class="options text-center text-md-right mt-1">
                                    <p>Not a member? <a class="blue-text">Sign Up</a></p>
                                    <p>Forgot <a href="#" class="blue-text">Password?</a></p>
                                </div>
                                <button type="button" class="btn btn-outline-info waves-effect ml-auto" data-dismiss="modal">Close</button>
                            </div>

                        </div>
                        <!--/.Panel 7-->

                        <!--Panel 8-->
                        <div class="tab-pane fade" id="panel8" role="tabpanel">
                        <div class="text-center text-danger invisible" id="regerror">
                                Register Error
                            </div>
                            <!--Body-->
                            <div class="modal-body">
                                <div class="md-form form-sm mb-5">
                                    <i class="fas fa-envelope prefix"></i>
                                    <input type="email" id="email1" class="form-control form-control-sm validate">
                                    <label data-error="wrong" data-success="right" for="email1">Your email</label>
                                </div>

                                <div class="md-form form-sm mb-5">
                                    <i class="fas fa-lock prefix"></i>
                                    <input type="password" id="pass1" class="form-control form-control-sm validate">
                                    <label data-error="wrong" data-success="right" for="pass1">Your password</label>
                                </div>

                                <div class="md-form form-sm mb-4">
                                    <i class="fas fa-lock prefix"></i>
                                    <input type="password" id="pass2" class="form-control form-control-sm validate">
                                    <label data-error="wrong" data-success="right" for="pass2">Repeat password</label>
                                </div>

                                <div class="text-center form-sm mt-2">
                                    <button class="btn btn-info" id="register">Sign up <i class="fas fa-sign-in ml-1"></i></button>
                                </div>

                            </div>
                            <!--Footer-->
                            <div class="modal-footer">
                                <div class="options text-right">
                                    <p class="pt-1">Already have an account? <a class="blue-text">Log In</a></p>
                                </div>
                                <button type="button" class="btn btn-outline-info waves-effect ml-auto" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                        <!--/.Panel 8-->
                    </div>

                </div>
            </div>
            <!--/.Content-->
        </div>
    </div>
    <!--Modal: Login / Register Form-->


    <nav class="navbar navbar-expand-lg fixed-top navbar-dark indigo">
        <a class="navbar-brand" style="font-weight: bold;" href="#">R4 HOSPITAL</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#photo">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#about" name="#about">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#contact" name="#contact">Contact</a>
                </li>
            </ul>
            <span class="navbar-text">
                <?php if (!isset($_SESSION['uname'])) { ?>
                    <a href="" class="btn btn-default btn-sm btn-rounded" data-toggle="modal" data-target="#modalLRForm">SEE DOCTOR</a>
                <?php } else { ?>
                    <a href="mypage.php" class="btn btn-default btn-sm btn-rounded">SEE DOCTOR</a>
                <?php } ?>
            </span>
        </div>
    </nav>

    <img class="img" id="photo" src="https://myhealthchampion.com/wp-content/uploads/2019/09/Blog-Featured-Image-1400x1200-copy.jpg" alt="">

    <?php if (!isset($_SESSION['uname'])) { ?>
        <a class="btn btn-outline-black btn-lg seedoc" data-toggle="modal" data-target="#modalLRForm"><i class="fas fa-clone left"></i>SEE DOCTOR</a>
    <?php } else { ?>
        <a href="mypage.php" class="btn btn-outline-black btn-lg seedoc"><i class="fas fa-clone left"></i>SEE DOCTOR</a>
    <?php } ?>
    </span>



    <div class="container-fluid" id="about" name="about">
        <!-- Jumbotron -->
        <div class="jumbotron text-center blue-grey lighten-5">

            <!-- Title -->
            <h2 class="card-title h2">A HOSPITAL MANAGEMENT SYSTEM</h2>

            <!-- Subtitle -->
            <p class="indigo-text my-4 font-weight-bold">UI/UX ONLINE BOOKING</p>

            <!-- Grid row -->
            <div class="row d-flex justify-content-center">

                <!-- Grid column -->
                <div class="col-xl-7 pb-2">

                    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Fuga aliquid dolorem ea distinctio exercitationem delectus qui, quas eum architecto, amet quasi accusantium, fugit consequatur ducimus obcaecati numquam molestias hic itaque accusantium doloremque laudantium, totam rem aperiam.</p>

                </div>
                <!-- Grid column -->

            </div>
            <!-- Grid row -->

            <hr class="my-4 pb-2">

            <button class="btn blue-gradient btn-rounded">Read More<i class="far fa-gem ml-1"></i></button>
            <button class="btn btn-indigo btn-rounded">Download <i class="fas fa-download ml-1"></i></button>

        </div>
        <!-- Jumbotron -->
    </div>
    <div class="container">
        <div class="row">
            <div class="col-4">
                <div class="card card-cascade narrower">

                    <!-- Card image -->
                    <div class="view view-cascade overlay">
                        <img class="card-img-top" src="https://cdn.pixabay.com/photo/2017/03/14/03/20/nurse-2141808__340.jpg" alt="Card image cap">
                        <a>
                            <div class="mask rgba-white-slight"></div>
                        </a>
                    </div>

                    <!-- Card content -->
                    <div class="card-body card-body-cascade">

                        <!-- Label -->
                        <h5 class="pink-text pb-2 pt-1"><i class="fas fa-stethoscope"></i> Doctor</h5>
                        <!-- Title -->
                        <h4 class="font-weight-bold card-title">Cheat day inspirations</h4>
                        <!-- Text -->
                        <p class="card-text">Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit
                            laboriosam, nisi ut aliquid ex ea commodi.</p>
                        <!-- Button -->
                        <a class="btn btn-unique">View More</a>

                    </div>

                </div>
            </div>
            <div class="col-4">
                <div class="card card-cascade narrower">

                    <!-- Card image -->
                    <div class="view view-cascade overlay">
                        <img class="card-img-top" src="https://cdn.pixabay.com/photo/2017/03/14/03/20/nurse-2141808__340.jpg" alt="Card image cap">
                        <a>
                            <div class="mask rgba-white-slight"></div>
                        </a>
                    </div>

                    <!-- Card content -->
                    <div class="card-body card-body-cascade">

                        <!-- Label -->
                        <h5 class="pink-text pb-2 pt-1"><i class="fas fa-stethoscope"></i> Doctor</h5>
                        <!-- Title -->
                        <h4 class="font-weight-bold card-title">Cheat day inspirations</h4>
                        <!-- Text -->
                        <p class="card-text">Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit
                            laboriosam, nisi ut aliquid ex ea commodi.</p>
                        <!-- Button -->
                        <a class="btn btn-unique">View More</a>
                    </div>

                </div>
            </div>
            <div class="col-4">
                <div class="card card-cascade narrower">

                    <!-- Card image -->
                    <div class="view view-cascade overlay">
                        <img class="card-img-top" src="https://cdn.pixabay.com/photo/2017/03/14/03/20/nurse-2141808__340.jpg" alt="Card image cap">
                        <a>
                            <div class="mask rgba-white-slight"></div>
                        </a>
                    </div>

                    <!-- Card content -->
                    <div class="card-body card-body-cascade">

                        <!-- Label -->
                        <h5 class="pink-text pb-2 pt-1"><i class="fas fa-stethoscope"></i> Doctor</h5>
                        <!-- Title -->
                        <h4 class="font-weight-bold card-title">Cheat day inspirations</h4>
                        <!-- Text -->
                        <p class="card-text">Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit
                            laboriosam, nisi ut aliquid ex ea commodi.</p>
                        <!-- Button -->
                        <a class="btn btn-unique">View More</a>

                    </div>

                </div>
            </div>
        </div>
    </div>


    <footer class="page-footer font-small unique-color-dark mt-5" id="contact" name="contact">

        <div style="background-color: #6351ce;">
            <div class="container">

                <!-- Grid row-->
                <div class="row py-4 d-flex align-items-center">

                    <!-- Grid column -->
                    <div class="col-md-6 col-lg-5 text-center text-md-left mb-4 mb-md-0">
                        <h6 class="mb-0">Get connected with us on social networks!</h6>
                    </div>
                    <!-- Grid column -->

                    <!-- Grid column -->
                    <div class="col-md-6 col-lg-7 text-center text-md-right">

                        <!-- Facebook -->
                        <a class="fb-ic">
                            <i class="fab fa-facebook-f white-text mr-4"> </i>
                        </a>
                        <!-- Twitter -->
                        <a class="tw-ic">
                            <i class="fab fa-twitter white-text mr-4"> </i>
                        </a>
                        <!-- Google +-->
                        <a class="gplus-ic">
                            <i class="fab fa-google-plus-g white-text mr-4"> </i>
                        </a>
                        <!--Linkedin -->
                        <a class="li-ic">
                            <i class="fab fa-linkedin-in white-text mr-4"> </i>
                        </a>
                        <!--Instagram-->
                        <a class="ins-ic">
                            <i class="fab fa-instagram white-text"> </i>
                        </a>

                    </div>
                    <!-- Grid column -->

                </div>
                <!-- Grid row-->

            </div>
        </div>

        <!-- Footer Links -->
        <div class="container text-center text-md-left mt-5">

            <!-- Grid row -->
            <div class="row mt-3">

                <!-- Grid column -->
                <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">

                    <!-- Content -->
                    <h6 class="text-uppercase font-weight-bold">R4 HOSPITAL</h6>
                    <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nulla, alias. Lorem ipsum dolor sit amet,
                        consectetur
                        adipisicing elit.</p>

                </div>
                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">

                    <!-- Links -->
                    <h6 class="text-uppercase font-weight-bold">Services and Features</h6>
                    <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                    <p>
                        <a href="#!">Contact Doctor</a>
                    </p>
                    <p>
                        <a href="#!">Easy Booking</a>
                    </p>
                    <p>
                        <a href="#!">Scheduling</a>
                    </p>
                    <p>
                        <a href="#!">Secure</a>
                    </p>

                </div>
                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">

                    <!-- Links -->
                    <h6 class="text-uppercase font-weight-bold">Useful links</h6>
                    <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                    <p>
                        <a href="#!">Your Account</a>
                    </p>
                    <p>
                        <a href="#!">Contact Doctor</a>
                    </p>
                    <p>
                        <a href="#!">Rates</a>
                    </p>
                    <p>
                        <a href="#!">Help</a>
                    </p>

                </div>
                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">

                    <!-- Links -->
                    <h6 class="text-uppercase font-weight-bold">Contact</h6>
                    <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                    <p>
                        <i class="fas fa-home mr-3"></i> TKM, KOLLAM, INDIA</p>
                    <p>
                        <i class="fas fa-envelope mr-3"></i> tkm@gmai.com</p>
                    <p>
                        <i class="fas fa-phone mr-3"></i> 0484-207879</p>
                    <p>
                        <i class="fas fa-print mr-3"></i> 0484-207879</p>

                </div>
                <!-- Grid column -->

            </div>
            <!-- Grid row -->

        </div>
        <!-- Footer Links -->

        <!-- Copyright -->
        <div class="footer-copyright text-center py-3">© 2020 Copyright:
            <a href="https://mdbootstrap.com/"> R4HOSPITAL</a>
        </div>
        <!-- Copyright -->

    </footer>





    <script type="text/javascript" src="node_modules/mdbootstrap/js/jquery.min.js"></script>
    <script type="text/javascript" src="node_modules/mdbootstrap/js/popper.min.js"></script>
    <script type="text/javascript" src="node_modules/mdbootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="node_modules/mdbootstrap/js/mdb.min.js"></script>
    <script type="text/javascript" src="index.js"></script>
</body>

</html>