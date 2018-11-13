/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.controlador;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import logica.vo.MovimientosVo;
import persistencia.dao.MovimientosDao;

/**
 *
 * @author e10417a
 */
public class ControladorMovimientos extends HttpServlet {

    String listar = "movListar.jsp";
    String add = "movAdd.jsp";
    String edit = "movEdit.jsp";
    MovimientosVo mov = new MovimientosVo();
    MovimientosDao dao = new MovimientosDao();
    DateFormat format = new SimpleDateFormat("dd/mm/yyyyy");
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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        String acceso = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("listar")) {
            acceso = listar;
        } else if (action.equalsIgnoreCase("add")) {
            acceso = add;
        } else if (action.equalsIgnoreCase("insertar")) {
            Integer idMov = Integer.parseInt(request.getParameter("txtID"));
            Date fecha =  format.parse(request.getParameter("txtFecha"));
            Integer valor = Integer.parseInt(request.getParameter("txtValor"));
            Integer idCuenta = Integer.parseInt(request.getParameter("txtCuenta"));
            Integer idCategoria = Integer.parseInt(request.getParameter("txtCategoria"));
            mov.setIdMov(idMov);
            mov.setFechaMov(fecha);
            mov.setValorMovimiento(valor);
            mov.setIdCuenta(idCuenta);
            mov.setIdCategoria(idCategoria);
            dao.add(mov);
            acceso = listar;
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("idper", request.getParameter("id"));
            acceso = edit;
        } else if (action.equalsIgnoreCase("update")) {
            Integer idMov = Integer.parseInt(request.getParameter("txtID"));
            Date fecha = format.parse(request.getParameter("txtFecha"));
            Integer valor = Integer.parseInt(request.getParameter("txtValor"));
            Integer idCuenta = Integer.parseInt(request.getParameter("txtCuenta"));
            Integer idCategoria = Integer.parseInt(request.getParameter("txtCategoria"));
            mov.setIdMov(idMov);
            mov.setFechaMov(fecha);
            mov.setValorMovimiento(valor);
            mov.setIdCuenta(idCuenta);
            mov.setIdCategoria(idCategoria);
            dao.edit(mov);
            acceso = listar;
        } else if (action.equalsIgnoreCase("delete")) {
            Integer idMov =Integer.parseInt(request.getParameter("id"));
            mov.setIdMov(idMov);
            dao.delete(idMov);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ControladorMovimientos.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ControladorMovimientos.class.getName()).log(Level.SEVERE, null, ex);
        }
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
