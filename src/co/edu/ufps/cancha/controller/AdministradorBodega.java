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
import co.edu.ufps.cancha.dao.EmpleadoDAO;
import co.edu.ufps.cancha.entities.Administrador;
import co.edu.ufps.cancha.entities.Empleado;

/**
 * Servlet implementation class AdministradorBodega
 */
@WebServlet("/AdministradorBodega")
public class AdministradorBodega extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdministradorBodega admBodegaDAO;
	private EmpleadoDAO empDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdministradorBodega() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		admBodegaDAO = new AdministradorBodega();
		empDAO = new EmpleadoDAO();
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

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("registroAdmBodega.jsp");
		dispatcher.forward(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<AdministradorBodega> list = admBodegaDAO.list();
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listarAdministraadorBodega.jsp");
		dispatcher.forward(request, response);
	}


	private void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		AdministradorBodega admin = admBodegaDAO.find(id);

		RequestDispatcher dispatcher = request.getRequestDispatcher("editar.jsp");
		request.setAttribute("admin", admin);
		dispatcher.forward(request, response);
	}

	private AdministradorBodega find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		AdministradorBodega admin = admBodegaDAO.find(id);
		Empleado empleado = admin.getEmpleado();

		empDAO.delete(empleado);

		admBodegaDAO.delete(admin);

		RequestDispatcher dispatcher = request.getRequestDispatcher("EmpleadoServlet?action=mostrar");
		dispatcher.forward(request, response);
	}
	private void insert(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

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

}

