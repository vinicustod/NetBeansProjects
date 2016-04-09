package picture.data;

import picture.business.Picture;
import java.sql.*;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


public class PictureDB {

    public static void deleteProduct(Picture p) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        trans.begin();
        try {
            Picture product = em.merge(p);
            em.remove(product);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void insertProduct(Picture product) {
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

    public static Picture selectProduct(String code) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT p FROM Picture p "
                + "WHERE p.pictureId = :code";
        TypedQuery<Picture> q = em.createQuery(qString, Picture.class);
        q.setParameter("code", Long.parseLong(code));
        Picture result = null;
        try {
            result = q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }

        return (Picture) result;
    }

    public static Picture selectProduct(long productId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        return em.find(Picture.class, productId);
    }

    public static List<Picture> selectProductsSale() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT p from Picture p where p.sale = 1";
        
        TypedQuery<Picture> q = em.createQuery(qString, Picture.class);
        
        List<Picture> results = null;

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
    
    public static List<Picture> selectProducts() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT p from Picture p";
        
        TypedQuery<Picture> q = em.createQuery(qString, Picture.class);
        
        List<Picture> results = null;

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
//    public static void deleteProduct(Picture product) {
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        String query = "DELETE FROM Picture "
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
//    public static void insertProduct(Picture product) {
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
//    public static Picture selectProduct(String productCode) {
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        String query = "SELECT * FROM Picture "
//                + "WHERE ProductCode = ?";
//        try {
//            ps = connection.prepareStatement(query);
//            ps.setString(1, productCode);
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                Picture p = new Picture();
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
//    public static Picture selectProduct(long productID) {
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        String query = "SELECT * FROM Picture "
//                + "WHERE ProductID = ?";
//        try {
//            ps = connection.prepareStatement(query);
//            ps.setLong(1, productID);
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                Picture p = new Picture();
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
//        String query = "SELECT * FROM Picture";
//        try {
//            ps = connection.prepareStatement(query);
//            rs = ps.executeQuery();
//            ArrayList<Product> products = new ArrayList<>();
//            while (rs.next()) {
//                Picture p = new Picture();
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
