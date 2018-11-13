/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.vo.CategoriasVo;
import logica.vo.TipoCategoriaVo;
import persistencia.dao.CategoriasDao;
import persistencia.dao.TipoCategoriasDao;

/**
 *
 * @author e10417a
 */
public class ControladorTipoCategorias extends HttpServlet {

    String listar = "tcListar.jsp";
    String add = "tcAdd.jsp";
    String edit = "tcEdit.jsp";
    TipoCategoriaVo tc = new TipoCategoriaVo();
    TipoCategoriasDao dao = new TipoCategoriasDao();
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

            tc.setIdTipoCategoria(idTipoCat);
            tc.setNombreTipoCat(NombreCat);
            dao.add(tc);
            acceso = listar;
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("idcat", request.getParameter("id"));
            acceso = edit;
        } else if (action.equalsIgnoreCase("update")) {
            Integer idCat = Integer.parseInt(request.getParameter("txtID"));
            Integer idTipoCat = Integer.parseInt(request.getParameter("txtIDTipoCat"));
            String NombreCat = request.getParameter("txtNombreCat");
            tc.setIdTipoCategoria(idTipoCat);
            tc.setNombreTipoCat(NombreCat);
            dao.add(tc);
            acceso = listar;
        } else if (action.equalsIgnoreCase("delete")) {
            Integer idTipoCat = Integer.parseInt(request.getParameter("id"));
            tc.setIdTipoCategoria(idTipoCat);
            dao.delete(idTipoCat);
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
