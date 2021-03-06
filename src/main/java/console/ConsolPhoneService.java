package console;

import entity.PhoneService;
import service.PhoneServiceService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ConsolPhoneService {

    PhoneServiceService phone_serviceService = new PhoneServiceService();
    Connection connection;

    void open() {
        try {
            Class.forName("org.sqlite.JDBC"); //Загрузка драйвера БД
            connection = DriverManager.getConnection("jdbc:sqlite:Telephone_station.db"); //Установление связи с БД
            System.out.println("Connected");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String request = reader.readLine();
            ConsolPhoneService consolPhoneService = new ConsolPhoneService();

            Object p = consolPhoneService.getResult(request.split(" "));
            if (p instanceof PhoneService) {
                System.out.println(((PhoneService) p).getNAME_OF_SERVICE() + " " + ((PhoneService) p).getPRICE());
            }
            if (p instanceof List) {
                List<PhoneService> list = (List) p;
                list.forEach(System.out::println);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void close() {
        try {
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    Object getResult(String[] strings) {
        open();
        if (strings[0].equals("find") && strings[1].equals("service")) {
            try {
                return phone_serviceService.findById(2);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                close();
            }
        }

        if (strings[0].equals("get") && strings[1].equals("all") && strings[2].equals("services")) {
            try {
                return phone_serviceService.findAll();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                close();
            }
        }
        return null;
    }
}
