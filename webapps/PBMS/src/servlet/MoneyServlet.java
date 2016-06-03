package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by JoyHwong on 16/6/3.
 * copyright @ 2016 All right reserved.
 * follow me on github https://github.com/JoyHwong
 */
public class MoneyServlet extends HttpServlet {

    private Count count;

    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        String database = context.getInitParameter("database");
        String database_user = context.getInitParameter("database_user");
        String database_password = context.getInitParameter("database_password");
        String driver = context.getInitParameter("driver");
        count = new Count();
        Connection connection = new ConnectDatabase(driver, database, database_user, database_password).getConnection();
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try {
            preparedStatement = connection.prepareStatement("select income, spend from bop WHERE y = ?");
            preparedStatement.setString(1, "2016");
            resultSet  = preparedStatement.executeQuery();
            float totalincome = 0.00f;
            float totalSpend = 0.00f;
            while (resultSet.next()) {
                totalincome += resultSet.getFloat("income");
                totalSpend += resultSet.getFloat("spend");
            }

            count.setTotalIncome(totalincome);
            count.setTotalSpend(totalSpend);

            preparedStatement = connection.prepareStatement("select income, spend from bop where y = ? and m = ?");
            preparedStatement.setString(1, "2016");
            preparedStatement.setString(2, "6");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                count.setIncome(resultSet.getFloat(1));
                count.setSpend(resultSet.getFloat(2));
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException sqlException) {
            System.out.println("Execute database query error");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        init();
        HttpSession session = request.getSession();
        session.setAttribute("count", count);
        response.sendRedirect("money.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("do post method");
    }

    @Override
    public void destroy() {
        System.out.println("MoneyServlet was be destroy");
    }
}
