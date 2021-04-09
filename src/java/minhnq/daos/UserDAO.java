/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnq.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import minhnq.dtos.UserDTO;
import minhnq.utils.DBUtils;

/**
 *
 * @author admin
 */
public class UserDAO {

    Connection connect;
    PreparedStatement ps;
    ResultSet rs;

    public UserDAO() {
        connect = null;
        ps = null;
        rs = null;
    }

    public void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (connect != null) {
            connect.close();
        }

    }

    public String checkUserID(String userIDVuaNhap) throws SQLException {
        String userID = null;

        try {
            connect =DBUtils.getConnection();
            if(connect!=null){
                String sql="SELECT userID FROM tblUser WHERE userID=?";
                ps=connect.prepareStatement(sql);
                ps.setString(1, userIDVuaNhap);
                rs=ps.executeQuery();
                if(rs.next()){
                    userID=rs.getString("userID");
                }
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return userID;
    }

    public UserDTO checkLogin(String userID, String password) throws SQLException {
        UserDTO user = null;

        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT userID, password, name, email, roleID FROM tblUser WHERE userID=?";

                ps = connect.prepareStatement(sql);
                ps.setString(1, userID);
                rs = ps.executeQuery();
                if (rs.next()) {
                    String pass = rs.getString("password");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String roleID = rs.getString("roleID");

                    if (password.equals(pass)) {
                        user = new UserDTO(userID, password, name, email, roleID);
                    }
                }
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return user;
    }
    
    public UserDTO getUserByEmail(String email) throws SQLException{
        UserDTO user=null;
        try{
            connect=DBUtils.getConnection();
            if(connect!=null){
                String sql="SELECT userID, password, name, email, roleID FROM tblUser WHERE email=?";
                ps=connect.prepareStatement(sql);
                ps.setString(1, email);
                rs=ps.executeQuery();
                if(rs.next()){
                    String userID=rs.getString("userID");
                    String password=rs.getString("password");
                    String name=rs.getString("name");
//                    String emaill=rs.getString("email");
                    String roleID=rs.getString("roleID");
                    
                    user=new UserDTO(userID, password, name, email, roleID);
                }
            }
        }catch(Exception e){
            
        }finally{
            closeConnection();
        }
        return user;
    }
}
