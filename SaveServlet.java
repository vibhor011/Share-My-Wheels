import java.io.IOException;  
import java.io.PrintWriter;  
import jakarta.servlet.ServletException;  
import jakarta.servlet.annotation.WebServlet;  
import jakarta.servlet.http.HttpServlet;  
import jakarta.servlet.http.HttpServletRequest;  
import jakarta.servlet.http.HttpServletResponse;  
@WebServlet("/SaveServlet")  
public class SaveServlet extends HttpServlet {  
    protected void doPost(HttpServletRequest request,HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String carName=request.getParameter("carName");  
        String location=request.getParameter("location");  
        String carDescription=request.getParameter("carDescription");  
        String carType=request.getParameter("carType");  
        String price=request.getParameter("price");  
        String colour=request.getParameter("colour");  
        String year=request.getParameter("year");  

        Emp e=new Emp();  
        e.setcarName(carName);  
        e.setlocation(location);  
        e.setcarDescription(carDescription);  
        e.setcarType(carType);  
        e.setprice(price);  
        e.setcolour(colour);  
        e.setyear(year);  
        int status=EmpDao.save(e);  
        if(status>0){  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("index.html").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
    }  
  
}  