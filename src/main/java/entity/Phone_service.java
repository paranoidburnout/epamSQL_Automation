package entity;

import java.util.Objects;

public class Phone_service {
    private int id;
    private String NAME_OF_SERVICE;
    private double PRICE;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone_service that = (Phone_service) o;
        return id == that.id &&
                Double.compare(that.PRICE, PRICE) == 0 &&
                NAME_OF_SERVICE.equals(that.NAME_OF_SERVICE) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, NAME_OF_SERVICE, PRICE
        );
    }

    @Override
    public String toString() {
        return "Phone_service{" +
                "id=" + id +
                ", NAME_OF_SERVICE='" + NAME_OF_SERVICE + '\'' +
                ", PRICE=" + PRICE +
                ", abonents=" +
                '}';
    }
}

