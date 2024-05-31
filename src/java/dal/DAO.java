package dal;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import model.CategoryDBO;
import model.FeedBackDBO;
import model.OrderDBO;
import model.OrderDetailDBO;
import model.ProductDBO;
import model.SupplierDBO;
import model.UserDBO;
import model.VoucherDBO;

public class DAO extends DBContext {
    //function of shop/home

    public ArrayList<ProductDBO> getAllProducts() {
        String sql = "select * from product as p join Categories as c on c.category_id =p.category_id join Suppliers as s on s.supplier_id=p.supplier_id";
        ArrayList<ProductDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                CategoryDBO c = new CategoryDBO(r.getInt(11), r.getString(12));
                SupplierDBO s = new SupplierDBO(r.getInt(13), r.getString(14));
                ProductDBO pro = new ProductDBO(r.getInt(1), r.getString(2), r.getString(3), r.getDouble(4), r.getInt(5), r.getString(6), r.getDouble(7), c, s, r.getInt(10));
                list.add(pro);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;

    }

    public ArrayList<SupplierDBO> getAllSuppliers() {
        String sql = "Select * from suppliers";
        ArrayList<SupplierDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                SupplierDBO sup = new SupplierDBO(r.getInt(1), r.getString(2));
                list.add(sup);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;

    }

    public ArrayList<CategoryDBO> getAllCategories() {
        String sql = "Select * from categories";
        ArrayList<CategoryDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                CategoryDBO cate = new CategoryDBO(r.getInt(1), r.getString(2));
                list.add(cate);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;

    }

    public ArrayList<ProductDBO> getNewProducts() {
        String sql = "	Select  * from product as p join Categories as c on c.category_id =p.category_id join Suppliers as s on s.supplier_id=p.supplier_id order by  product_id desc";
        ArrayList<ProductDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                CategoryDBO c = new CategoryDBO(r.getInt(11), r.getString(12));
                SupplierDBO s = new SupplierDBO(r.getInt(13), r.getString(14));
                ProductDBO pro = new ProductDBO(r.getInt(1), r.getString(2), r.getString(3), r.getDouble(4), r.getInt(5), r.getString(6), r.getDouble(7), c, s, r.getInt(10));
                list.add(pro);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;

    }

    public ArrayList<ProductDBO> getSaleProducts() {
        String sql = "select * from Product as p join Categories as c on c.category_id =p.category_id join Suppliers as s on s.supplier_id=p.supplier_id where discount>0 order by discount desc";
        ArrayList<ProductDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                CategoryDBO c = new CategoryDBO(r.getInt(11), r.getString(12));
                SupplierDBO s = new SupplierDBO(r.getInt(13), r.getString(14));
                ProductDBO pro = new ProductDBO(r.getInt(1), r.getString(2), r.getString(3), r.getDouble(4), r.getInt(5), r.getString(6), r.getDouble(7), c, s, r.getInt(10));
                list.add(pro);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;

    }

    public ArrayList<ProductDBO> getProductByCategory(int category) {
        String sql = "select * from Product as p  join Categories as c on c.category_id =p.category_id join Suppliers as s on s.supplier_id=p.supplier_id where c.category_id=?  ";
        ArrayList<ProductDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, category);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                CategoryDBO c = new CategoryDBO(r.getInt(11), r.getString(12));
                SupplierDBO s = new SupplierDBO(r.getInt(13), r.getString(14));
                ProductDBO pro = new ProductDBO(r.getInt(1), r.getString(2), r.getString(3), r.getDouble(4), r.getInt(5), r.getString(6), r.getDouble(7), c, s, r.getInt(10));
                list.add(pro);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;

    }

    public ArrayList<ProductDBO> pageProduct(ArrayList<ProductDBO> listProduct, int index) {
        ArrayList<ProductDBO> list = new ArrayList<>();

        for (int i = (index - 1) * 12; i < 12 * index; i++) {
            if (i < listProduct.size()) {
                list.add(listProduct.get(i));
            }
        }

        return list;

    }
