package com.emergentes.controlador;

import com.emergentes.modelo.Estudiante;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String op = request.getParameter("op");
        Estudiante objest = new Estudiante();
        int id, pos;

        HttpSession ses = request.getSession();
        ArrayList<Estudiante> lista = (ArrayList<Estudiante>) ses.getAttribute("listaest");
        switch (op) {
            case "nuevo": //enviar un obejeto vacio a editar
                request.setAttribute("miobjest", objest);
                request.getRequestDispatcher("editar.jsp").forward(request, response);

                break;
            case "editar":
                id = Integer.parseInt(request.getParameter("id"));
             
                pos = buscarPorIndice(request, id);
                
                objest = lista.get(pos);
                request.setAttribute("miobjest", objest);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "eliminar": 
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarPorIndice(request, id);
                if (pos >= 0) {
                    lista.remove(pos);
                }
                request.setAttribute("listaest", lista);
                response.sendRedirect("index.jsp");
                break;
            default:
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession ses = request.getSession();
        ArrayList<Estudiante> lista = (ArrayList<Estudiante>) ses.getAttribute("listaest");
        Estudiante objest = new Estudiante();
        objest.setId(id);
        objest.setNombre_del_estudiante(request.getParameter("nombre"));
        objest.setPrimer_Parcial(Integer.parseInt(request.getParameter("P1")));
        objest.setSegundo_Parcial(Integer.parseInt(request.getParameter("P2")));
        objest.setExamen_Final(Integer.parseInt(request.getParameter("EF")));
        objest.setNota(Integer.parseInt(request.getParameter("nota")));

        if (id == 0) {
            int idNuevo = obtenerId(request);
            objest.setId(idNuevo);
            lista.add(objest);
        } else {
            int pos = buscarPorIndice(request, id);
            lista.set(pos, objest);

        }
        request.setAttribute("listaest", lista);
        response.sendRedirect("index.jsp");

    }

    public int buscarPorIndice(HttpServletRequest request, int id) {
        HttpSession ses = request.getSession();
        ArrayList<Estudiante> lista = (ArrayList<Estudiante>) ses.getAttribute("listaest");
        int pos = -1;

        if (lista != null) {
            for (Estudiante ele : lista) {
                ++pos;
                if (ele.getId() == id) {
                    break;
                }
            }
        }
        return pos;
    }

    public int obtenerId(HttpServletRequest request) {
        HttpSession ses = request.getSession();
        ArrayList<Estudiante> lista = (ArrayList<Estudiante>) ses.getAttribute("listaest");
        int idn = 0;
        for (Estudiante ele : lista) {
            idn = ele.getId();
        }
        return idn + 1;
    }
}
