package presentacion.controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.vo.CategoriasVo;
import persistencia.dao.CategoriasDao;

/**
 *
 * @author e10417a
 */
public class ControladorCategorias extends HttpServlet {

    String listar = "catListar.jsp";
    String add = "catAdd.jsp";
    String edit = "catEdit.jsp";
    CategoriasVo cat = new CategoriasVo();
    CategoriasDao dao = new CategoriasDao();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String acceso = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("listar")) {
            acceso = listar;
        } else if (action.equalsIgnoreCase("add")) {
            acceso = add;
        } else if (action.equalsIgnoreCase("insertar")) {
            Integer idCat = Integer.parseInt(request.getParameter("txtID"));
            Integer idTipoCat = Integer.parseInt(request.getParameter("txtIDTipoCat"));
            String NombreCat = request.getParameter("txtNombreCat");

            cat.setIdCategoria(idCat);
            cat.setTipoCategoria(idTipoCat);
            cat.setNombreCategoria(NombreCat);
            dao.add(cat);
            acceso = listar;
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("idcat", request.getParameter("id"));
            acceso = edit;
        } else if (action.equalsIgnoreCase("update")) {
            Integer idCat = Integer.parseInt(request.getParameter("txtID"));
            Integer idTipoCat = Integer.parseInt(request.getParameter("txtIDTipoCat"));
            String NombreCat = request.getParameter("txtNombreCat");
            cat.setIdCategoria(idCat);
            cat.setTipoCategoria(idTipoCat);
            cat.setNombreCategoria(NombreCat);
            dao.edit(cat);
            acceso = listar;
        } else if (action.equalsIgnoreCase("delete")) {
            Integer idCat = Integer.parseInt(request.getParameter("id"));
            cat.setIdCategoria(idCat);
            dao.delete(idCat);
            acceso = listar;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