//    public ArrayList<ProductDBO> getProductBySupplier(int index){
//        String sql = "select * from Product as p  join Categories as c on c.category_id =p.category_id join Suppliers as s on s.supplier_id=p.supplier_id where s.supplier_id=?  order by product_id offset ? rows fetch next 12 rows only";
//        ArrayList<ProductDBO> list = new ArrayList<>();
//        try {
//            PreparedStatement p = connection.prepareStatement(sql);
//            p.setInt(1, (index - 1) * 12);
//            ResultSet r = p.executeQuery();
//            while (r.next()) {
//                CategoryDBO c = new CategoryDBO(r.getInt(11), r.getString(12));
//                SupplierDBO s = new SupplierDBO(r.getInt(13), r.getString(14));
//                ProductDBO pro = new ProductDBO(r.getInt(1), r.getString(2), r.getString(3), r.getDouble(4), r.getInt(5), r.getString(6), r.getDouble(7), c, s, r.getInt(10));
//                list.add(pro);
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return list;
//    }

    public ArrayList<ProductDBO> getProductBySupplier(int category) {
        String sql = "select * from Product as p  join Categories as c on c.category_id =p.category_id join Suppliers as s on s.supplier_id=p.supplier_id where s.supplier_id=?";
        ArrayList<ProductDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, category);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                CategoryDBO c = new CategoryDBO(r.getInt(11), r.getString(12));
                SupplierDBO s = new SupplierDBO(r.getInt(13), r.getString(14));
                ProductDBO pro = new ProductDBO(r.getInt(1), r.getString(2), r.getString(3), r.getDouble(4), r.getInt(5), r.getString(6), r.getDouble(7), c, s, r.getInt(10));
                list.add(pro);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;

    }

    public ArrayList<ProductDBO> getRelatedProducts(ProductDBO pr) {
        String sql = "select * from Product as p  join Categories as c on c.category_id =p.category_id join Suppliers as s on s.supplier_id=p.supplier_id where c.category_id=? and product_price <? and product_id!=? and product_quantity >0 order by product_price desc";
        ArrayList<ProductDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, pr.getCategory().getId());
            p.setDouble(2, pr.getPrice() + 2000000);
            p.setInt(3, pr.getId());
            ResultSet r = p.executeQuery();
            while (r.next()) {
                CategoryDBO c = new CategoryDBO(r.getInt(11), r.getString(12));
                SupplierDBO s = new SupplierDBO(r.getInt(13), r.getString(14));
                ProductDBO pro = new ProductDBO(r.getInt(1), r.getString(2), r.getString(3), r.getDouble(4), r.getInt(5), r.getString(6), r.getDouble(7), c, s, r.getInt(10));
                list.add(pro);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;

    }

