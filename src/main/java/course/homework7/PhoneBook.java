package course.homework7;

import java.util.HashSet;

class PhoneBook {
    HashSet<Person> contacts = new HashSet<>();

    public void add(Person p) {
        contacts.add(p);
    }

    public void add(String name, short areaCode, short exchange, short extension) {
        contacts.add(new Person(name, areaCode, exchange, extension));
    }

    public void delete(Person p) {
        contacts.remove(p);
    }

    public void delete(String name) {
        for (Person p : contacts) {
            if (p.getName() == name) {
                contacts.remove(p);
            }
        }
    }
}

class Person {
    private String name = "";
    private PhoneNumber phoneNumber;

    public String getName() {
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public Person(String name, short areaCode, short exchange, short extension) {
        this.name = name;

        phoneNumber = new PhoneNumber(areaCode, exchange, extension);
    }

    public Person(String name, PhoneNumber phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public boolean equals(Person obj) {
        if (obj.getName() == name && obj.getPhoneNumber().compareTo(phoneNumber) == 0) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return name + ": " + phoneNumber.toString();
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}

final class PhoneNumber implements Comparable<PhoneNumber> {
    private final short areaCode;
    private final short exchange;
    private final short extension;

    public short getAreaCode() {
        return areaCode;
    }

    public short getExchange() {
        return exchange;
    }

    public short getExtension() {
        return extension;
    }

    @Override
    public int compareTo(PhoneNumber o) {
        return o.toString().compareTo(toString());
    }

    public PhoneNumber(short areaCode, short exchange, short extension) {
        rangeCheck(areaCode,   999, "area code");
        rangeCheck(exchange,   999, "exchange");
        rangeCheck(extension, 9999, "extension");
        this.areaCode  = areaCode;
        this.exchange  = exchange;
        this.extension = extension;
    }

    private static void rangeCheck(int arg, int max, String name) {
        if (arg < 0 || arg > max) {
            throw new IllegalArgumentException(name +": " + arg);
        }
    }

    public boolean equals(PhoneNumber obj) {
        if (areaCode == obj.getAreaCode()
                && exchange == obj.getExchange()
                && extension == obj.getExtension()) {
           return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(areaCode).append(exchange).append(exchange).toString();
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}

