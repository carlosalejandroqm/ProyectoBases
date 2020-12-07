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

import co.edu.ufps.cancha.dao.AdministradorDAO;
import co.edu.ufps.cancha.dao.CargoDAO;
import co.edu.ufps.cancha.dao.EmpleadoDAO;
import co.edu.ufps.cancha.dao.UsuarioDAO;
import co.edu.ufps.cancha.entities.Cargo;
import co.edu.ufps.cancha.entities.Empleado;
import co.edu.ufps.cancha.entities.Administrador;
import co.edu.ufps.cancha.entities.Usuario;

/**
 * Servlet implementation class AdministradorServlet
 */
@WebServlet("/AdministradorServlet")
public class AdministradorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AdministradorDAO adminDao;
	private EmpleadoDAO eDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministradorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init() {
		adminDao = new AdministradorDAO();
		eDao = new EmpleadoDAO();
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

		Cargo cg = cDao.find(1);
		Usuario us = new Usuario(null, request.getParameter("usuario"), request.getParameter("pass"), cg);
		
		Empleado em =new Empleado(null, request.getParameter("dni"), request.getParameter("nombre"), request.getParameter("apellido"),
				request.getParameter("correo"), Integer.parseInt(request.getParameter("horas")), Integer.parseInt(request.getParameter("telefono")), null, null,
				cg, us);
		
		if (!uDao.existeUsuario(us.getNombre())) {
			uDao.insert(us);
			eDao.insert(em);
			
			Empleado e = eDao.encontrarEmpleado(em);
			
			Administrador admin = new Administrador(e.getIdEmpleado(), e);
			e.setAdministrador(admin);
			
			eDao.update(e);
			adminDao.insert(admin);
			dispatcher = request.getRequestDispatcher("mostrar.jsp");
		}else {
			dispatcher = request.getRequestDispatcher("mostrar.jsp");
			request.setAttribute("error", "El admin ya existe");
		}

		dispatcher.forward(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Administrador> list = adminDao.list();
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("mostrar.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Administrador admin = adminDao.find(id);

		RequestDispatcher dispatcher = request.getRequestDispatcher("editar.jsp");
		request.setAttribute("admin", admin);
		dispatcher.forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ParseException, ServletException {
		RequestDispatcher dispatcher = null;
		Integer id = Integer.parseInt(request.getParameter("id"));

		Administrador admin = adminDao.find(id);
		
		if (admin != null) {
			
			Empleado e= eDao.find(admin.getIdEmpleado());
			e.setDni(request.getParameter("dni"));
			e.setNombre(request.getParameter("nombre"));
			e.setApellido(request.getParameter("apellido"));
			e.setCorreo(request.getParameter("correo"));
			e.setHorasExtra(Integer.parseInt(request.getParameter("horas")));
			e.setTelefono(Integer.parseInt(request.getParameter("telefono")));
			e.setCargoBean(e.getCargoBean());
			e.setUsuario(e.getUsuario());
			
			admin.setEmpleado(e);
			adminDao.update(admin);
			eDao.update(e);
			dispatcher = request.getRequestDispatcher("mostrar.jsp");
		} else {
			dispatcher = request.getRequestDispatcher("mostrar.jsp");
			request.setAttribute("error", "El admin no existe");
		}
		dispatcher.forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Administrador admin = adminDao.find(id);
		Empleado empleado = admin.getEmpleado();

		eDao.delete(empleado);

		adminDao.delete(admin);

		RequestDispatcher dispatcher = request.getRequestDispatcher("EmpleadoServlet?action=mostrar");
		dispatcher.forward(request, response);
	}

}
