<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="Author" content="King of Seeven Kingdoms">
    <meta name="description" content="login para usuarios y administradores">
    <title>Index para los clientes de las canchas sinteticascanchas sinteticas</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
        integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/estilosLogin.css">
    <link rel="stylesheet" type="text/css" href="css/estilosLogin.css">
    <link rel="stylesheet" type="text/css" href="css/estilosLogin.css">
    <link rel="stylesheet" href="css/card.css">

    <!-- fuentes -->
    <link href="https://fonts.googleapis.com/css2?family=Kaushan+Script&display=swap" rel="stylesheet" media="">
</head>

<body>
    <header>
        <h1>
            <center>D.A.S Canchas </center>
        </h1>
        <p>
            <center>Un sistema que gestiona toda la informacion de tu cancha sintetica forma gratuita y libre</center>
        </p>
    </header>
    <!-- barra de navegacion -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light navbar-toggleable-sm sticky-top">
        <a class="navbar-brand" href="#">
        </a>
        <p>Cliente</p>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav mr-0 ml-auto mt-2 mt-lg-0 text-center">
                <a class="nav-link " href="html/marca.html">Reserva</a>
                <a class="nav-link " href="html/categoria.html">Productos</a>
                <a class="nav-link" href="php/producto.php">Acerca de </a>
                <a class="nav-link" href="../ORM/loginCliente.jsp">Salir </a>
            </div>
        </div>
    </nav>
    <center>
        <div class="row">
            <!-- Reservas -->
            <div class="col-xs-6 col-sm-6 col-md-4">
                <div class="image-flip">
                    <div class="mainflip flip-0">
                        <div class="frontside">
                            <div class="card">
                                <div class="card-body text-center">
                                   
                                    <h4 class="card-title">Reservas</h4>
                                    <p class="card-text"></p>
                                    <a href="https://www.fiverr.com/share/qb8D02" class="btn btn-primary btn-sm"><i
                                            class="fa fa-plus"></i></a>
                                </div>
                            </div>
                        </div>
                        <div class="backside">
                            <div class="card">
                                <div class="card-body text-center mt-4">
                                    <h4 class="card-title">
                                        Para realizar, actualizar o eliminar tus reservas
                                    </h4>
                                    <a href="reservas/listarReserva.jsp"><button type="button" class="btn btn-primary">
                                        Ir a reservas
                                    </button></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ./Team member -->
            <!-- Productos-->
            <div class="col-xs-6 col-sm-6 col-md-4">
                <div class="image-flip">
                    <div class="mainflip flip-0">
                        <div class="frontside">
                            <div class="card">
                                <div class="card-body text-center">
                                   
                                    <h4 class="card-title">Productos</h4>
                                    <p class="card-text"></p>
                                    <a href="https://www.fiverr.com/share/qb8D02" class="btn btn-primary btn-sm"><i
                                            class="fa fa-plus"></i></a>
                                </div>
                            </div>
                        </div>
                        <div class="backside">
                            <div class="card">
                                <div class="card-body text-center mt-4">
                                    <h4 class="card-title">
                                        Para realizar la compra y ver existencia de productos 
                                    </h4>
                                    <a href="productos/listarProdUsuario.jsp"><button type="button" class="btn btn-primary">Ir a productos</button></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ./productos  -->
            <!-- Eventos  -->
            <div class="col-xs-6 col-sm-6 col-md-4">
                <div class="image-flip">
                    <div class="mainflip flip-0">
                        <div class="frontside">
                            <div class="card">
                                <div class="card-body text-center">
                                    
                                    <h4 class="card-title">Eventos</h4>
                                    <p class="card-text"></p>
                                    <a href="https://www.fiverr.com/share/qb8D02" class="btn btn-primary btn-sm"><i
                                            class="fa fa-plus"></i></a>
                                </div>
                            </div>
                        </div>
                        <div class="backside">
                            <div class="card">
                                <div class="card-body text-center mt-4">
                                    <h4 class="card-title">
                                        Para ver los eventos que hay en La Catedral del futbol 
                                    </h4>
                                    <a href="#"><button type="button" class="btn btn-primary">Ir al
                                            Ir a eventos</button></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ./Team member -->
        </div>
    </center>

    <footer class="mainfooter" role="contentinfo">

        <div class="footer-middle">
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-sm-6">
                        <!--Column1-->
                        <div class="footer-pad">
                            <h4 class="text-center"> <strong>Developers</strong></h4>
                            <ul class="list-unstyled">
                                <li>
                                    <a href="#"></a>
                                </li>
                                <li class="text-center">
                                    <Strong>Email</Strong>
                                </li>
                                <li class="text-center">dubanyesids@ufps.edu.co</li>
                                <li class="text-center">juansebastiansp@ufps.edu.co</li>
                                <li class="text-center">josegabrieljr@ufps.edu.co</li>


                            </ul>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6">
                        <!--Column1-->
                        <div class="footer-pad">
                            <h4 class="text-center">
                                <Strong>¿Que Somos?</Strong>
                            </h4>
                            <ul class="list-unstyled">
                                <li class="text-center">
                                    <p>Un bar de calidad y relajante, ubicado en la ciudad de cucuta en el barrio
                                        caobos, donde la decoracion permite sentir o experimentar a nuestros clientes
                                        que se encuentran en londres.

                                    </p>
                                </li>

                            </ul>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6">
                        <!--Column1-->
                        <div class="footer-pad">
                            <h4 class="text-center">
                                <Strong> Enlaces de Interes</Strong>
                            </h4>
                            <ul class="list-unstyled">
                                <li class="text-center"><a href="contactenos.html">Ayuda</a></li>
                                <li class="text-center"><a href="https://www.londres.es/historia">Historia de
                                        londres</a></li>

                            </ul>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <h4>
                            <Strong>Redes Sociales</Strong>
                        </h4>
                        <ul class="social-network social-circle">
                            <li><a href="https://www.facebook.com/London-Bridge-Pub-121066448584216/photos/?ref=page_internal"
                                    class="icoFacebook" title="Facebook"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="https://www.instagram.com/londonbridgepub/" class="icoLinkedin"
                                    title="Instagram"><i class="fa fa-instagram"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12 copy">
                        <p class="text-center">&copy; Copyright 2020 </p>
                    </div>
                </div>
            </div>
        </div>
    </footer>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
    integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
    crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
    integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
    crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
    integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
    crossorigin="anonymous"></script>

</html>
