package pl.webapplicationKK.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.webapplicationKK.model.Data;
import pl.webapplicationKK.service.DataService;

/**
 *
 * @author kasia
 */
@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {
    private DataService dataService;

    public MainServlet() {
        dataService = new DataService();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String command = request.getParameter("command");
 
        if(command != null) {
            if(command.equals("list")) {
                request.setAttribute("users", dataService.getAllData());
                request.getRequestDispatcher("/views/dataList.jsp").forward(request,response);
            }
            
            if(command.equals("processAdd")) 
                request.getRequestDispatcher("/views/addData.jsp").forward(request,response);
            
            if(command.equals("add")) {
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                dataService.addData(new Data(firstName, lastName));
                request.setAttribute("users", dataService.getAllData());
                request.getRequestDispatcher("/views/dataList.jsp").forward(request,response);
            }
            
            if(command.equals("processUpdate")) {
                int id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("user", dataService.getData(id));
                request.getRequestDispatcher("/views/updateData.jsp").forward(request,response);
            }
            
            if(command.equals("update")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                dataService.editData(new Data(id, firstName, lastName));
                request.setAttribute("users", dataService.getAllData());
                request.getRequestDispatcher("/views/dataList.jsp").forward(request,response);
            }
            
            if(command.equals("delete")) {
                int id = Integer.parseInt(request.getParameter("id"));
                dataService.deleteData(id);
                request.setAttribute("users", dataService.getAllData());
                request.getRequestDispatcher("/views/dataList.jsp").forward(request,response);
            }
        } else
            request.getRequestDispatcher("/views/index.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
