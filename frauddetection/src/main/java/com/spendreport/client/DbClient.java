package com.spendreport.client;

import org.apache.flink.connector.jdbc.JdbcConnectionOptions;

/**
 * Created by pisiliang on 2023/6/1 14:25
 */
public class DbClient {
    /**
     * postgres
     */
    private static final String POSTGRES_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String POSTGRES_USERNAME = "postgres";
    private static final String POSTGRES_PASSWORD = "postgres";
    public static JdbcConnectionOptions postgres_build=new JdbcConnectionOptions.JdbcConnectionOptionsBuilder()
            .withDriverName("org.postgresql.Driver")
            .withUrl(POSTGRES_URL)
            .withPassword(POSTGRES_PASSWORD)
            .withUsername(POSTGRES_USERNAME).build();


    /**
     * mysql
     */
    private static final String MYSQL_URL = "jdbc:mysql://localhost:3306/test";
    private static final String MYSQL_USERNAME = "root";
    private static final String MYSQL_PASSWORD = "root";
    public static JdbcConnectionOptions mysql_build=new JdbcConnectionOptions.JdbcConnectionOptionsBuilder()
            .withDriverName("com.mysql.jdbc.Driver")
            .withUrl(MYSQL_URL)
            .withPassword(MYSQL_PASSWORD)
            .withUsername(MYSQL_USERNAME).build();
}
