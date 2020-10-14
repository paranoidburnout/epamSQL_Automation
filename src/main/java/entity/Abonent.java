package entity;

import java.util.Objects;

public class Abonent {
    private int id;
    private String first_name;
    private String second_name;
    private String phone_number;

    public Abonent(int id, String first_name, String second_name, String phone_number) {
        this.id = id;
        this.first_name = first_name;
        this.second_name = second_name;
        this.phone_number = phone_number;
    }

    public Abonent() {

    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abonent abonent = (Abonent) o;
        return id == abonent.id &&
                Objects.equals(first_name, abonent.first_name) &&
                Objects.equals(second_name, abonent.second_name) &&
                Objects.equals(phone_number, abonent.phone_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,
                first_name,
                second_name,
                phone_number
        );
    }

    @Override
    public String toString() {
        return "Abonent{" +
                "id=" + id +
                ", First_name='" + first_name + '\'' +
                ", Second_name='" + second_name + '\'' +
                ", Phone_number='" + phone_number + '\'' +
                '}';
    }
}
