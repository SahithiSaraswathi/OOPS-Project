import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LaptopDAO{
    // Create
    public static void createLaptop(Laptop lp) {
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "insert into laptop values(?,?,?,?)";
        try (PreparedStatement stm = con.prepareStatement(SQL)) {
            stm.setInt(1, lp.getId());
            stm.setString(2, lp.getName());
            stm.setInt(3, lp.getPrice());
            stm.setString(4, lp.getAvailability());
            int rows_affected = stm.executeUpdate();
            System.out.println(" number of rows created are ." + rows_affected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static List<Laptop> getAllLaptops() {
        List<Laptop> laptops = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "select * from laptop";
        try (PreparedStatement stm = con.prepareStatement(SQL)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Laptop lp = new Laptop(rs.getInt("id"), rs.getString("name"), rs.getInt("price"),
                        rs.getString("Availability"));
                laptops.add(lp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return laptops;
    }
    public static List<Laptop> getLaptopByName(String name) {
        List<Laptop> laptops = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "select * from laptop where name = ?";
        try (PreparedStatement stm = con.prepareStatement(SQL)) {
            stm.setString(1, name);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Laptop lp = new Laptop(rs.getInt("id"), rs.getString("name"), rs.getInt("price"),
                        rs.getString("availability"));
                laptops.add(lp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(laptops.size() + " rows found");
        return laptops;
    }
    public static List<Laptop> getLaptop(int id) {
        List<Laptop> laptops = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "select * from laptop where id = ?";
        try (PreparedStatement stm = con.prepareStatement(SQL)) {
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Laptop lp = new Laptop(rs.getInt("id"), rs.getString("name"), rs.getInt("price"),
                        rs.getString("availability"));
                laptops.add(lp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(laptops.size() + " rows found");
        return laptops;
    }
    public static List<Laptop> getLaptop(String name) {
        List<Laptop> laptops = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "select * from laptop where name = ?";
        try (PreparedStatement stm = con.prepareStatement(SQL)) {
            stm.setString(1,name);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Laptop lp = new Laptop(rs.getInt("id"), rs.getString("name"), rs.getInt("price"),
                        rs.getString("availability"));
                laptops.add(lp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(laptops.size() + " rows found");
        return laptops;
    }
    public static void updateLaptop(Laptop lp) {
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "update laptop set name=?, price=?,availability=? where id=?";
        try (PreparedStatement stm = con.prepareStatement(SQL)) {
            stm.setInt(4, lp.getId());
            stm.setString(1, lp.getName());
            stm.setInt(2, lp.getPrice());
            stm.setString(3, lp.getAvailability());
            int rows_affected = stm.executeUpdate();
            System.out.println(" number of rows uppdated are ." + rows_affected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteLaptop(int id) {
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "delete from laptop where id = ?";
        try (PreparedStatement stm = con.prepareStatement(SQL)) {
            stm.setInt(1, id);
            int rows_affected = stm.executeUpdate();
            System.out.println(" number of rows deleted are ." + rows_affected);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteLaptop(String name) {
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "delete from laptop where name= ?";
        try (PreparedStatement stm = con.prepareStatement(SQL)) {
            stm.setString(1, name);
            int rows_affected = stm.executeUpdate();
            System.out.println(" number of rows deleted are ." + rows_affected);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static List<Laptop> getLaptopBypriceLessthan(int price) {
        List<Laptop> laptops = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "select * from laptop where price<?";
        try (PreparedStatement stm = con.prepareStatement(SQL)) {
            stm.setInt(1, price);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
            Laptop lp = new Laptop(rs.getInt("id"), rs.getString("name"),
            rs.getInt("price"),
            rs.getString("availability"));
            laptops.add(lp);
        }
     } catch (SQLException e) {
            e.printStackTrace();
        }
        return laptops;
    }
    public static List<Laptop> getLaptopBypriceGreaterthan(int price) {
        List<Laptop> laptops = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "select * from laptop where price>?";
        try (PreparedStatement stm = con.prepareStatement(SQL)) {
            stm.setInt(1, price);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
            Laptop lp = new Laptop(rs.getInt("id"), rs.getString("name"),
            rs.getInt("price"),
            rs.getString("availability"));
            laptops.add(lp);
        }
     } catch (SQLException e) {
            e.printStackTrace();
        }
        return laptops;
    }
    public static List<Laptop> getLaptopByprice(int price) {
    List<Laptop> laptops = new ArrayList<>();
    Connection con = ConnectionFactory.getConnection();
    final String SQL = "select * from laptop where price=?";
    try (PreparedStatement stm = con.prepareStatement(SQL)) {
    stm.setInt(1, price);
    ResultSet rs = stm.executeQuery();
    while (rs.next()) {
    Laptop lp = new Laptop(rs.getInt("id"), rs.getString("name"),
    rs.getInt("price"),
    rs.getString("availability"));
    laptops.add(lp);
    }
    } catch (SQLException e) {
    e.printStackTrace();
    }
    System.out.println(laptops.size() + " laptops found for this price");
    return laptops;
}
    public static List<Laptop> getLaptopBetweenprice(int price1,int price2) {
        List<Laptop> laptops = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "select * from laptop where price between ? and ?";
        try (PreparedStatement stm = con.prepareStatement(SQL)) {
            stm.setInt(1, price1);
            stm.setInt(2, price2);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Laptop lp = new Laptop(rs.getInt("id"), rs.getString("name"), rs.getInt("price"),
                        rs.getString("availability"));
                laptops.add(lp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(laptops.size() + " rows found");
        return laptops;
    }
    public static List<Laptop> getbyAvailability() {
        List<Laptop> laptops = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "select * from laptop where availability = ?";
        try (PreparedStatement stm = con.prepareStatement(SQL)) {
            stm.setString(1, "yes");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Laptop lp = new Laptop(rs.getInt("id"), rs.getString("name"), rs.getInt("price"),
                        rs.getString("availability"));
                laptops.add(lp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(laptops.size() + " laptops found in available");
        return laptops;
    }

    public static void getAvgPrice(String name) {
        Connection con = ConnectionFactory.getConnection();
        final String SQL1 = "SELECT AVG(price) AS AveragePrice FROM laptop where name like ? ";
        try (PreparedStatement stm = con.prepareStatement(SQL1)) {
            stm.setString(1, name);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                System.out.println("avg price is " + rs.getFloat(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public static void DeleteAll() {
            Connection con = ConnectionFactory.getConnection();
            final String SQL = "truncate table laptop;";
            try (PreparedStatement stm = con.prepareStatement(SQL)) {
                stm.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public static List<Laptop> SortByPrice() {
            List<Laptop> laptops = new ArrayList<>();
            Connection con = ConnectionFactory.getConnection();
            final String SQL = "SELECT * FROM laptop ORDER BY price;";
            try (PreparedStatement stm = con.prepareStatement(SQL)) {
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    Laptop lp = new Laptop(rs.getInt("id"), rs.getString("name"), rs.getInt("price"), rs.getString("availability"));
                    laptops.add(lp);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return laptops;
        }    
}
   