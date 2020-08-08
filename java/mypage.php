<?php
require_once 'connect.php';
if (!isset($_SESSION['uname'])) {
    header("Location: index.php");
    exit();
}
$id = "##";
$boo=false;
$book='<button type="button" class="btn btn-blue waves-effect" data-toggle="modal" data-target="#book">BOOK NOW';
$query = "select PatientID from online natural join Patient where email=:email";
$stm = $pdo->prepare($query);

$stm->execute(array(
    ':email' => $_SESSION['uname']
));
$res = $stm->fetch(PDO::FETCH_ASSOC);
if($res!=false){
    $id=$res['PatientID'];
    $_SESSION['pid']=$id;
    $q1="select * from current where pid=:pid";
    $stm2=$pdo->prepare($q1);
    $stm2->execute(array(
        ':pid'=>$id
    ));
    echo "hello";
    if($stm2->fetch(PDO::FETCH_ASSOC)){
        $book='<button type="button" class="btn btn-blue disabled waves-effect" data-toggle="modal" data-target="#book">BOOKED';
        $boo=true;
    }
}
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

        .active {
            color: black;
            font-weight: bold;
        }

        .img {
            width: 100%;
            height: 100vh;
        }
        .navbar{
            justify-content: space-between;
        }
    </style>
</head>

