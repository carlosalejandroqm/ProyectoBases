package co.edu.ufps.cancha.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.cancha.dao.CajeroDAO;
import co.edu.ufps.cancha.dao.CargoDAO;
import co.edu.ufps.cancha.dao.EmpleadoDAO;
import co.edu.ufps.cancha.dao.UsuarioDAO;
import co.edu.ufps.cancha.entities.Administrador;
import co.edu.ufps.cancha.entities.Cajero;
import co.edu.ufps.cancha.entities.Cargo;
import co.edu.ufps.cancha.entities.Empleado;
import co.edu.ufps.cancha.entities.Usuario;

/**
 * Servlet implementation class CajeroServlet
 */
@WebServlet("/CajeroServlet")
public class CajeroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CajeroDAO cajeroDao = new CajeroDAO();
	private EmpleadoDAO eDao = new EmpleadoDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CajeroServlet() {
        super();
        // TODO Auto-generated constructor stub
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

		Cargo cg = cDao.find(2);
		Usuario us = new Usuario(null, request.getParameter("usuario"), request.getParameter("pass"), cg);
		
		Empleado em =new Empleado(null, request.getParameter("dni"), request.getParameter("nombre"), request.getParameter("apellido"),
				request.getParameter("correo"), Integer.parseInt(request.getParameter("horas")), Integer.parseInt(request.getParameter("telefono")), null, null,
				cg, us);
		
		if (!uDao.existeUsuario(us.getNombre())) {
			uDao.insert(us);
			eDao.insert(em);
			
			Empleado e = eDao.encontrarEmpleado(em);
			
			Cajero cajero = new Cajero(e.getIdEmpleado());
			
			eDao.update(e);
			cajeroDao.insert(cajero);
			dispatcher = request.getRequestDispatcher("mostrar.jsp");
		}else {
			dispatcher = request.getRequestDispatcher("mostrar.jsp");
			request.setAttribute("error", "El cajero ya existe");
		}

		dispatcher.forward(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Cajero> list = cajeroDao.list();
		List<Empleado> listEm = new ArrayList<>();
		for(Cajero c: list) {
		   listEm.add(eDao.find(c.getIdEmpleado()));
		}
		request.setAttribute("list", listEm);
		RequestDispatcher dispatcher = request.getRequestDispatcher("mostrar.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Cajero cajero = cajeroDao.find(id);

		RequestDispatcher dispatcher = request.getRequestDispatcher("editar.jsp");
		request.setAttribute("cajero", cajero);
		dispatcher.forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ParseException, ServletException {
		RequestDispatcher dispatcher = null;
		Integer id = Integer.parseInt(request.getParameter("id"));

		Cajero cajero = cajeroDao.find(id);
		
		if (cajero != null) {
			Empleado e= eDao.find(cajero.getIdEmpleado());
			e.setDni(request.getParameter("dni"));
			e.setNombre(request.getParameter("nombre"));
			e.setApellido(request.getParameter("apellido"));
			e.setCorreo(request.getParameter("correo"));
			e.setHorasExtra(Integer.parseInt(request.getParameter("horas")));
			e.setTelefono(Integer.parseInt(request.getParameter("telefono")));
			e.setCargoBean(e.getCargoBean());
			e.setUsuario(e.getUsuario());
			
			dispatcher = request.getRequestDispatcher("mostrar.jsp");
		} else {
			dispatcher = request.getRequestDispatcher("mostrar.jsp");
			request.setAttribute("error", "El cajero no existe");
		}
		dispatcher.forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Cajero cajero = cajeroDao.find(id);
		Empleado empleado = eDao.find(cajero.getIdEmpleado());

		eDao.delete(empleado);

		cajeroDao.delete(cajero);

		RequestDispatcher dispatcher = request.getRequestDispatcher("EmpleadoServlet?action=mostrar");
		dispatcher.forward(request, response);
	}

}
