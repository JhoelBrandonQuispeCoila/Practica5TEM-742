package com.emergentes.controller;

import com.emergentes.bean.BeanEstudiate;
import com.emergentes.entidades.Estudiante;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Estamos en el servlet");
        
        String action = request.getParameter("action");
        if (action == null) {
            action = "listar";
        }
        
        switch (action) {
            case "nuevo":
                request.setAttribute("estudiante", new Estudiante());
                request.getRequestDispatcher("frmestudiante.jsp").forward(request, response);
                break;
            case "editar":
                Integer id = Integer.parseInt(request.getParameter("id"));
                BeanEstudiate dao = new BeanEstudiate();
                Estudiante estudiante = dao.buscar(id);
                request.setAttribute("estudiante", estudiante);
                request.getRequestDispatcher("frmestudiante.jsp").forward(request, response);
                break;
            case "eliminar":
                eliminar(request,response);
                break;
            default:
                mostrar(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String email = request.getParameter("email");
        String fechaNacimientoStr = request.getParameter("fechaNacimiento");
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimiento = null;
        try {
            fechaNacimiento = dateFormat.parse(fechaNacimientoStr);
        } catch (ParseException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Estudiante estudiante = new Estudiante();
        estudiante.setId(id);
        estudiante.setNombre(nombre);
        estudiante.setApellidos(apellidos);
        estudiante.setEmail(email);
        estudiante.setFechaNacimiento(fechaNacimiento);
        BeanEstudiate dao = new BeanEstudiate();
        if(id == 0){
            dao.insertar(estudiante);
        } else {
            dao.editar(estudiante);
        }
        response.sendRedirect("MainController");
    }
    
    private void mostrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BeanEstudiate dao = new BeanEstudiate();
        List<Estudiante> lista = dao.listarTodos();
        request.setAttribute("estudiantes", lista);
        request.getRequestDispatcher("estudiantes.jsp").forward(request, response);
    }
    private void nuevo(){
        BeanEstudiate dao = new BeanEstudiate();
        Estudiante e = new Estudiante();
        e.setNombre("Armando");
        e.setApellidos("Terrazas");
        e.setEmail("armando.terrazas@mail.com");
        e.setFechaNacimiento(java.sql.Date.valueOf("2003-08-11"));
        
        dao.insertar(e);
    }
    
    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        BeanEstudiate dao = new BeanEstudiate();
        dao.eliminar(id);
        response.sendRedirect("MainController");
    }
    
    private void editar(){
        BeanEstudiate dao = new BeanEstudiate();
        
        Integer id = 2;
        
        Estudiante e = dao.buscar(id);
        
        e.setNombre("Tapia");
        e.setApellidos("Ricardo");
        e.setEmail("tapia.ric@mail.com");
        e.setFechaNacimiento(java.sql.Date.valueOf("2000-08-11"));
    }
}
