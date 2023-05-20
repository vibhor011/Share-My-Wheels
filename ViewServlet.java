import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import jakarta.servlet.ServletException;  
import jakarta.servlet.annotation.WebServlet;  
import jakarta.servlet.http.HttpServlet;  
import jakarta.servlet.http.HttpServletRequest;  
import jakarta.servlet.http.HttpServletResponse;  
@WebServlet("/ViewServlet")  
public class ViewServlet extends HttpServlet {  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        try (PrintWriter out = response.getWriter()) {
             out.print("<style>\n" +
"/* Set global styles */\n" +
"body {\n" +
"  font-family: Arial, sans-serif;\n" +
"  color: #333;\n" +
"  background-color: #f5f5f5;\n" +
"  background-image: url('img7.png');"+
     " background-repeat: no-repeat;"+
     " background-size: cover; "    +               
"}\n" +
"\n" +
"/* Set styles for headings */\n" +
"h1, h2, h3 {\n" +
"  margin-top: 0;\n" +
"  margin-bottom: 10px;\n" +
"  font-weight: bold;\n" +
"  color: #fff;\n" +
"}\n" +
"\n" +
"/* Set styles for links */\n" +
"a {\n" +
"  color: #0c23f2;\n" +
"  text-decoration: none;\n" +
"}\n" +
"a:hover {\n" +
"  text-decoration: underline;\n" +
"}\n" +
"\n" +
"/* Set styles for form elements */\n" +
"input[type=\"text\"],\n" +
"input[type=\"password\"],\n" +
"input[type=\"email\"],\n" +
"select {\n" +
"  display: block;\n" +
"  width: 100%;\n" +
"  padding: 10px;\n" +
"  margin-bottom: 10px;\n" +
"  font-size: 16px;\n" +
"  border: 1px solid #ccc;\n" +
"  border-radius: 4px;\n" +
"  box-sizing: border-box;\n" +
"}\n" +
"\n" +
"input[type=\"submit\"] {\n" +
"  display: inline-block;\n" +
"  padding: 10px 20px;\n" +
"  font-size: 16px;\n" +
"  font-weight: bold;\n" +
"  color: #fff;\n" +
"  background-color: #86ffed;\n" +
"  border: none;\n" +
"  border-radius: 4px;\n" +
"  cursor: pointer;\n" +
"  transition: background-color 0.3s ease;\n" +
"}\n" +
"input[type=\"submit\"]:hover {\n" +
"  background-color: #005fa3;\n" +
"}\n" +
"\n" +
"/* Set styles for tables */\n" +
"table {\n" +
"  width: 100%;\n" +
"  border-collapse: collapse;\n" +
"  background-color: #fff;\n" +
"  box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);\n" +
"}\n" +
"th, td {\n" +
"  padding: 10px;\n" +
"  border: 1px solid #ccc;\n" +
"  text-align: left;\n" +
"}\n" +
"th {\n" +
"  background-color: #ffab45;\n" +
"  color: #fff;\n" +
"}\n" +
"\n" +
"/* Set styles for container element */\n" +
".container {\n" +
"  max-width: 960px;\n" +
"  margin: 0 auto;\n" +
"  padding: 20px;\n" +
"}\n" +
"</style>");
            out.println("<a href='index1.html'>Add New Car Detail</a>");
            out.println("<h1>Car List</h1>");
            
            List<Emp> list=EmpDao.getAllEmployees();
            
            out.print("<table border='1' width='100%'");
            out.print("<tr><th>carName</th><th>location</th><th>carDescription</th><th>carType</th><th>price</th><th>colour</th><th>year</th><th>Edit</th><th>Delete</th></tr>");
            for(Emp e:list){
                out.print("<tr><td>"+e.getcarName()+"</td><td>"+e.getlocation()+"</td> <td>"+e.getcarDescription()+"</td><td>"+e.getcarType()+"</td><td>"+e.getprice()+"</td><td>"+e.getcolour()+"</td><td>"+e.getyear()+"</td><td><a href='EditServlet?carId="+e.getcarId()+"'>edit</a></td><td><a href='DeleteServlet?carId="+e.getcarId()+"'>delete</a></td></tr>");
            }
            out.print("</table>");
        }  
    }  
}  
