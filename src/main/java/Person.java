import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age=-1;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;

    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return  age >= 0;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if (hasAge()){
            return OptionalInt.of(age);
        }else {
            return null;
        }
    }

    public String getAddress() throws Exception {
        if (hasAddress()){
            return address;
        }else {
            throw new Exception();
        }
    }

    public void setAddress(String city) {
        address = city;
    }

    public void happyBirthday() throws Exception {

        if (hasAge()){
            age += 1;
        }else {
            throw new Exception("Возраст не указан");
        }
    }

    @Override
    public String toString() {
        return "name " + name + ", surname " +
                surname + ", age " + age + ", address " + address;
    }

    @Override
    public int hashCode() {
        try {
            return Objects.hash(getName(), getSurname(), getAge(), getAddress());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(surname).setAge(0).setAddress(address);
    }
}