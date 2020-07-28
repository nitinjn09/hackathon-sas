package com.example.dbcore;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
public class DBCoreController
{
    @GetMapping("/test")
    public String test()
    {
        String retVal = " DB Core :{ Working }";

        try
        {
            runSqlStatement("create database tnpsdb");
        }
        catch (Exception e)
        {
            System.out.println("Some error: " + e.getMessage());
        }

        return retVal;
    }

    private Connection getDbConnection()
    {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mariadb://db-service:80/?user=root&password=mariadb");
        } catch (SQLException e)
        {
            System.out.println("Some error in db connection: " + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

    private void runSqlStatement(String sql)
    {
        try {
            Statement statement = getDbConnection().createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Some error in sql query: " + e.getMessage());
            e.printStackTrace();
        }
    }
}