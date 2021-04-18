package pl.webapplication4KK.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kasia
 */
public class ImageServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("image/jpeg");
        
        ServletOutputStream out = response.getOutputStream();

        BufferedImage image = ImageIO.read(getServletContext().getResourceAsStream("/images/flower.jpg"));
        
        Graphics graph = image.getGraphics();
        
        graph.setColor(Color.YELLOW);
        graph.fillOval(20,260,200,200);
        graph.setColor(Color.CYAN);
        graph.fillRect(420, 20, 200, 200);
 
        try {
            ImageIO.write(image, "jpg", out);
        } catch(IOException e) { 
            System.err.println("Error writing JPEG file: " + e); 
        } finally {
            out.close(); 
        }   
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
