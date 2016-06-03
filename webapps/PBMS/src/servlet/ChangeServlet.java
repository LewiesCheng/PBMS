package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by JoyHwong on 16/6/3.
 * copyright @ 2016 All right reserved.
 * follow me on github https://github.com/JoyHwong
 */
public class ChangeServlet extends HttpServlet {

    private Connection connection;

    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        String database = context.getInitParameter("database");
        String driver = context.getInitParameter("driver");
        String database_user = context.getInitParameter("database_user");
        String database_password = context.getInitParameter("database_password");
        connection = new ConnectDatabase(driver, database, database_user, database_password).getConnection();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String income = request.getParameter("income");
        String spend = request.getParameter("spend");
        System.out.println("income " + income);
        System.out.println("spend " + spend);
        try {
            PreparedStatement preparedStatement;
            if (income != null) {
                preparedStatement = connection.prepareStatement("update bop set income = ? WHERE y = ? AND m = ?");
                preparedStatement.setFloat(1, Float.parseFloat(income));
                preparedStatement.setString(2, "2016");
                preparedStatement.setString(3, "6");
                preparedStatement.executeUpdate();
            } else if (spend != null) {
                preparedStatement = connection.prepareStatement("update bop set spend = ? WHERE y = ? AND m = ?");
                preparedStatement.setFloat(1, Float.parseFloat(spend));
                preparedStatement.setString(2, "2016");
                preparedStatement.setString(3, "6");
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("更新数据库出错");
        } finally {
            response.sendRedirect("/money");
        }
    }
}
