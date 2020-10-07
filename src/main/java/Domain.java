//import dao.connection.DB;
//import entity.Abonent;
//import entity.Phone_service;
//import entity.Sub_service;
//import service.AbonentDaoImpl;
//import service.Phone_serviceService;
//import service.Sub_serviceService;
//
//import java.sql.SQLException;
//
//public class Domain {
//    public static void main(String[] args){
//        DB db = new DB();
//        db.getConnection();
//        AbonentDaoImpl abonentService = new AbonentDaoImpl();
//        Phone_serviceService phone_serviceService = new Phone_serviceService();
//        Sub_serviceService sub_serviceService = new Sub_serviceService();
//
//        Abonent abonent = new Abonent();
//        abonent.setId(7);
//        abonent.setFirst_name("Michael");
//        abonent.setSecond_name("Kipchatov");
//        abonent.setPhone_number("+79633136313");
//
//        Phone_service phone_service = new Phone_service();
//        phone_service.setId(6);
//        phone_service.setNAME_OF_SERVICE("Weekend Call");
//        phone_service.setPRICE(0.5);
//
//        Sub_service sub_service = new Sub_service();
//        sub_service.setAbonent_id(abonent.getId());
//        sub_service.setPhone_service_id(phone_service.getId());
//
//        try {
//            abonentService.add(abonent);
//            phone_serviceService.add(phone_service);
//            sub_serviceService.add(sub_service);
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//    }
//}
