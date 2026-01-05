package models;

public abstract class Person implements Payable, Comparable<Person> {
    protected static int counter = 0;
    protected int id;
    protected String name;
    protected String surname;

    public Person() {
        this.id = ++counter;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.id = counter;
        counter++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return id + ". " + name + " " + surname;
    }

    public String getPosition() {
        return "Person";
    }

    @Override
    public double getPaymentAmount() {
        return 0.0;
    }

    @Override
    public int compareTo(Person other) {
        return Double.compare(this.getPaymentAmount(), other.getPaymentAmount());
    }
}
