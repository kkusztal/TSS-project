package pl.webapplication3KK.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.webapplication.model.DataService;

/**
 *
 * @author kasia
 */
public class MainServlet extends HttpServlet {
    private DataService dataService;

    public MainServlet() {
        this.dataService = new DataService();
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
        request.setAttribute("users", this.dataService.getData());
        request.getRequestDispatcher("/views/dataList.jsp").forward(request,response);
    }
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/addData.jsp").forward(request,response);
    }
    
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/updateData.jsp").forward(request,response);
    }
    
    private void addUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String city = request.getParameter("city");
        this.dataService.addData(firstName, lastName, city);
        request.setAttribute("users", this.dataService.getData());
        request.getRequestDispatcher("/views/dataList.jsp").forward(request,response);
    }
    
    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String city = request.getParameter("city"); 
        this.dataService.updateData(id, firstName, lastName, city);
        request.setAttribute("users", this.dataService.getData());
        request.getRequestDispatcher("/views/dataList.jsp").forward(request,response);
    }
    
    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.dataService.deleteData(id);
        request.setAttribute("users", this.dataService.getData());
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
