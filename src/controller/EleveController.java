package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Eleve;
import beans.EleveDAO;

/**
 * Servlet implementation class EleveController
 */
@WebServlet("/EleveController")
public class EleveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String INSERT_OR_EDIT = "/eleve.jsp";
    private static String LIST_ELEVE = "/listEleve.jsp";
    private EleveDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EleveController() {
        super();
        dao=new EleveDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forward="";
        String action = request.getParameter("action");
        
        if (action.equalsIgnoreCase("delete")){
            int eleveId = Integer.parseInt(request.getParameter("id"));
            dao.SupprEleve(eleveId);
            forward = LIST_ELEVE;
            request.setAttribute("eleves", dao.getAllEleve());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int EleveId = Integer.parseInt(request.getParameter("id"));
            Eleve eleve = dao.getEleveById(EleveId);
            request.setAttribute("eleve", eleve);
        } else if (action.equalsIgnoreCase("listEleve")){
            forward = LIST_ELEVE;
            request.setAttribute("eleves", dao.getAllEleve());
        } else {
            forward = INSERT_OR_EDIT;
        }
        
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Eleve eleve = new Eleve();
		eleve.setNom(request.getParameter("nom"));
		eleve.setPrenom(request.getParameter("prenom"));
		String id = request.getParameter("id");
		if(id == null || id.isEmpty())
        {
            dao.AjoutEleve(eleve);
        }
        else
        {
        	eleve.setId(Integer.parseInt(request.getParameter("id")));
            dao.UpdateEleve(eleve);
        }
//		eleve.setId(Integer.parseInt(request.getParameter("id")));
//		dao.AjoutEleve(eleve);
		RequestDispatcher view = request.getRequestDispatcher(LIST_ELEVE);
        request.setAttribute("eleves", dao.getAllEleve());
        view.forward(request, response);
	}

}
