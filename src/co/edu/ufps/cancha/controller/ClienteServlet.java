package co.edu.ufps.cancha.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.cancha.dao.CargoDAO;
import co.edu.ufps.cancha.dao.ClienteDAO;
import co.edu.ufps.cancha.dao.UsuarioDAO;
import co.edu.ufps.cancha.entities.Cargo;
import co.edu.ufps.cancha.entities.Cliente;
import co.edu.ufps.cancha.entities.Usuario;

/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClienteDAO clienteDao;

	public ClienteServlet() {
		super();
	}

	public void init() {

		clienteDao = new ClienteDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		System.out.println(action);

		try {
			switch (action) {
			case "new":
				showNewForm(request, response);
				break;

			case "register":
				insert(request, response);
				break;

			case "delete":
				delete(request, response);
				break;

			case "showedit":
				showEditForm(request, response);
				break;

			case "editar":
				update(request, response);
				break;
		    
			case "login":
				login(request, response);
				break;

			default:
				list(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("registro.jsp");
		dispatcher.forward(request, response);
	}

	private void insert(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ParseException, ServletException {
		RequestDispatcher dispatcher = null;
		UsuarioDAO uDao = new UsuarioDAO();
		CargoDAO cDao = new CargoDAO();
		
		Cargo cg = cDao.find(4);
		
		Usuario us = new Usuario(Integer.parseInt(request.getParameter("id")), request.getParameter("usuario"), request.getParameter("pass"), cg);

		Cliente cliente = new Cliente(Integer.parseInt(request.getParameter("id")), request.getParameter("nombre"), request.getParameter("apellido"),
				request.getParameter("correo"), 0, request.getParameter("telefono"), null);

		if (clienteDao.find(cliente.getIdCliente())==null) {
			uDao.insert(us);
			cliente.setUsuario(us);
			clienteDao.insert(cliente);

			dispatcher = request.getRequestDispatcher("loginCliente.jsp");
		}else {
			dispatcher = request.getRequestDispatcher("registroCliente.jsp");
			request.setAttribute("error", "El cliente ya existe");
		}

		dispatcher.forward(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Cliente> list = clienteDao.list();
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listaClientes.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Cliente cliente = clienteDao.find(id);

		RequestDispatcher dispatcher = request.getRequestDispatcher("editarCliente.jsp");
		request.setAttribute("cliente", cliente);
		dispatcher.forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ParseException, ServletException {
		RequestDispatcher dispatcher = null;
		Integer id = Integer.parseInt(request.getParameter("id"));

		Cliente cliente = clienteDao.find(id);

		if (cliente != null) {

			cliente.setNombre(request.getParameter("nombre"));
			cliente.setApellido(request.getParameter("apellido"));
			cliente.setCorreo(request.getParameter("correo"));
			cliente.setNroReservas(Integer.parseInt(request.getParameter("nro_reservas")));
			cliente.setTelefono(request.getParameter("telefono"));
		
			clienteDao.update(cliente);
			dispatcher = request.getRequestDispatcher("listaClientes.jsp");
		} else {
			dispatcher = request.getRequestDispatcher("listaClientes.jsp");
		}
		dispatcher.forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Cliente cliente = clienteDao.find(id);
		Usuario usuario = cliente.getUsuario();
		UsuarioDAO uDao = new UsuarioDAO();
		clienteDao.delete(cliente);
		uDao.delete(usuario);
		

		RequestDispatcher dispatcher = request.getRequestDispatcher("listaClientes.jsp");
		dispatcher.forward(request, response);
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Cliente> list = clienteDao.list();

		RequestDispatcher dispatcher = null;
		String nombre = request.getParameter("nombre");
		String pass = request.getParameter("pass");
		boolean existe = false;
		for (Cliente c : list) {
			if (c.getUsuario().getNombre().equals(nombre) && c.getUsuario().getClaveUsuario().equals(pass)) {
				existe = true;
			}
		}

		if (existe) {
			dispatcher = request.getRequestDispatcher("indexCliente.jsp");
		} else {
			dispatcher = request.getRequestDispatcher("loginCliente.jsp");
			String mensaje = "No est� registrado";
			request.setAttribute("mensaje", mensaje);
		}
		dispatcher.forward(request, response);
	}

}
