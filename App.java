import java.io.*;
import java.util.List;
public class App {
    public static void help() {
        System.out.println("--------------------Commands for Mini Project---------------------");
        System.out.println(" LOAD CSV               : -load");
        System.out.println(" CREATE LAPTOP          : -create id name price availability");
        System.out.println(" PRINT All              : -printAll  ");
        System.out.println(" UPDATE BY  ID          : -update id name price availability ");
        System.out.println(" DELETE BY  ID          : -delete_id id");
        System.out.println(" DELETE BY  NAME        : -delete_name name");
        System.out.println(" DELETE ALL (Truncate)  : -deleteAll");
        System.out.println(" SEARCH BY NAME         : -gtLaptop_name name");
        System.out.println(" SEARCH BY ID           : -gtLaptop_id id");
        System.out.println(" SEARCH BY PRICE        : -gtLaptop_price price");
        System.out.println(" GET LAPTOP < PRICE     : -lstPrice price");
        System.out.println(" GET LAPTOP > PRICE     : -grtPrice price");
        System.out.println(" GET LAPTOP IN RANGE    : -btwPrice price1 price2");
        System.out.println(" GET AVAILABILITY       : -gtAvail ");
        System.out.println(" AVERAGE                : -gtAvg name");
        System.out.println(" SORT BY PRICE          : -sort ");
        System.out.println(" For Help               : -h ");
    }
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("D:\\laptops.csv"));
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (args[0].equals("-load")) {
            try {
                BufferedReader reader = new BufferedReader(
                        new FileReader("D:\\laptops.csv"));
                String laptopLine;
                while ((laptopLine = reader.readLine()) != null) {
                    LaptopDAO.createLaptop(new Laptop(laptopLine));
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(args[0].equals("-create")){
            int id = Integer.valueOf(args[1]);
            String name = args[2];
            int price = Integer.valueOf(args[3]);
            String availability = args[4];
            Laptop lp = new Laptop(id, name, price, availability);
            LaptopDAO.createLaptop(lp);
            List<Laptop> allLaptops = LaptopDAO.getAllLaptops();
            allLaptops.forEach(System.out::println);
        }
        if (args[0].equals("-printAll")) {
            List<Laptop> allLaptops1 = LaptopDAO.getAllLaptops();
            allLaptops1.forEach(System.out::println);
        }
        if (args[0].equals("-update")) {
            int id = Integer.valueOf(args[1]);
            String name = args[2];
            int price = Integer.valueOf(args[3]);
            String availability = args[4];
            Laptop c1 = new Laptop(id, name, price, availability);

            LaptopDAO.updateLaptop(c1);
            List<Laptop> allLaptops1 = LaptopDAO.getAllLaptops();
            allLaptops1.forEach(System.out::println);
        }

        if (args[0].equals("-delete_id")) {
            LaptopDAO.deleteLaptop(Integer.valueOf(args[1]));
            List<Laptop> allLaptops = LaptopDAO.getAllLaptops();
            allLaptops.forEach(System.out::println);
        }

        if (args[0].equals("-delete_name")) {
            LaptopDAO.deleteLaptop(args[1]);
            List<Laptop> allLaptops = LaptopDAO.getAllLaptops();
            allLaptops.forEach(System.out::println);
        }
        if(args[0].equals("-deleteAll")){
            LaptopDAO.DeleteAll();
            System.out.println("Deleted Succesfully");
        }
        if (args[0].equals("-gtLaptop_name")) {
            List<Laptop> allLaptops = LaptopDAO.getLaptop(args[1]);
            allLaptops.forEach(System.out::println);
        }

        if (args[0].equals("-gtLaptop_id")) {
            List<Laptop> allLaptops = LaptopDAO.getLaptop(Integer.valueOf(args[1]));
            allLaptops.forEach(System.out::println);
        }

        if (args[0].equals("-gtLaptop_price")) {
            List<Laptop> allLaptops = LaptopDAO.getLaptopByprice(Integer.valueOf(args[1]));
            allLaptops.forEach(System.out::println);
        }

        if (args[0].equals("-lstPrice")) {
            List<Laptop> allLaptops = LaptopDAO.getLaptopBypriceLessthan(Integer.valueOf(args[1]));
            allLaptops.forEach(System.out::println);
        }

        if (args[0].equals("-grtPrice")) {
            List<Laptop> allLaptops = LaptopDAO.getLaptopBypriceGreaterthan(Integer.valueOf(args[1]));
            allLaptops.forEach(System.out::println);
        }
        if(args[0].equals("-btwPrice")){
            List<Laptop> allLaptops = LaptopDAO.getLaptopBetweenprice(Integer.valueOf(args[1]),Integer.valueOf(args[2]));
            allLaptops.forEach(System.out::println);
        }
        if (args[0].equals("-gtAvail")) {
            List<Laptop> allLaptops = LaptopDAO.getbyAvailability();
            allLaptops.forEach(System.out::println);
        }
        if (args[0].equals("-sort")) {
            List<Laptop> allLaptops1 = LaptopDAO.SortByPrice();
            allLaptops1.forEach(System.out::println);
        }
        if (args[0].equals("-gtAvg")) {
            LaptopDAO.getAvgPrice(args[1]);
            List<Laptop> allLaptops = LaptopDAO.getAllLaptops();
            allLaptops.forEach(System.out::println);
        }
        if (args[0].equals("-h"))
            help();
    }
}
