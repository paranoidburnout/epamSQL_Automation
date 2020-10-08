import entity.Abonent;
import entity.Phone_service;
import entity.Sub_service;
import service.AbonentService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


public class Console {

    AbonentService abonentService = new AbonentService();

    Phone_service phone_service = new Phone_service();

    Sub_service sub_service = new Sub_service();

    Connection c;

    void open() {
        try {
            Class.forName("org.sqlite.JDBC"); //Загрузка драйвера БД
            c = DriverManager.getConnection("jdbc:dao.sqlite:Telephone_station.db"); //Установление связи с БД
            System.out.println("Connected");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String request = reader.readLine();
            Console console = new Console();
            Object o = console.getResult(request.split(" "));
            if (o instanceof Abonent) {
                System.out.println(((Abonent) o).getFirst_name() + " " + ((Abonent) o).getPhone_number());
            }
            if (o instanceof List) {
                List<Abonent> list = (List) o;
                list.forEach(System.out::println);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void close() {
        try {
            c.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    Object getResult(String[] strings) {
        open();
        if (strings[0].equals("find") && strings[1].equals("user")) {
            try {
                return abonentService.findById(1);
//                return abonentService.findById(Integer.parseInt(strings[1]));

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (strings[0].equals("get") && strings[1].equals("all") && strings[2].equals("users")) {
            try {
                return abonentService.findAll();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                close();
            }
        }
        if (strings[0].equals("modify") && strings[1].equals("service")) {
            try {
                return abonentService.findById(4);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
