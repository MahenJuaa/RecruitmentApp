/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Candidate;

public class CandidateDAO {

    Connection conn;

    public CandidateDAO() {
        conn = DBConnection.getConnection();
    }

    public void insert(Candidate c) {

        String query = "INSERT INTO candidates "
                + "(name,path,writing,coding,interview,score,status) "
                + "VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, c.getName());
            ps.setString(2, c.getPath());
            ps.setDouble(3, c.getWriting());
            ps.setDouble(4, c.getCoding());
            ps.setDouble(5, c.getInterview());
            ps.setDouble(6, c.calculateScore());
            ps.setString(7, c.getStatus());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Candidate> getAll() {

        List<Candidate> list = new ArrayList<>();

        String query = "SELECT * FROM candidates";

        try {
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                Candidate c = new Candidate();

                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setPath(rs.getString("path"));
                c.setWriting(rs.getDouble("writing"));
                c.setCoding(rs.getDouble("coding"));
                c.setInterview(rs.getDouble("interview"));

                list.add(c);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public void update(Candidate c) {

        String query = "UPDATE candidates SET "
                + "name=?, path=?, writing=?, coding=?, "
                + "interview=?, score=?, status=? WHERE id=?";

        try {
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, c.getName());
            ps.setString(2, c.getPath());
            ps.setDouble(3, c.getWriting());
            ps.setDouble(4, c.getCoding());
            ps.setDouble(5, c.getInterview());
            ps.setDouble(6, c.calculateScore());
            ps.setString(7, c.getStatus());
            ps.setInt(8, c.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id) {

        String query = "DELETE FROM candidates WHERE id=?";

        try {
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
