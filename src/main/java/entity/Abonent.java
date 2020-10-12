package entity;

import java.util.Objects;

public class Abonent {
    private int id;
    private String First_name;
    private String Second_name;
    private String Phone_number;

    public Abonent(int id, String First_name, String Second_name, String Phone_number){
        this.id= id;
        this.First_name= First_name;
        this.Second_name = Second_name;
        this.Phone_number= Phone_number;
    }

    public Abonent() {

    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return First_name;
    }

    public String getSecond_name() {
        return Second_name;
    }

    public String getPhone_number() {
        return Phone_number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.First_name = first_name;
    }

    public void setSecond_name(String second_name) {
        this.Second_name = second_name;
    }

    public void setPhone_number(String phone_number) {
        this.Phone_number = phone_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abonent abonent = (Abonent) o;
        return id == abonent.id &&
                Objects.equals(First_name, abonent.First_name) &&
                Objects.equals(Second_name, abonent.Second_name) &&
                Objects.equals(Phone_number, abonent.Phone_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,
                First_name,
                Second_name,
                Phone_number
        );
    }

    @Override
    public String toString() {
        return "Abonent{" +
                "id=" + id +
                ", First_name='" + First_name + '\'' +
                ", Second_name='" + Second_name + '\'' +
                ", Phone_number='" + Phone_number + '\'' +
                '}';
    }
}
