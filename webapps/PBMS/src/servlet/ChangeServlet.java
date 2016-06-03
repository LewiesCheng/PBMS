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
        init();
        String income = request.getParameter("income");
        String food = request.getParameter("food");
        String rent = request.getParameter("rent");
        String educate = request.getParameter("educate");
        String utilitie = request.getParameter("utilitie");
        String medical = request.getParameter("medical");
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        PreparedStatement preparedStatement = null;
        try {
            if (income != null) {
                preparedStatement = connection.prepareStatement("update bop set income = ? WHERE y = ? AND m = ?");
                preparedStatement.setFloat(1, Float.parseFloat(income));
                preparedStatement.setString(2, year);
                preparedStatement.setString(3, month);
                preparedStatement.executeUpdate();
            } else if (food != null) {
                preparedStatement = connection.prepareStatement("update spenddetail set food = ? WHERE y = ? AND m = ?");
                preparedStatement.setFloat(1, Float.parseFloat(food));
                preparedStatement.setString(2, year);
                preparedStatement.setString(3, month);
                preparedStatement.executeUpdate();
            } else if (rent != null) {
                preparedStatement = connection.prepareStatement("update spenddetail set rent = ? WHERE y = ? AND m = ?");
                preparedStatement.setFloat(1, Float.parseFloat(rent));
                preparedStatement.setString(2, year);
                preparedStatement.setString(3, month);
                preparedStatement.executeUpdate();
            } else if (educate != null) {
                preparedStatement = connection.prepareStatement("update spenddetail set educate = ? WHERE y = ? AND m = ?");
                preparedStatement.setFloat(1, Float.parseFloat(educate));
                preparedStatement.setString(2, year);
                preparedStatement.setString(3, month);
                preparedStatement.executeUpdate();
            } else if (utilitie != null) {
                preparedStatement = connection.prepareStatement("update spenddetail set utilitie = ? WHERE y = ? AND m = ?");
                preparedStatement.setFloat(1, Float.parseFloat(utilitie));
                preparedStatement.setString(2, year);
                preparedStatement.setString(3, month);
                preparedStatement.executeUpdate();
            } else if (medical != null) {
                preparedStatement = connection.prepareStatement("update spenddetail set medical = ? WHERE y = ? AND m = ?");
                preparedStatement.setFloat(1, Float.parseFloat(medical));
                preparedStatement.setString(2, year);
                preparedStatement.setString(3, month);
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println("更新数据库出错");
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                    System.out.println("关闭数据库出错");
            }

            String s = "/money?year=" + year + "&month=" + month;
            request.getRequestDispatcher(s).forward(request, response);
        }
    }
}
