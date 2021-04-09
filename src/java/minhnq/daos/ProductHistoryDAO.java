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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import minhnq.dtos.ProductHistoryDTO;
import minhnq.utils.DBUtils;

/**
 *
 * @author admin
 */
public class ProductHistoryDAO {

    Connection connect = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

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

//    public int addHistory(ProductHistoryDTO productHistory) throws SQLException {
//        try {
//            connect = DBUtils.getConnection();
//            if (connect != null) {
//                String sql = "INSERT INTO tblProductHistory(type,recordTime,productID,userID) VALUES(?,?,?,?)";
//                ps = connect.prepareStatement(sql);
//                
//                ps.setString(1, productHistory.getType());
//                ps.setTimestamp(2, new Timestamp(productHistory.getRecordTime().getTime()));
//                ps.setString(3, productHistory.getProductID());
//                ps.setString(4, productHistory.getUserID());
//
//                return ps.executeUpdate();
//
//            }
//        } catch (Exception e) {
//
//        } finally {
//            closeConnection();
//        }
//        return 0;
//    }
    
    public int insertHistory(ProductHistoryDTO history) throws SQLException{
        try{
            connect=DBUtils.getConnection();
            if(connect!=null){
                String sql="INSERT INTO tblProductHistory(type,recordTime,productID,userID) VALUES(?,?,?,?)";
                ps=connect.prepareStatement(sql);
                ps.setString(1, history.getType());
                ps.setTimestamp(2, new Timestamp(history.getRecordTime().getTime()));
                ps.setString(3, history.getProductID());
                ps.setString(4, history.getUserID());
                return ps.executeUpdate();
            }
        }catch(Exception e){
            
        }finally{
            closeConnection();
        }
        return 0;
    }
    
    public List<ProductHistoryDTO> listProductHistory() throws SQLException {
        List<ProductHistoryDTO> list = new ArrayList<>();
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql="SELECT historyID,type,recordTime,productID,userID FROM tblProductHistory";
                ps=connect.prepareStatement(sql);
                rs=ps.executeQuery();
                while(rs.next()){
                    int productHistoryID=rs.getInt("historyID");
                    String type=rs.getString("type");
                    Date recordTime=rs.getDate("recordTime");
                    String productID=rs.getString("productID");
                    String userID=rs.getString("userID");
                    
                    ProductHistoryDTO history=new ProductHistoryDTO(productHistoryID, type, recordTime, productID, userID);
                    
                    list.add(history);
                }
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return list;
    }
}
