//import DAO.SQLite.implementations.AbonentDaoImpl;

public class DaoPatternAbonent {
//    public static void main(String[] args) {
//        AbonentDAO abonentDAO = new AbonentDaoImpl(dao.connection.DB.getConnection());
//
//        //print all abonents
//        for (Abonent abonent : abonentDAO.getAllAbonents()) {
//            System.out.println("Abonent: [ID : " + abonent.getId() + ", First_Name : " +
//                    abonent.getFirst_name() + ", Second_name : " + abonent.getSecond_name() +
//                    ", Phone_number : " + abonent.getPhone_number() + " ]");
//        }
//        //update abonents
//        Abonent abonent = abonentDAO.getAllAbonents().get(0);
//        abonent.setFirst_name("Blaumman");
//        abonent.setSecond_name("Dirk");
//        abonent.setPhone_number("+4915903906944");
//        abonentDAO.updateAbonent(abonent);
//        //get the abonent
//        abonentDAO.getAbonent(0);
//        System.out.println("Abonent: [ID : " + abonent.getId() + ", First_Name : " +
//                abonent.getFirst_name() + ", Second_name : " + abonent.getSecond_name() +
//                ", Phone_number : " + abonent.getPhone_number() + " ]");
//    }
//    ----------------------------------------------------------------------------------------
//AbonentDaoImpl abonentService = new AbonentDaoImpl();
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
}