//    public ArrayList<ProductDBO> getProductByPrice(int idPrice) {
//        String sql;
//        if (idPrice == 1) {
//            sql = "select * from Product as p  join Categories as c on c.category_id =p.category_id join Suppliers as s on s.supplier_id=p.supplier_id where product_price<5000000";
//        } else if (idPrice == 2) {
//            sql = "select * from Product as p  join Categories as c on c.category_id =p.category_id join Suppliers as s on s.supplier_id=p.supplier_id where product_price >=5000000 and product_price<=10000000";
//        } else if (idPrice == 3) {
//            sql = "select * from Product as p  join Categories as c on c.category_id =p.category_id join Suppliers as s on s.supplier_id=p.supplier_id where product_price >=10000000 and product_price<=15000000";
//        } else {
//            sql = "select * from Product as p  join Categories as c on c.category_id =p.category_id join Suppliers as s on s.supplier_id=p.supplier_id where product_price >20000000";
//        }
//        ArrayList<ProductDBO> list = new ArrayList<>();
//        try {
//            PreparedStatement p = connection.prepareStatement(sql);
//
//            ResultSet r = p.executeQuery();
//            while (r.next()) {
//                CategoryDBO c = new CategoryDBO(r.getInt(11), r.getString(12));
//                SupplierDBO s = new SupplierDBO(r.getInt(13), r.getString(14));
//                ProductDBO pro = new ProductDBO(r.getInt(1), r.getString(2), r.getString(3), r.getDouble(4), r.getInt(5), r.getString(6), r.getDouble(7), c, s, r.getInt(10));
//                list.add(pro);
//            }
//        } catch (SQLException e) {
//            System.err.println(e);
//        }
//        return list;
//
//    }
    public ArrayList<ProductDBO> findProductByName(String productName) {
        String sql = "select * from Product as p  join Categories as c on c.category_id =p.category_id join Suppliers as s on s.supplier_id=p.supplier_id where product_name like ?";
        ArrayList<ProductDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, "%" + productName + "%");
            ResultSet r = p.executeQuery();
            while (r.next()) {
                CategoryDBO c = new CategoryDBO(r.getInt(11), r.getString(12));
                SupplierDBO s = new SupplierDBO(r.getInt(13), r.getString(14));
                ProductDBO pro = new ProductDBO(r.getInt(1), r.getString(2), r.getString(3), r.getDouble(4), r.getInt(5), r.getString(6), r.getDouble(7), c, s, r.getInt(10));
                list.add(pro);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;

    }

    public ProductDBO getProductById(int idProduct) {
        String sql = "select * from Product as p  join Categories as c on c.category_id =p.category_id join Suppliers as s on s.supplier_id=p.supplier_id where product_id=?";
        ProductDBO product = null;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, idProduct);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                CategoryDBO c = new CategoryDBO(r.getInt(11), r.getString(12));
                SupplierDBO s = new SupplierDBO(r.getInt(13), r.getString(14));
                product = new ProductDBO(r.getInt(1), r.getString(2), r.getString(3), r.getDouble(4), r.getInt(5), r.getString(6), r.getDouble(7), c, s, r.getInt(10));

            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return product;

    }

    //end shop/home
    //function of login 
    public UserDBO getUser(int id) {
        String sql = "select * from Users where user_id=?";
        UserDBO user = null;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, id);

            ResultSet r = p.executeQuery();
            if (r.next()) {
                user = new UserDBO(r.getInt(1), r.getString(2), r.getString(3), r.getString(4),
                        r.getString(5), r.getDate(6), r.getInt(7), r.getString(8), r.getTimestamp(9), r.getString(11), r.getInt(10));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return user;
    }

    public int updatePasswordUser(int id, String password) {
        String sql = "UPDATE Users\n"
                + " SET password=?\n"
                + " WHERE user_id=?;";
        int n = 0;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, password);
            p.setInt(2, id);
            n = p.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    public int updateImgUser(int id, String img) {
        String sql = "UPDATE Users\n"
                + " SET avatar=?\n"
                + " WHERE user_id=?;";
        int n = 0;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, img);
            p.setInt(2, id);
            n = p.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    public int updateInfoUser(int id, String name, String email, String dob, String phone) {
        String sql = "UPDATE Users\n"
                + " SET [name]=?,email=?,birthdate=?,phone=?\n"
                + " WHERE user_id=?;";

        int n = 0;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, name);
            p.setString(2, email);
            p.setString(3, dob);
            p.setString(4, phone);
            p.setInt(5, id);

            n = p.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    public UserDBO checkLogin(String name, String pass) {
        String sql = "select * from Users where username=? and [password]=?";
        UserDBO user = null;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, name);
            p.setString(2, pass);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                user = new UserDBO(r.getInt(1), r.getString(2), r.getString(3), r.getString(4),
                        r.getString(5), r.getDate(6), r.getInt(7), r.getString(8), r.getTimestamp(9), r.getString(11), r.getInt(10));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return user;
    }

    public UserDBO checkEmailExist(String email) {
        String sql = "select * from Users where email=?";
        UserDBO user = null;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, email);

            ResultSet r = p.executeQuery();
            if (r.next()) {
                user = new UserDBO(r.getInt(1), r.getString(2), r.getString(3), r.getString(4),
                        r.getString(5), r.getDate(6), r.getInt(7), r.getString(8), r.getTimestamp(9), r.getString(11), r.getInt(10));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return user;
    }

    public int signup(String username, String pass, String email) {
        String sql = "insert into Users(username,[password],email)\n"
                + "values (?,?,?)";
        int n = 0;

        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, username);
            p.setString(2, pass);
            p.setString(3, email);
            n = p.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    public UserDBO checkUser(String name) {
        String sql = "select * from Users where username=?";
        UserDBO user = null;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, name);

            ResultSet r = p.executeQuery();
            if (r.next()) {
                user = new UserDBO(r.getInt(1), r.getString(2), r.getString(3), r.getString(4),
                        r.getString(5), r.getDate(6), r.getInt(7), r.getString(8), r.getTimestamp(9), r.getString(11), r.getInt(10));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return user;

    }

    public UserDBO getUserById(int id) {
        String sql = "select * from Users where user_id=?";
        UserDBO user = null;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, id);

            ResultSet r = p.executeQuery();
            if (r.next()) {
                user = new UserDBO(r.getInt(1), r.getString(2), r.getString(3), r.getString(4),
                        r.getString(5), r.getDate(6), r.getInt(7), r.getString(8), r.getTimestamp(9), r.getString(11), r.getInt(10));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return user;

    }

    //end of login
    //add product 
    public int addProduct(String name, String des, double price, int quantity, String img, double discount, int cateId, int supId) {
        String sql = "insert into Product (product_name,product_description,product_price,product_quantity,img_url,discount,category_id,supplier_id)\n"
                + "values(?,?,?,?,?,?,?,?)";
        int n = 0;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, name);
            p.setString(2, des);
            p.setDouble(3, price);
            p.setInt(4, quantity);
            p.setString(5, img);
            p.setDouble(6, discount);
            p.setInt(7, cateId);
            p.setInt(8, supId);
            n = p.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;

    }

    public int updateProduct(int id, String name, String des, double price, int quantity, String img, double discount, int cateId, int supId, int status) {
        String sql = "update product "
                + "set product_name=?, product_description=?, product_price=?, "
                + "product_quantity=?, img_url=?, discount=?, category_id=?, supplier_id=?, status=? where product_id=?";

        int n = 0;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, name);
            p.setString(2, des);
            p.setDouble(3, price);
            p.setInt(4, quantity);
            p.setString(5, img);
            p.setDouble(6, discount);
            p.setInt(7, cateId);
            p.setInt(8, supId);
            p.setInt(9, status);
            p.setInt(10, id);
            n = p.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;

    }

    public int deleteProduct(int proId) {
        String sql = "delete from product where product_id=?";
        int n = 0;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, proId);
            n = p.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;

    }

    public boolean productExist(String name) {
        String sql = "select * from product where product_name=?";
        boolean check = false;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, name);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                check = true;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return check;
    }

    public int addCategory(String cateName) {
        String sql = "insert into Categories values(?)";
        int n = 0;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, cateName);
            n = p.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    public boolean categoryExist(String name) {
        String sql = "Select * from  Categories where category_name=?";
        boolean check = false;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, name);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                check = true;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return check;
    }

    public int addSupplier(String supName) {
        String sql = "insert into Suppliers values(?)";
        int n = 0;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, supName);
            n = p.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    public boolean supplierExist(String name) {
        String sql = "Select * from  Suppliers where supplier_name=?";
        boolean check = false;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, name);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                check = true;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return check;
    }

    public ArrayList<ProductDBO> getAllProductPaggingList(int index) {
        String sql = "select * from Product  as p  join Categories as c on c.category_id =p.category_id join Suppliers as s on s.supplier_id=p.supplier_id  order by product_id offset ? rows fetch next 12 rows only";
        ArrayList<ProductDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, (index - 1) * 12);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                CategoryDBO c = new CategoryDBO(r.getInt(11), r.getString(12));
                SupplierDBO s = new SupplierDBO(r.getInt(13), r.getString(14));
                ProductDBO pro = new ProductDBO(r.getInt(1), r.getString(2), r.getString(3), r.getDouble(4), r.getInt(5), r.getString(6), r.getDouble(7), c, s, r.getInt(10));
                list.add(pro);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<ProductDBO> getProductByCategoryPaggingList(int idCate, int index) {
        String sql = "select * from Product  as p  join Categories as c on c.category_id =p.category_id join Suppliers as s on s.supplier_id=p.supplier_id  where p.category_id=? order by product_id offset ? rows fetch next 12 rows only";
        ArrayList<ProductDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, idCate);
            p.setInt(2, (index - 1) * 12);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                CategoryDBO c = new CategoryDBO(r.getInt(11), r.getString(12));
                SupplierDBO s = new SupplierDBO(r.getInt(13), r.getString(14));
                ProductDBO pro = new ProductDBO(r.getInt(1), r.getString(2), r.getString(3), r.getDouble(4), r.getInt(5), r.getString(6), r.getDouble(7), c, s, r.getInt(10));
                list.add(pro);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<ProductDBO> getProductBySupplierPaggingList(int idSup, int index) {
        String sql = "select * from Product  as p  join Categories as c on c.category_id =p.category_id join Suppliers as s on s.supplier_id=p.supplier_id  where s.supplier_id=? order by product_id offset ? rows fetch next 12 rows only";
        ArrayList<ProductDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, idSup);
            p.setInt(2, (index - 1) * 12);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                CategoryDBO c = new CategoryDBO(r.getInt(11), r.getString(12));
                SupplierDBO s = new SupplierDBO(r.getInt(13), r.getString(14));
                ProductDBO pro = new ProductDBO(r.getInt(1), r.getString(2), r.getString(3), r.getDouble(4), r.getInt(5), r.getString(6), r.getDouble(7), c, s, r.getInt(10));
                list.add(pro);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public String getCateFilter(ArrayList<Integer> idCateList) {

        StringBuilder s = new StringBuilder();

        String sql = "SELECT p.product_id, p.product_name, p.product_description, p.product_price, p.product_quantity,\n"
                + "             p.img_url, p.discount, p.category_id, c.category_name,\n"
                + "             p.supplier_id, s.supplier_name, p.status\n"
                + "      FROM product AS p\n"
                + "      JOIN Categories AS c ON c.category_id = p.category_id\n"
                + "      JOIN Suppliers AS s ON s.supplier_id = p.supplier_id \n";
        s.append(sql);
        if (idCateList.get(0) != 0) {

            s.append("WHERE c.category_id IN (");

            for (int i = 0; i < idCateList.size(); i++) {
                s.append(idCateList.get(i));
                if (i < idCateList.size() - 1) {
                    s.append(",");

                }
            }
            s.append(") ");
        }
        return s.toString();
    }

    public String getBrandFilter(ArrayList<Integer> idSupList, String sqlBefore) {
        StringBuilder s = new StringBuilder();

        String sql = "SELECT a.product_id, a.product_name, a.product_description, a.product_price, a.product_quantity,\n"
                + "       a.img_url, a.discount, a.category_id, a.category_name,\n"
                + "       a.supplier_id, a.supplier_name, a.status\n"
                + "FROM (" + sqlBefore + " ) as a ";
        s.append(sql);

        if (idSupList.get(0) != 0) {

            s.append("where a.supplier_id in (");

            for (int i = 0; i < idSupList.size(); i++) {
                s.append(idSupList.get(i));
                if (i < idSupList.size() - 1) {
                    s.append(",");

                }
            }
            s.append(")");

        }
        return s.toString();
    }

    public String getPriceFilter(ArrayList<Integer> idPrice, String sqlBefore) {
        StringBuilder s = new StringBuilder();
//        String d = "Order by ";
//        switch (order) {
//            case 1:
//                d += "a.product_id";
//                break;
//            case 2:
//                d += "a.product_id desc";
//                break;
//            case 3:
//                d += "a.product_price asc";
//                break;
//            default:
//                d += "a.product_price desc";
//        }
        String sql = "select * from (" + sqlBefore + ") as a ";
        s.append(sql);
        if (idPrice.get(0) != 0) {
            s.append("where ");

            for (int i = 0; i < idPrice.size(); i++) {
                if (idPrice.get(i) == 1) {
                    s.append("(a.product_price-(a.product_price*a.discount) < 5000000)");
                } else if (idPrice.get(i) == 2) {
                    s.append("(a.product_price-(a.product_price*a.discount) > 5000000 and a.product_price-(a.product_price*a.discount) < 10000000)");
                } else if (idPrice.get(i) == 3) {
                    s.append("(a.product_price-(a.product_price*a.discount) > 10000000 and a.product_price-(a.product_price*a.discount) < 20000000)");
                } else {
                    s.append("(a.product_price-(a.product_price*a.discount) > 20000000)");
                }

                if (i < idPrice.size() - 1) {
                    s.append(" or ");
                }
            }
        }
        return s.toString();
    }

    public ArrayList<ProductDBO> getListFilter(ArrayList<Integer> idCateList, ArrayList<Integer> idSupList, ArrayList<Integer> priceList) {
        ArrayList<ProductDBO> list = new ArrayList<>();
        String s1 = getCateFilter(idCateList);
        String s2 = getBrandFilter(idSupList, s1);
        String s3 = getPriceFilter(priceList, s2);
        try {
            PreparedStatement p = connection.prepareStatement(s3);
            ResultSet r = p.executeQuery();

            while (r.next()) {
                CategoryDBO c = new CategoryDBO(r.getInt(8), r.getString(9));
                SupplierDBO s = new SupplierDBO(r.getInt(10), r.getString(11));
                ProductDBO pro = new ProductDBO(r.getInt(1), r.getString(2), r.getString(3), r.getDouble(4), r.getInt(5), r.getString(6), r.getDouble(7), c, s, r.getInt(12));
                list.add(pro);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;

    }

    public ArrayList<ProductDBO> getListFilterPagging(ArrayList<Integer> idCateList, ArrayList<Integer> idSupList, ArrayList<Integer> priceList, int idPage) {
        ArrayList<ProductDBO> list = new ArrayList<>();
        String s1 = getCateFilter(idCateList);
        String s2 = getBrandFilter(idSupList, s1);
        String s3 = getPriceFilter(priceList, s2);
        try {
            PreparedStatement p = connection.prepareStatement(s3 + " order by product_id offset ? rows fetch next 12 rows only");
            p.setInt(1, idPage);
            ResultSet r = p.executeQuery();

            while (r.next()) {
                CategoryDBO c = new CategoryDBO(r.getInt(8), r.getString(9));
                SupplierDBO s = new SupplierDBO(r.getInt(10), r.getString(11));
                ProductDBO pro = new ProductDBO(r.getInt(1), r.getString(2), r.getString(3), r.getDouble(4), r.getInt(5), r.getString(6), r.getDouble(7), c, s, r.getInt(12));
                list.add(pro);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;

    }

    public VoucherDBO checkVoucher(String v) {
        String sql = "select * from DiscountCodes where code = ?";
        VoucherDBO voucher = null;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, v);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                voucher = new VoucherDBO(r.getString(1), r.getDouble(2), r.getDate(3), r.getDate(4));
            }

        } catch (SQLException e) {
        }
        return voucher;
    }
 public ArrayList<OrderDBO> getAllOrder() {
        String sql = "select * from orders as o join Users as u on u.user_id =o.user_id ";
        ArrayList<OrderDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
          
            ResultSet r = p.executeQuery();
            while (r.next()) {
                ArrayList<OrderDetailDBO> listDetails = getlistOrderDetailByOrderId(r.getInt(1));
                UserDBO user = new UserDBO(r.getInt(10), r.getString(11), r.getString(12), r.getString(13), r.getString(14), r.getDate(15), r.getInt(16), r.getString(17), r.getTimestamp(18), r.getString(20), r.getInt(19));
                OrderDBO o = new OrderDBO(r.getInt(1), r.getDate(3), r.getDouble(4), r.getInt(9), r.getString(5), r.getString(6), r.getString(7), r.getString(8), user, listDetails);
                list.add(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    public ArrayList<OrderDetailDBO> getlistOrderDetailByOrderId(int id) {
        String sql = "select * from orders as o join order_details as od on od.order_id=o.order_id join Product as p on p.product_id =od.product_id join Categories as c on p.category_id=c.category_id join Suppliers as s on s.supplier_id=p.supplier_id where o.order_id=?";
        ArrayList<OrderDetailDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, id);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                CategoryDBO category = new CategoryDBO(r.getInt(25), r.getString(26));
                SupplierDBO supplier = new SupplierDBO(r.getInt(27), r.getString(28));
                ProductDBO product = new ProductDBO(r.getInt(15), r.getString(16), r.getString(17), r.getDouble(18), r.getInt(19), r.getString(20), r.getDouble(21), category, supplier, r.getInt(24));
                OrderDetailDBO o = new OrderDetailDBO(r.getInt(10), r.getInt(13), r.getDouble(14), product);
                list.add(o);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<OrderDBO> getlistOrderByUserId(int id) {
        String sql = "select * from orders as o join Users as u on u.user_id =o.user_id where u.user_id=?";
        ArrayList<OrderDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, id);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                ArrayList<OrderDetailDBO> listDetails = getlistOrderDetailByOrderId(r.getInt(1));
                UserDBO user = new UserDBO(r.getInt(10), r.getString(11), r.getString(12), r.getString(13), r.getString(14), r.getDate(15), r.getInt(16), r.getString(17), r.getTimestamp(18), r.getString(20), r.getInt(19));
                OrderDBO o = new OrderDBO(r.getInt(1), r.getDate(3), r.getDouble(4), r.getInt(9), r.getString(5), r.getString(6), r.getString(7), r.getString(8), user, listDetails);
                list.add(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public int addReviewProduct(int idUser, int idPro, int rating, String comment) {
        String sql = "insert into product_reviews (product_id,user_id,rating,comment)\n"
                + " values(?,?,?,?);";
        int n = 0;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, idPro);
            p.setInt(2, idUser);
            p.setInt(3, rating);
            p.setString(4, comment);
            n = p.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    public ArrayList<FeedBackDBO> getAllFeedBack() {
        String sql = "select * from product_reviews";
        ArrayList<FeedBackDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);

            ResultSet r = p.executeQuery();
            while (r.next()) {
                FeedBackDBO f = new FeedBackDBO(r.getInt(1), r.getInt(2), r.getInt(3), r.getInt(4), r.getString(5), r.getDate(6));
                list.add(f);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<FeedBackDBO> getFeedBackByIdProduct(int id) {
        String sql = "select * from product_reviews where product_id=?";
        ArrayList<FeedBackDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, id);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                FeedBackDBO f = new FeedBackDBO(r.getInt(1), r.getInt(2), r.getInt(3), r.getInt(4), r.getString(5), r.getDate(6));
                list.add(f);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<UserDBO> getAllUsers() {
        String sql = "select * from Users";
        ArrayList<UserDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);

            ResultSet r = p.executeQuery();
            while (r.next()) {
                UserDBO user = new UserDBO(r.getInt(1), r.getString(2), r.getString(3), r.getString(4),
                        r.getString(5), r.getDate(6), r.getInt(7), r.getString(8), r.getTimestamp(9), r.getString(11), r.getInt(10));
                list.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public int lockUser(int id) {
        int n = 0;
        String sql = "update Users\n"
                + " set status=0 where user_id=?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, id);
            n = p.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    private int deleteOrderDetailByOrderId(int id) {
        int n = 0;
        String sql = "delete from order_details where order_id=?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, id);
            n = p.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    private int deleteReviewByIdUser(int id) {
        int n = 0;
        String sql = "delete from product_reviews where user_id=?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, id);
            n = p.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    private ArrayList<Integer> getOrderIdByUserId(int id) {
        String sql = "select order_id from orders where user_id=?";
        ArrayList<Integer> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, id);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                list.add(r.getInt(1));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    private int deleteOrder(int id) {
        int n = 0;
        String sql = "delete from orders where user_id=?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, id);
            n = p.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    public int deleteUser(int id) {
        deleteReviewByIdUser(id);
        ArrayList<Integer> list = getOrderIdByUserId(id);
        for (int a : list) {
            deleteOrderDetailByOrderId(a);
        }

        deleteOrder(id);

        int n = 0;
        String sql = "delete from users where user_id=?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, id);
            n = p.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        System.out.println(dao.getOrderIdByUserId(15));
        System.out.println(dao.deleteUser(15));

    }

}
