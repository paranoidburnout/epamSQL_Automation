package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Phone_service {
    private int id;
    private String NAME_OF_SERVICE;
    private double PRICE;

//    private ArrayList<Abonent> abonents = new ArrayList<Abonent>();

//    private static Logger log= Logger.getLogger(Abonent.class.getName());

    public Phone_service(int id, String NAME_OF_SERVICE, double PRICE){
        this.id=id;
        this.NAME_OF_SERVICE = NAME_OF_SERVICE;
        this.PRICE = PRICE;
    }

    public Phone_service() {

    }

    public int getId() {
        return id;
    }

    public String getNAME_OF_SERVICE() {
        return NAME_OF_SERVICE;
    }

    public double getPRICE() {
        return PRICE;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNAME_OF_SERVICE(String NAME_OF_SERVICE) {
        this.NAME_OF_SERVICE = NAME_OF_SERVICE;
    }

    public void setPRICE(double PRICE) {
        this.PRICE = PRICE;
    }

//    public ArrayList<Abonent> getAbonents() {
//        return abonents;
//    }
//
//    public void setAbonents(ArrayList<Abonent> abonents) {
//        this.abonents = abonents;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone_service that = (Phone_service) o;
        return id == that.id &&
                Double.compare(that.PRICE, PRICE) == 0 &&
                NAME_OF_SERVICE.equals(that.NAME_OF_SERVICE) ;
//                && abonents.equals(that.abonents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, NAME_OF_SERVICE, PRICE
//                , abonents
        );
    }

    @Override
    public String toString() {
        return "Phone_service{" +
                "id=" + id +
                ", NAME_OF_SERVICE='" + NAME_OF_SERVICE + '\'' +
                ", PRICE=" + PRICE +
                ", abonents=" +
//                abonents +
                '}';
    }
}

