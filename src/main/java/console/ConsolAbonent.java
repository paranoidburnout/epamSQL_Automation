package console;

import entity.Abonent;
import service.AbonentService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


public class ConsolAbonent {

    AbonentService abonentService = new AbonentService();
    Connection c;

    void open() {
        try {
            Class.forName("org.sqlite.JDBC"); //Загрузка драйвера БД
            c = DriverManager.getConnection("jdbc:sqlite:Telephone_station.db"); //Установление связи с БД
            System.out.println("Connected");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws SQLException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String request = reader.readLine();
            ConsolAbonent console = new ConsolAbonent();

            Object o = console.getResult(request.split(" "));

            if (o instanceof Abonent) {
                System.out.println(((Abonent) o).getFirst_name() + " " + ((Abonent) o).getPhone_number() + " " +
                        ((Abonent) o).getSecond_name());
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

    Object getResult(String[] strings) throws IOException, SQLException {
        open();
        if (strings[0].equals("find") && strings[1].equals("user")) {
            try {
                return abonentService.findById(4); //<---здесь необходимо прописать нужное  айди
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                close();
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
        return null;
    }
}


