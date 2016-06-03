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
    private Connection connection;

    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        String database = context.getInitParameter("database");
        String database_user = context.getInitParameter("database_user");
        String database_password = context.getInitParameter("database_password");
        String driver = context.getInitParameter("driver");
        connection = new ConnectDatabase(driver, database, database_user, database_password).getConnection();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        init();
        Count count = new Count();

        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try {
            // 从request里面获取year和month
            String year = request.getParameter("year");
            String month = request.getParameter("month");
            if (year == null || month == null) {
                year = "2016";
                month = "6";
            }
            count.setMonth(month);
            count.setYear(year);

            // 数据库中查询支出明细
            preparedStatement = connection.prepareStatement("SELECT food, rent, educate, utilitie, medical from spenddetail WHERE y = ? and m = ?");
            preparedStatement.setString(1, year);
            preparedStatement.setString(2, month);
            resultSet = preparedStatement.executeQuery();

            //将支出明细汇总到明细中
            float spend = 0.00f;
            while (resultSet.next()) {
                count.setFood(resultSet.getFloat(1));
                spend += count.getFood();
                count.setRent(resultSet.getFloat(2));
                spend += count.getRent();
                count.setEducate(resultSet.getFloat(3));
                spend += count.getEducate();
                count.setUtilitie(resultSet.getFloat(4));
                spend += count.getUtilitie();
                count.setMedical(resultSet.getFloat(5));
                spend += count.getMedical();
            }
            count.setSpend(spend);

            // 更新支出
            preparedStatement = connection.prepareStatement("UPDATE bop set spend = ? WHERE y = ? AND m = ?");
            preparedStatement.setFloat(1, count.getSpend());
            preparedStatement.setString(2, year);
            preparedStatement.setString(3, month);
            preparedStatement.executeUpdate();

            // 查询收入和支出来统计本年的总支出和总收入
            preparedStatement = connection.prepareStatement("select income, spend from bop WHERE y = ?");
            preparedStatement.setString(1, year);
            resultSet  = preparedStatement.executeQuery();
            float totalincome = 0.00f;
            float totalSpend = 0.00f;
            while (resultSet.next()) {
                totalincome += resultSet.getFloat("income");
                totalSpend += resultSet.getFloat("spend");
            }
            count.setTotalIncome(totalincome);
            count.setTotalSpend(totalSpend);

            // 查询某年某月的收入
            preparedStatement = connection.prepareStatement("select income from bop where y = ? and m = ?");
            preparedStatement.setString(1, year);
            preparedStatement.setString(2, month);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                count.setIncome(resultSet.getFloat(1));
            }

            // 关闭资源
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException sqlException) {
            System.out.println("Execute database query error");
        } finally {
            HttpSession session = request.getSession();
            session.setAttribute("count", count);
            response.sendRedirect("money.jsp");
        }
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
