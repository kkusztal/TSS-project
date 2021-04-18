package pl.webapplication4KK.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.webapplication4KK.model.Data;
import pl.webapplication4KK.service.DataService;

/**
 *
 * @author kasia
 */
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
            if(command.equals("list"))
                userList(request, response);
            
            if(command.equals("new")) 
                showNewForm(request, response);
            
            if(command.equals("add"))
                addUser(request, response);
            
            if(command.equals("edit"))
                showEditForm(request, response);
            
            if(command.equals("update"))
                updateUser(request, response);
            
            if(command.equals("delete"))
                deleteUser(request, response);
        } else
            request.getRequestDispatcher("/views/index.jsp").forward(request,response);
    }
    
    private void userList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("users", dataService.getAllData());
        request.getRequestDispatcher("/views/dataList.jsp").forward(request,response);
    }
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/addData.jsp").forward(request,response);
    }
    
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("user", dataService.getData(id));
        request.getRequestDispatcher("/views/updateData.jsp").forward(request,response);
    }
    
    private void addUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        dataService.addData(new Data(firstName, lastName));
        request.setAttribute("users", dataService.getAllData());
        request.getRequestDispatcher("/views/dataList.jsp").forward(request,response);
    }
    
    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        dataService.editData(new Data(id, firstName, lastName));
        request.setAttribute("users", dataService.getAllData());
        request.getRequestDispatcher("/views/dataList.jsp").forward(request,response);
    }
    
    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        dataService.deleteData(id);
        request.setAttribute("users", dataService.getAllData());
        request.getRequestDispatcher("/views/dataList.jsp").forward(request,response);
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
