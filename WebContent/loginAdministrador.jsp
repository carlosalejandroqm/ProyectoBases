<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="Author" content="King of Seeven Kingdoms">
    <meta name="description" content="login para usuarios y administradores">
    <title>Login para los Administradors de las canchas sinteticascanchas sinteticas</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
        integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/estilosLogin.css">

    <!-- fuentes -->
    <link href="https://fonts.googleapis.com/css2?family=Kaushan+Script&display=swap" rel="stylesheet" media="">
</head>

<body>
    <header>
        <h1>
            <center>D.A.S Canchas </center>
        </h1>
        <p>
            <center>Un sistema que gestiona toda la informacion de tu cancha sintetica de forma gratuita y libre</center>
        </p>
    </header>
    <div class="container">
        <div class="row">
            <div class="col-md-9 col-lg-8 mx-auto">
                <h3 class="login-heading mb-4">Portal Administrador</h3>
                <form action="${pageContext.request.contextPath}/AdministradorServlet?action=login"
					method="post">
                    <div class="form-label-group">
                        <input type="text" id="inputEmail"  name="nombre" class="form-control" placeholder="Digite correo o usuario"
                            required autofocus>
                        <label for="inputEmail">Nombre Administrador</label>
                    </div>
                    <div class="form-label-group">
                        <input type="password" id="inputPassword"  name="pass" class="form-control"
                            placeholder="Digite su Contraseña" required>
                        <label for="inputPassword">Contraseña Administrador</label>
                    </div>

                    <div class="custom-control custom-checkbox mb-3">
                        <input type="checkbox" class="custom-control-input" id="customCheck1">
                        <label class="custom-control-label" for="customCheck1">Recordar Contraseña</label>
                    </div>
                    <a href="indexAdministrador.jsp">
                    <button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2"
                        type="submit">Ingresar</button>
                     </a>   
                </form>
            </div>
        </div>
    </div>
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
                                <li class="text-center">carlosalejandroqm@ufps.edu.co</li>


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
                                    <p>
                                        Un sistema de informacion rubusto para tu negocio de canchas sinteticas
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
                                <li class="text-center"><a href="">Historia de Canchas la catedral</a></li>

                            </ul>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <h4>
                            <Strong>Redes Sociales</Strong>
                        </h4>
                        <ul class="social-network social-circle">
                            <li><a href="https://www.facebook.com/London-Bridge-Pub-121066448584216/photos/?ref=page_internal" class="icoFacebook" title="Facebook"><i class="fa fa-facebook"></i></a></li>

                            </li>
                        </ul>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12 copy">
                        <p class="text-center">
                            Licencia Creative Commons. Desarrollado por Kings of Seven Kingdoms 2020.
                        </p>
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
