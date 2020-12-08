<%@page import="co.edu.ufps.cancha.entities.Cliente"%>
<%@page import="co.edu.ufps.cancha.dao.ClienteDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="Author" content="King of Seeven Kingdoms">
<meta name="description" content="login para usuarios y administradores">
<title>Listado de reservas</title>

 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
        integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/estilosLogin.css">

    <link rel="stylesheet" href="css/card.css">

    <!-- fuentes -->
    <link href="https://fonts.googleapis.com/css2?family=Kaushan+Script&display=swap" rel="stylesheet" media="">

</head>

<body>
	<header>
		<h1>
			<center>D.A.S Canchas</center>
		</h1>
		<p>
		<center>Un sistema que gestiona toda la informacion de tu
			cancha sintetica forma gratuita y libre</center>
		</p>
	</header>
	<div class="container text-center mt-4">
		<h3>Listado de Clientes</h3>
	</div>
	<div class="container">

		<table class="table table-bordered table-hover">
			<br>
			<thead class="text-center">
				<tr>

					<th>Id</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Correo</th>
					<th>Telefono</th>
					<th>Usuario</th>
					<th>Editar</th>
					<th>Eliminar</th>
				</tr>
			</thead>
			<tbody>
				<!--   for (Todo todo: todos) {  -->
				<%
					for (Cliente c : new ClienteDAO().list()) {
				%>
				<tr>
					<td><%=c.getIdCliente()%></td>
					<td><%=c.getNombre()%></td>
					<td><%=c.getApellido()%></td>
					<td><%=c.getCorreo()%></td>
					<td><%=c.getTelefono()%></td>
					<td><%=c.getUsuario().getNombre()%></td>
					<td><a
						href="<%=request.getContextPath()%>/ClienteServlet?action=showedit&id=<%=c.getIdCliente()%>">Editar</a></td>&nbsp;&nbsp;&nbsp;&nbsp;
					<td>	<a href="ClienteServlet?action=delete&id=<%=c.getIdCliente()%>">Eliminar</a></td>
					<!-- } -->
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<div style="margin-bottom: 15px;">
			<a href="loginCliente.jsp"><button type="submit"
					class="btn btn-success" id="listado">Ingresar</button></a>
					<a href="registroCliente.jsp"><button type="submit"
					class="btn btn-success" id="listado">Registrar</button></a>
		</div>
	</div>
	<!--Modal-->
	<div class="modal fade" id="exampleModal" data-backdrop="static"
		tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Editar Producto</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">

					<form action="" method="POST">
						<div class="form-group row">
							<label for="inputNombre" class="col-sm-2 col-form-label">Correo</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="correo"
									id="inputNombre">
							</div>
						</div>
						<div class="form-group row">
							<label for="inputDescripcion" class="col-sm-2 col-form-label">Telefono</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="telefono"
									id="inputDescripcion">
							</div>
						</div>
						<div class="form-group row">
							<label for="inputEmail3" class="col-sm-2 col-form-label">Usuario</label>
							<div class="col-sm-10">
								<input type="number" class="form-control" name="usuario"
									id="inputPrecio">
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Cerrar</button>
							<button type="submit" id="guardar" class="btn btn-primary">Guardar
								cambios</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="exampleModal2" tabindex="-1"
		data-backdrop="static" aria-labelledby="exampleModalLabel"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Eliminar</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="eliminarProducto.php" method="POST">
						Â¿Desea eliminar este producto?
						<p id="espacio2"></p>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Cerrar</button>
							<button type="submit" class="btn btn-primary">Eliminar</button>
						</div>
					</form>
				</div>
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
							<h4 class="text-center">
								<strong>Developers</strong>
							</h4>
							<ul class="list-unstyled">
								<li><a href="#"></a></li>
								<li class="text-center"><Strong>Email</Strong></li>
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
									<p>Un sistema de informacion rubusto para tu negocio de
										canchas sinteticas</p>
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
								<li class="text-center"><a href="">Historia de Canchas
										la catedral</a></li>

							</ul>
						</div>
					</div>
					<div class="col-md-3">
						<h4>
							<Strong>Redes Sociales</Strong>
						</h4>
						<ul class="social-network social-circle">
							<li><a
								href="https://www.facebook.com/London-Bridge-Pub-121066448584216/photos/?ref=page_internal"
								class="icoFacebook" title="Facebook"><i
									class="fa fa-facebook"></i></a></li>

							</li>
						</ul>
					</div>
				</div>

				<div class="row">
					<div class="col-md-12 copy">
						<p class="text-center">Licencia Creative Commons. Desarrollado
							por Kings of Seven Kingdoms 2020.</p>
					</div>
				</div>
			</div>
		</div>
	</footer>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	crossorigin="anonymous"></script>

</html>
