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
import minhnq.dtos.OrderDTO;
import minhnq.dtos.ProductDTO;
import minhnq.utils.DBUtils;

/**
 *
 * @author admin
 */
public class OrderDAO {

    Connection connect;
    PreparedStatement ps;
    ResultSet rs;

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

    public String getLastOderIDByUser(String userID) throws Exception {
        String orderID = null;
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT orderID FROM tblOrder WHERE orderDate = (SELECT MAX(orderDate) FROM tblOrder WHERE userID = ?)";
                ps = connect.prepareStatement(sql);
                ps.setString(1, userID);
                rs = ps.executeQuery();
                if (rs.next()) {
                    orderID = rs.getString("orderID");
                }
            }

        } finally {
            closeConnection();
        }
        return orderID;
    }

    public int createOrder(String orderID, String userID, Date newDate, float totalPrice) throws SQLException {
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "INSERT INTO tblOrder(orderID,userID,orderDate,totalPrice) VALUES(?,?,?,?) ";
                ps = connect.prepareStatement(sql);
                ps.setString(1, orderID);
                ps.setString(2, userID);
                ps.setTimestamp(3, new Timestamp(newDate.getTime()));
                ps.setFloat(4, totalPrice);

                return ps.executeUpdate();
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }

        return 0;
    }

    public int createOrderDetail(String detailID,String orderID, String productID, float price, int quantity) throws SQLException {
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "INSERT INTO tblOrderDetail(detailID,orderID,productID,price,quantity) VALUES(?,?,?,?,?)" ;
                ps = connect.prepareStatement(sql);
                ps.setString(1, detailID);
                ps.setString(2, orderID);
                ps.setString(3, productID);
                ps.setFloat(4, price);
                ps.setInt(5, quantity);

                return ps.executeUpdate();
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return 0;
    }

    public List<OrderDTO> getListOrder(String userID, int Month) throws SQLException {
        List<OrderDTO> list = new ArrayList<>();
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT orderID, userID, orderDate, totalPrice WHERE userID=? AND MONTH(DATE)=? ";
                ps = connect.prepareStatement(sql);
                ps.setString(1, userID);
                ps.setInt(2, Month);

                rs = ps.executeQuery();
                while (rs.next()) {
                    String orderID = rs.getString("orderID");
//                    String userIDD=rs.getString("userID");
                    Date orderDate = rs.getDate("orderDate");
                    float totalPrice = rs.getFloat("totalPrice");

                    OrderDTO order = new OrderDTO(orderID, userID, orderDate, totalPrice);
                    list.add(order);
                }
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return list;
    }

    //lấy lịch sử mua hàng dựa trên orderID
    public List<ProductDTO> getOrderDetailByOrderID(String orderID) throws SQLException {
        List<ProductDTO> list=new ArrayList<>();
        try {
            String sql = "SELECT P.productName, P.image, P.price, OD.quantity FROM tblOrder O join tblProduct P ON P.productID=OD.productID "
                    + " JOIN tblOrderDetail OD ON O.orderID=OD.orderID "
                    + " WHERE O.OderID=?";
            ps = connect.prepareStatement(sql);
            ps.setString(1, orderID);
            rs = ps.executeQuery();

            while (rs.next()) {
                String productName = rs.getString("productName");
                String image = rs.getString("image");
                float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");

                ProductDTO product = new ProductDTO("1", productName, price, quantity, true, image, "abc", new Date(), 1, "abc");
                list.add(product);
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return list;
    }

    //update quantity by orderID
    public int updateProductQuantityByOrderID(String orderID) throws SQLException {
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "UPDATE tblProduct SET quantity=(P.quantity-OD.quantity) "
                        + " FROM tblProduct P join tblOrderDetail OD ON P.productID = OD.productID "
                        + " join tblOrder O ON O.orderID=OD.orderID "
                        + " WHERE O.orderID=? ";
                ps = connect.prepareStatement(sql);
                ps.setString(1, orderID);
                return ps.executeUpdate();
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return 0;
    }
}
