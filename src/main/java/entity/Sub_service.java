package entity;

import java.util.Objects;

public class Sub_service {
    private int Abonent_id;
    private int Phone_service_id;

    public Sub_service(int Abonent_id, int Phone_service_id){
        this.Abonent_id=Abonent_id;
        this.Phone_service_id=Phone_service_id;
    }

    public Sub_service() {

    }

    public int getAbonent_id() {
        return Abonent_id;
    }

    public void setAbonent_id(int abonent_id) {
        Abonent_id = abonent_id;
    }

    public int getPhone_service_id() {
        return Phone_service_id;
    }

    public void setPhone_service_id(int phone_service_id) {
        Phone_service_id = phone_service_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sub_service that = (Sub_service) o;
        return Abonent_id == that.Abonent_id &&
                Phone_service_id == that.Phone_service_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Abonent_id, Phone_service_id);
    }

    @Override
    public String toString() {
        return "Sub_service{" +
                "Abonent_id=" + Abonent_id +
                ", Phone_service_id=" + Phone_service_id +
                '}';
    }

}