<body class="pt-5">

    <div class="modal fade" data-backdrop="false" id="details" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-xl" role="document">
            <div class="modal-content">
                <div class="modal-header text-center">
                    <h3 class="modal-title w-100 font-weight-bold">PROFILE DETAILS</h3>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body mx-3">
                    <form>
                        <!-- Grid row -->
                        <div class="form-row">
                            <!-- Grid column -->
                            <div class="col-md-6">
                                <!-- Material input -->
                                <div class="md-form md-bg input-with-pre-icon">
                                    <i class="fas fa-user input-prefix"></i>
                                    <input type="text" id="name" name="name" class="form-control" value="-">
                                    <label for="name">Name</label>
                                </div>
                            </div>
                            <!-- Grid column -->

                            <!-- Grid column -->
                            <div class="col-md-6">
                                <!-- Material input -->
                                <div class="md-form md-bg input-with-pre-icon">
                                    <i class="fas fa-user input-prefix"></i>
                                    <input type="text" id="fname" name="fname" class="form-control" value="-">
                                    <label for="fname">Fathers Name </label>
                                </div>
                            </div>
                            <!-- Grid column -->
                        </div>
                        <!-- Grid row -->
                        <!-- Grid row -->
                        <div class="row">
                            <!-- Grid column -->
                            <div class="col-md-6">
                                <!-- Material input -->
                                <div class="md-form md-bg input-with-pre-icon">
                                    <i class="fas fa-envelope input-prefix"></i>
                                    <input type="text" id="email" name="email" value="-" class="form-control">
                                    <label for="email">Email</label>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <!-- Material input -->
                                <div class="md-form md-bg input-with-pre-icon">
                                    <i class="fas fa-id-card input-prefix"></i>
                                    <input type="text" id="number" name="number" value="-" class="form-control">
                                    <label for="number">Contact Number</label>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3">
                                <div class="md-form md-bg input-with-pre-icon">
                                    <i class="fas fa-baby-carriage input-prefix"></i>
                                    <input type="number" id="age" name="age" value="0" class="form-control">
                                    <label for="age">Age</label>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="md-form md-bg input-with-pre-icon">
                                    <i class="fas fa-text-height input-prefix"></i>
                                    <input type="number" id="height" name="height" value="0" class="form-control">
                                    <label for="height">Height</label>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="md-form md-bg input-with-pre-icon">
                                    <i class="fas fa-weight-hanging input-prefix"></i>
                                    <input type="number" id="weight" name="weight" value="0" class="form-control">
                                    <label for="weight">Weight</label>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="md-form md-bg input-with-pre-icon">
                                    <i class="fas fa-tint input-prefix"></i>
                                    <input type="text" id="blood" name="blood" value="-" class="form-control">
                                    <label for="blood">Blood Group</label>
                                </div>
                            </div>

                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <!-- Material input -->
                                <div class="md-form md-bg input-with-pre-icon">
                                    <i class="fas fa-home input-prefix"></i>
                                    <textarea id="address" class="form-control md-textarea" name="address" length="120" rows="3">--</textarea>
                                    <label for="address">Address</label>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <select class="mdb-select md-form text-center btn btn-light shadow-none dropdown-primary" id="select">
                                    <option value="" disabled selected>   Gender   </option>
                                    <option value="1">Male</option>
                                    <option value="2">Female</option>
                                    <option value="3">Other</option>
                                </select>
                                <div class="custom-control custom-checkbox md-light m-1 rounded-corner bg-light text-center">
                                    <input type="checkbox" class="custom-control-input" id="new">
                                    <label class="custom-control-label" for="new">Are you New?</label>
                                </div>

                            </div>
                        </div>

                        <!-- Grid row -->
                    </form>
                    <div class="modal-footer d-flex justify-content-center">
                        <button class="btn btn-unique" id="save">Save<i class="fas fa-paper-plane-o ml-1"></i></button>
                    </div>
                </div>
            </div>
        </div>
    </div>




    <!-- Central Modal Small -->
    <div class="modal fade" id="book" tabindex="-1" role="dialog" data-backdrop="false" aria-labelledby="book" aria-hidden="true">

        <!-- Change class .modal-sm to change the size of the modal -->
        <div class="modal-dialog modal-dialog-centered modal-sm" role="document">


            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title text-center w-100" id="book">Choose Doctor</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <?php  ?>
                    <select class="mdb-select text-center btn dropdown-primary w-100" id="docselect">
                        <option value="" disabled selected>Doctor</option>
                        <?php   
                        $q2="select Did,name from doctor where Type='doctor'";
                        $st=$pdo->prepare($q2);
                        $st->execute();
                        while($row=$st->fetch(PDO::FETCH_ASSOC)){
                            echo '<option class="text-center" value='.$row['Did'].'">'.$row['name'].'</option>';
                        }
                        ?>
                    </select>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary btn-sm" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary btn-sm" id="docbook">BOOK</button>
                </div>
            </div>
        </div>
    </div>
    <!-- Central Modal Small -->




    <div class="modal fade" id="notice" tabindex="-1" role="dialog" aria-labelledby="notice" aria-hidden="true">

        <!-- Change class .modal-sm to change the size of the modal -->
        <div class="modal-dialog modal-sm" role="document">


            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title w-100 text-center" id="myModalLabel">NOTICE</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body text-center">
                    If You are Already registered in hospital please use registered email id or create new account by completing profile
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary btn-sm" data-dismiss="modal">OKAY</button>
                </div>
            </div>
        </div>
    </div>
    <!-- Central Modal Small -->









    <nav class="navbar navbar-expand-lg fixed-top navbar-dark indigo">
        <a class="navbar-brand" style="font-weight: bold;" href="index.php">R4 HOSPITAL</a>
        
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <span class="navbar-text float-md-right float">
        <a href="logout.php" class="btn btn-default btn-sm btn-rounded d-right">LOG OUT</a>
        </span>
    </nav>


    <!-- Jumbotron -->
    <div class="jumbotron text-center mt-5">

        <!-- Title -->
        <h2 class="card-title h2">R4 HOSPITAL - Online Booking</h2>
        <!-- Subtitle -->
        <p class="blue-text my-4 font-weight-bold">Where Patients Feel like Home</p>
        <p class="blue-text my-4 font-weight-bold">My ID:-<span id="idDisplay"><?php echo $id ?></span></p>
        <div class="text-center">
                <?php if($boo && isset($_SESSION['token'])){echo '<button class="btn blue-gradient font-weight-bold">TOKEN-'.$_SESSION['token'].'</button>';} ?>
        </div>
        <!-- Grid row -->
        <div class="row d-flex justify-content-center">

            <!-- Grid column -->
            <div class="col-xl-7 pb-2">

                <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Fuga aliquid dolorem ea distinctio exercitationem delectus qui, quas eum architecto, amet quasi accusantium, fugit consequatur ducimus obcaecati numquam molestias hic itaque accusantium doloremque laudantium, totam rem aperiam.</p>

            </div>
            <!-- Grid column -->

        </div>
        <!-- Grid row -->

        <hr class="my-4">

        <div class="pt-2">
            <?php echo $book; ?><i class="fas fa-book-medical ml-1"></i></button>
            <button type="button" class="btn btn-outline-primary waves-effect" data-toggle="modal" data-target="#details"> VIEW PROFILE <i class="fas fa-clone ml-1"></i></button>
        </div>
    </div>
    <!-- Jumbotron -->



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
            <a href="index.php"> R4HOSPITAL</a>
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