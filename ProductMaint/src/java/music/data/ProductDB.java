package music.data;

import java.sql.*;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import music.business.*;

public class ProductDB {

    public static void deleteProduct(Product p) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        trans.begin();
        try {
            Product product = em.merge(p);
            em.remove(product);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void insertProduct(Product product) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(product);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
    }

    public static Product selectProduct(String code) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT p FROM Product p "
                + "WHERE p.code = :code";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);
        q.setParameter("code", code);
        Product result = null;
        try {
            result = q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }

        return (Product) result;
    }

    public static Product selectProduct(long productId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        return em.find(Product.class, productId);
    }

    public static List<Product> selectProducts() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT p from Product p";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);
        List<Product> results = null;

        try {
            results = q.getResultList();
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }
        System.out.println("I will return");
        return results;
    }
//
//    public static void deleteProduct(Product product) {
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        String query = "DELETE FROM Product "
//                + "WHERE ProductCode = ?";
//        try {
//            System.out.println("here");
//            ps = connection.prepareStatement(query);
//            ps.setString(1, product.getCode());
//            ps.execute();
//        } catch (SQLException e) {
//            System.err.println(e);
//        } finally {
//            DBUtil.closeResultSet(rs);
//            DBUtil.closePreparedStatement(ps);
//            pool.freeConnection(connection);
//        }
//    }
//
//    public static void insertProduct(Product product) {
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        String query = "insert into product (ProductCode, ProductDescription, ProductPrice) "
//                + "values(?,?,?)";
//        try {
//            System.out.println("Insert");
//            ps = connection.prepareStatement(query);
//            ps.setString(1, product.getCode());
//            ps.setString(2, product.getDescription());
//            ps.setDouble(3, product.getPrice());
//            ps.execute();
//        } catch (SQLException e) {
//            System.err.println(e);
//        } finally {
//            DBUtil.closeResultSet(rs);
//            DBUtil.closePreparedStatement(ps);
//            pool.freeConnection(connection);
//        }
//    }
     //This method returns null if a product isn't found.
//    public static Product selectProduct(String productCode) {
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        String query = "SELECT * FROM Product "
//                + "WHERE ProductCode = ?";
//        try {
//            ps = connection.prepareStatement(query);
//            ps.setString(1, productCode);
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                Product p = new Product();
//                p.setId(rs.getLong("ProductID"));
//                p.setCode(rs.getString("ProductCode"));
//                p.setDescription(rs.getString("ProductDescription"));
//                p.setPrice(rs.getDouble("ProductPrice"));
//                return p;
//            } else {
//                return null;
//            }
//        } catch (SQLException e) {
//            System.err.println(e);
//            return null;
//        } finally {
//            DBUtil.closeResultSet(rs);
//            DBUtil.closePreparedStatement(ps);
//            pool.freeConnection(connection);
//        }
//    }
//
//    //This method returns null if a product isn't found.
//    public static Product selectProduct(long productID) {
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        String query = "SELECT * FROM Product "
//                + "WHERE ProductID = ?";
//        try {
//            ps = connection.prepareStatement(query);
//            ps.setLong(1, productID);
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                Product p = new Product();
//                p.setId(rs.getLong("ProductID"));
//                p.setCode(rs.getString("ProductCode"));
//                p.setDescription(rs.getString("ProductDescription"));
//                p.setPrice(rs.getDouble("ProductPrice"));
//                return p;
//            } else {
//                return null;
//            }
//        } catch (SQLException e) {
//            System.err.println(e);
//            return null;
//        } finally {
//            DBUtil.closeResultSet(rs);
//            DBUtil.closePreparedStatement(ps);
//            pool.freeConnection(connection);
//        }
//    }
//
//    //This method returns null if a product isn't found.
//    public static List<Product> selectProducts() {
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        String query = "SELECT * FROM Product";
//        try {
//            ps = connection.prepareStatement(query);
//            rs = ps.executeQuery();
//            ArrayList<Product> products = new ArrayList<>();
//            while (rs.next()) {
//                Product p = new Product();
//                p.setCode(rs.getString("ProductCode"));
//                p.setDescription(rs.getString("ProductDescription"));
//                p.setPrice(rs.getDouble("ProductPrice"));
//                products.add(p);
//            }
//            return products;
//        } catch (SQLException e) {
//            System.err.println(e);
//            return null;
//        } finally {
//            DBUtil.closeResultSet(rs);
//            DBUtil.closePreparedStatement(ps);
//            pool.freeConnection(connection);
//        }
//    }
}
