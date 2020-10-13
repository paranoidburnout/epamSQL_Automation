package console;

import entity.SubService;
import service.SubServiceService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ConsolSubService {

    SubServiceService sub_serviceService = new SubServiceService();
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
            ConsolSubService consolSubService = new ConsolSubService();

            Object s = consolSubService.getResult(request.split(" "));

            if (s instanceof SubService) {
                System.out.println(((SubService) s).getAbonent_id() + " " + ((SubService) s).getPhone_service_id());
            }
            if (s instanceof SubService) {
                System.out.println(((SubService) s).getPhone_service_id() + " " + ((SubService) s).getAbonent_id());
            }
            if (s instanceof List) {
                List<SubService> list = (List) s;
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
        if (strings[0].equals("get") && strings[1].equals("all") && strings[2].equals("subs")) {
            try {
                return sub_serviceService.findAll();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                close();
            }
        }
        if (strings[0].equals("get") && strings[1].equals("defined") && strings[2].equals("subs")) {
            try {
                return sub_serviceService.findByAbonent_idAndPhone_service_id(1, 4);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                close();
            }
        }
        if (strings[0].equals("find") && strings[1].equals("phone") && strings[2].equals("sub")) {
            try {
                return sub_serviceService.findByPhoneServiceId(1);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                close();
            }
        }
        if (strings[0].equals("get") && strings[1].equals("abonent") && strings[2].equals("sub")) {
            try {
                return sub_serviceService.findByAbonentId(2);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                close();
            }
        }

        return null;
    }
}
