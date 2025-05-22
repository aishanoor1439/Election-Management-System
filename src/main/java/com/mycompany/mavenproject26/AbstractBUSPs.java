package com.mycompany.mavenproject26;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AbstractBUSPs {
    public Connection Con = null;
    public PreparedStatement pst = null;
    public ResultSet Ru, Rs, Rs1 = null;
    public Statement St, St1 = null;
}
