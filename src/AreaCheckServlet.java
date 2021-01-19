import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static jdk.nashorn.internal.runtime.JSType.isNumber;

@WebServlet(name = "AreaCheckServlet", urlPatterns = "/checking")
public class AreaCheckServlet extends HttpServlet {

    private ServletConfig config;
    private List<Point> list = null;


    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    public void destroy() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        config.getServletContext().setAttribute("table", Bean.printPoints());
        getServletContext().getRequestDispatcher("/results.jsp").forward(request, response);
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if (!Arrays.asList("1", "2", "3", "4", "5").contains(request.getParameter("R")))
                throw new Exception();
            Point p = new Point(Double.parseDouble(request.getParameter("X")), Double.parseDouble(request.getParameter("Y")), Double.parseDouble(request.getParameter("R")));
            p.isInArea = checkArea(p.x, p.y, p.R);
            Bean.table.add(p);
        } catch (Exception e) {
            request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
        config.getServletContext().setAttribute("table", Bean.printPoints());
        if (request.getParameter("silent") != null && request.getParameter("silent").equals("on")) {
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            out.print("{" + "\"in_area\":" + (Bean.table.get(Bean.table.size() - 1).isInArea ? "true" : "false") + "," +
                    "\"data\":" + "\"" + Bean.printPoint(Bean.table.get(Bean.table.size() - 1)) + "\"" + "}");
            out.flush();
        } else {
            getServletContext().getRequestDispatcher("/results.jsp").forward(request, response);
        }
    }


    private static boolean checkArea ( double x, double y, double R){
        if (x >= 0 && y >= 0 && y <= -x + R)   {
            return true;
        }
        if (x <= 0 && y >= 0 && x >= -R && y <= (R/2.0)){
            return true;
        }
        if (x <= 0 && y <= 0 && (pow(y, 2) + pow(x, 2) <= pow(R * 0.5, 2))) {
            return true;
        }
        return false;
    }
}