public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age;
    protected String address;

    public PersonBuilder setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalStateException("Введите имя!");
        } else {
            this.name = name;
        }
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalStateException("Введите фамилию!");
        } else {
            this.surname = surname;
        }
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age >= 0) {
            this.age = age;
            return this;
        } else {
            throw new IllegalArgumentException("Некоректый возраст");
        }
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name != null && surname != null) {
            return new Person(name, surname, age, address);
        } else {
            throw new IllegalStateException("Не ввели обязательные данные");
        }
    }
}