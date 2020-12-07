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

import co.edu.ufps.cancha.dao.BodegaDAO;
import co.edu.ufps.cancha.dao.ClienteDAO;
import co.edu.ufps.cancha.dao.ConsumibleDAO;
import co.edu.ufps.cancha.dao.ImplementoDAO;
import co.edu.ufps.cancha.dao.ProductoDAO;
import co.edu.ufps.cancha.entities.Bodega;
import co.edu.ufps.cancha.entities.Consumible;
import co.edu.ufps.cancha.entities.Implemento;
import co.edu.ufps.cancha.entities.Producto;

/**
 * Servlet implementation class ProductoServlet
 */
@WebServlet("/ProductoServlet")
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProductoDAO productoDao;
	private BodegaDAO bDao;
	private ConsumibleDAO cDao;
    private ImplementoDAO iDao;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() {

		productoDao = new ProductoDAO();
		bDao = new BodegaDAO();
		cDao = new ConsumibleDAO();
		iDao = new ImplementoDAO();
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
		
		Producto pr = new Producto(Integer.parseInt(request.getParameter("id")), request.getParameter("nombre"), request.getParameter("descripcion"), 
				Integer.parseInt(request.getParameter("cantidad")), null);
		
		if (productoDao.find(pr.getIdProducto())!=null) {
		Bodega b=null;
		if(request.getParameter("tipo").equals("Implementos")) {
			b = bDao.find(1);
			Implemento impl = new Implemento(pr.getIdProducto(), request.getParameter("estado"), pr);
			pr.setImplemento(impl);
			iDao.insert(impl);
		}else {
			b = bDao.find(2);
			Consumible cn = new Consumible(pr.getIdProducto(), null, Integer.parseInt(request.getParameter("precio")));
			pr.setConsumible(cn);
			cDao.insert(cn);
		}
			b.addProducto(pr);
			bDao.insert(b);
			pr.setBodega(b);
			productoDao.insert(pr);
			dispatcher = request.getRequestDispatcher("mostrar.jsp");
		}else {
			dispatcher = request.getRequestDispatcher("mostrar.jsp");
			request.setAttribute("error", "El producto ya existe");
		}

		dispatcher.forward(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Producto> list = productoDao.list();
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("mostrar.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Producto pr = productoDao.find(id);

		RequestDispatcher dispatcher = request.getRequestDispatcher("editar.jsp");
		request.setAttribute("producto", pr);
		dispatcher.forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ParseException, ServletException {
		RequestDispatcher dispatcher = null;
		Integer id = Integer.parseInt(request.getParameter("id"));

		Producto pr = productoDao.find(id);

		if (pr != null) {
			pr.setNombre(request.getParameter("nombre"));
			pr.setDescripcion(request.getParameter("descripcion"));
			pr.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
		
			productoDao.update(pr);
			dispatcher = request.getRequestDispatcher("mostrar.jsp");
		} else {
			dispatcher = request.getRequestDispatcher("mostrar.jsp");
			request.setAttribute("error", "El producto no existe");
		}
		dispatcher.forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = null;
		Integer id = Integer.parseInt(request.getParameter("id"));
		Producto pr = productoDao.find(id);

		if(pr!=null) {
			Bodega b = bDao.find(pr.getBodega().getIdInventario());
			if(pr.getImplemento()!=null) {
				Implemento impl = iDao.find(pr.getImplemento().getIdProducto());
				iDao.delete(impl);
			}else {
				Consumible cn = cDao.find(pr.getConsumible().getIdProducto());
				cDao.delete(cn);
			}
			productoDao.delete(pr);
		    b.removeProducto(pr);
			bDao.update(b);
			dispatcher = request.getRequestDispatcher("EmpleadoServlet?action=mostrar");
		}else {
			dispatcher = request.getRequestDispatcher("mostrar.jsp");
			request.setAttribute("error", "El producto no existe");
		}
		dispatcher.forward(request, response);
	}

}
