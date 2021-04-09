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
import minhnq.dtos.CategoryDTO;
import minhnq.dtos.ProductDTO;
import minhnq.utils.DBUtils;

/**
 *
 * @author admin
 */
public class ProductDAO {

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

    public int getNumberPage() throws SQLException {
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT count(*) from tblProduct"
                        + " WHERE status='true' AND quantity>0";
                ps = connect.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int total = rs.getInt(1);//lấy tổng số lượng của sản phẩm
                    int countPage = 0;
                    countPage = total / 20;//chia lấy phần nguyên

                    if (total % 20 != 0) {
                        countPage++;//nếu chia lấy dư !=0 thì cộng thêm 1 trang nữa vào count page
                    }
                    return countPage;
                }
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return 0;
    }
    
    public int getNumberPageNoCondition() throws SQLException {
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT count(*) from tblProduct";
                ps = connect.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int total = rs.getInt(1);//lấy tổng số lượng của sản phẩm
                    int countPage = 0;
                    countPage = total / 20;//chia lấy phần nguyên

                    if (total % 20 != 0) {
                        countPage++;//nếu chia lấy dư !=0 thì cộng thêm 1 trang nữa vào count page
                    }
                    return countPage;
                }
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return 0;
    }

    public int getNumberPageSearchByName(String name) throws SQLException {
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT count(*) "
                        + " FROM tblProduct "
                        + " WHERE productName like ? AND status='true' AND quantity>0";
                ps = connect.prepareStatement(sql);
                ps.setString(1, "%" + name + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    int total = rs.getInt(1);//lấy tổng số lượng của sản phẩm
                    int countPage = 0;
                    countPage = total / 20;//chia lấy phần nguyên

                    if (total % 20 != 0) {
                        countPage++;//nếu chia lấy dư !=0 thì cộng thêm 1 trang nữa vào count page
                    }
                    return countPage;
                }
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return 0;
    }

    public int getNumberPageSearchByPrice(float fromMoney, float toMoney) throws SQLException {
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT count(*) "
                        + " FROM tblProduct "
                        + " WHERE price>=? AND price <=? AND status='true' AND quantity>0";
                ps = connect.prepareStatement(sql);
                ps.setFloat(1, fromMoney);
                ps.setFloat(2, toMoney);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int total = rs.getInt(1);//lấy tổng số lượng của sản phẩm
                    int countPage = 0;
                    countPage = total / 20;//chia lấy phần nguyên

                    if (total % 20 != 0) {
                        countPage++;//nếu chia lấy dư !=0 thì cộng thêm 1 trang nữa vào count page
                    }
                    return countPage;
                }
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return 0;
    }

    public int getNumberPageSearchByCategory(String ID) throws SQLException {
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT count(*) "
                        + " FROM tblProduct "
                        + " WHERE categoryID=? AND status='true' AND quantity>0";
                ps = connect.prepareStatement(sql);
                ps.setString(1, ID);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int total = rs.getInt(1);//lấy tổng số lượng của sản phẩm
                    int countPage = 0;
                    countPage = total / 20;//chia lấy phần nguyên

                    if (total % 20 != 0) {
                        countPage++;//nếu chia lấy dư !=0 thì cộng thêm 1 trang nữa vào count page
                    }
                    return countPage;
                }
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return 0;
    }

    //không cần truyền tham số
    public List<ProductDTO> getListProduct() throws SQLException {
        List<ProductDTO> list = new ArrayList<>();

        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT productID, productName, price, quantity, status, image, description, createDate, counter, categoryID "
                        + " FROM tblProduct "
                        + " WHERE status='true' AND quantity>0"
                        + " ORDER BY createDate";

                ps = connect.prepareStatement(sql);
//                ps.setInt(1, (index-1)*20 );

                rs = ps.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    Float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    boolean status = rs.getBoolean("status");
                    String image = rs.getString("image");
                    String description = rs.getString("description");
                    Date createDate = rs.getDate("createDate");
                    int counter = rs.getInt("counter");
                    String categoryID = rs.getString("categoryID");

                    ProductDTO product = new ProductDTO(productID, productName, price, quantity, status, image, description, createDate, counter, categoryID);
                    list.add(product);

                }
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return list;
    }
    
    //getListProductNoCondition
    public List<ProductDTO> getListProductPagingNoCondition(int index) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();

        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT productID, productName, price, quantity, status, image, description, createDate, counter, categoryID "
                        + " FROM tblProduct "
                        + " ORDER BY createDate DESC"
                        + " OFFSET ? ROWS "
                        + " FETCH FIRST 20 ROWS ONLY";

                ps = connect.prepareStatement(sql);
                ps.setInt(1, (index - 1) * 20);

                rs = ps.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    Float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    boolean status = rs.getBoolean("status");
                    String image = rs.getString("image");
                    String description = rs.getString("description");
                    Date createDate = rs.getDate("createDate");
                    int counter = rs.getInt("counter");
                    String categoryID = rs.getString("categoryID");

                    ProductDTO product = new ProductDTO(productID, productName, price, quantity, status, image, description, createDate, counter, categoryID);
                    list.add(product);

                }
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return list;
    }

    public ProductDTO getListProductByID(String id) throws SQLException {
        ProductDTO product=null;
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT productID, productName, price, quantity, status, image, description, createDate, counter, categoryID FROM tblProduct WHERE productID=?";
                ps = connect.prepareStatement(sql);
                ps.setString(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    Float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    boolean status = rs.getBoolean("status");
                    String image = rs.getString("image");
                    String description = rs.getString("description");
                    Date createDate = rs.getDate("createDate");
                    int counter = rs.getInt("counter");
                    String categoryID = rs.getString("categoryID");

                    product = new ProductDTO(productID, productName, price, quantity, status, image, description, createDate, counter, categoryID);
                }
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return product;
    }

    //truyền tham số index
    public List<ProductDTO> getListProductPaging(int index) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();

        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT productID, productName, price, quantity, status, image, description, createDate, counter, categoryID "
                        + " FROM tblProduct "
                        + " WHERE status='true' AND quantity>0"
                        + " ORDER BY createDate"
                        + " OFFSET ? ROWS "
                        + " FETCH FIRST 20 ROWS ONLY";

                ps = connect.prepareStatement(sql);
                ps.setInt(1, (index - 1) * 20);

                rs = ps.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    Float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    boolean status = rs.getBoolean("status");
                    String image = rs.getString("image");
                    String description = rs.getString("description");
                    Date createDate = rs.getDate("createDate");
                    int counter = rs.getInt("counter");
                    String categoryID = rs.getString("categoryID");

                    ProductDTO product = new ProductDTO(productID, productName, price, quantity, status, image, description, createDate, counter, categoryID);
                    list.add(product);

                }
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return list;
    }

    //cần truyền tham số
    public List<ProductDTO> getListProductByName(String name, int index) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();

        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT productID, productName, price, quantity, status, image, description, createDate, counter, categoryID "
                        + " FROM tblProduct "
                        + " WHERE productName like ? AND status='true' AND quantity>0"
                        + " ORDER BY createDate"
                        + " OFFSET ? ROWS "
                        + " FETCH FIRST 20 ROWS ONLY";

                ps = connect.prepareStatement(sql);

                ps.setString(1, "%" + name + "%");
                ps.setInt(2, (index - 1) * 20);

                rs = ps.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    Float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    boolean status = rs.getBoolean("status");
                    String image = rs.getString("image");
                    String description = rs.getString("description");
                    Date createDate = rs.getDate("createDate");
                    int counter = rs.getInt("counter");
                    String categoryID = rs.getString("categoryID");

                    ProductDTO product = new ProductDTO(productID, productName, price, quantity, status, image, description, createDate, counter, categoryID);
                    list.add(product);

                }
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return list;
    }

    public List<ProductDTO> getListProductByPrice(float fromMoney, float toMoney, int index) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT productID, productName, price, quantity, status, image, description, createDate, counter, categoryID "
                        + " FROM tblProduct "
                        + " WHERE price>=? AND price <=? AND status='true' AND quantity>0"
                        + " ORDER BY createDate"
                        + " OFFSET ? ROWS "
                        + " FETCH FIRST 20 ROWS ONLY";

                ps = connect.prepareStatement(sql);

                ps.setFloat(1, fromMoney);
                ps.setFloat(2, toMoney);
                ps.setInt(3, (index - 1) * 20);

                rs = ps.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    Float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    boolean status = rs.getBoolean("status");
                    String image = rs.getString("image");
                    String description = rs.getString("description");
                    Date createDate = rs.getDate("createDate");
                    int counter = rs.getInt("counter");
                    String categoryID = rs.getString("categoryID");

                    ProductDTO product = new ProductDTO(productID, productName, price, quantity, status, image, description, createDate, counter, categoryID);
                    list.add(product);
                }
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return list;
    }

    public List<CategoryDTO> getListCategory() throws SQLException {
        List<CategoryDTO> list = new ArrayList<>();
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT categoryID, categoryName FROM tblCategory";
                ps = connect.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("categoryID");
                    String name = rs.getString("categoryName");

                    CategoryDTO cate = new CategoryDTO(id, name);

                    list.add(cate);
                }
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return list;
    }

    public List<ProductDTO> getListProductByCategoryID(String ID, int index) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT productID, productName, price, quantity, status, image, description, createDate, counter, categoryID "
                        + " FROM tblProduct "
                        + " WHERE categoryID=? AND status='true' AND quantity>0"
                        + " ORDER BY createDate"
                        + " OFFSET ? ROWS "
                        + " FETCH FIRST 20 ROWS ONLY";

                ps = connect.prepareStatement(sql);

                ps.setString(1, ID);
                ps.setInt(2, (index - 1) * 20);

                rs = ps.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    Float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    boolean status = rs.getBoolean("status");
                    String image = rs.getString("image");
                    String description = rs.getString("description");
                    Date createDate = rs.getDate("createDate");
                    int counter = rs.getInt("counter");
                    String categoryID = rs.getString("categoryID");

                    ProductDTO product = new ProductDTO(productID, productName, price, quantity, status, image, description, createDate, counter, categoryID);
                    list.add(product);
                }
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return list;
    }

    //update product
    public int updateProduct(String name, String price, String quantity, String status, String image, String description, String category, String id) throws SQLException {
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "UPDATE tblProduct SET productName=?, price=?, quantity=?, status=?, image=?, description=?, categoryID=? WHERE productID=?";
                ps = connect.prepareStatement(sql);
                ps.setString(1, name);
                ps.setString(2, price);
                ps.setString(3, quantity);
                ps.setString(4, status);
                ps.setString(5, image);
                ps.setString(6, description);
                ps.setString(7, category);
                ps.setString(8, id);

                return ps.executeUpdate();
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return 0;
    }

    //check duplicate id
    public boolean checkDuplicate(String proID) throws SQLException {
        boolean result = false;//true là có trùng

//        String productID = null;

        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT productID FROM tblProduct WHERE productID=?";
                ps = connect.prepareStatement(sql);
                ps.setString(1, proID);
                rs = ps.executeQuery();
                if (rs.next()) {
                    result = true;
                }
            }
        } catch (Exception e) {

        } finally {
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
        return result;

    }

    //insert product
    //khi insert nhớ để ý vị trí
    public int insertProduct(ProductDTO product) throws SQLException {
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "INSERT INTO tblProduct(productID,productName,price,quantity,status,image,description,createDate,counter,categoryID) VALUES(?,?,?,?,?,?,?,?,?,?)";
                ps = connect.prepareStatement(sql);
                ps.setString(1, product.getProductID());
                ps.setString(2, product.getProductName());
                ps.setFloat(3, product.getPrice());
                ps.setInt(4, product.getQuantity());
                ps.setBoolean(5, product.isStatus());
                ps.setString(6, product.getImage());
                ps.setString(7, product.getDescription());
                ps.setTimestamp(8, new Timestamp(product.getCreateDate().getTime()));
                ps.setInt(9, 0);
                ps.setString(10, product.getCategoryID());

                return ps.executeUpdate();
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return 0;
    }

    //delete product
    public int deleteProductByID(String productID) throws SQLException {
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "UPDATE tblProduct SET status='False' WHERE productID=?";
                ps = connect.prepareStatement(sql);
                ps.setString(1, productID);

                return ps.executeUpdate();
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return 0;
    }
    
    public int getProductQuantityByID(String productID) throws SQLException{
        try{
            connect=DBUtils.getConnection();
            if(connect!=null){
                String sql="SELECT quantity FROM tblProduct WHERE productID=?";
                ps=connect.prepareStatement(sql);
                ps.setString(1, productID);
                rs=ps.executeQuery();
                if(rs.next()){
                    int price=rs.getInt("quantity");
                    
                    return price;
                }
            }
        }catch(Exception e){
            
        }finally{
            closeConnection();
        }
        return 0;
    }
}
