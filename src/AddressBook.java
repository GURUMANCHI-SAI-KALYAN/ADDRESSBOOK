import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


class Contacts {
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    long zip, phoneNumber;

    public Contacts(String firstName, String lastName, String address, String city, String state, long zip,
                    long phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}

public class AddressBook {

    public static void main(String[] args) {
        System.out.println("Welcome to AddressBook");
        ArrayList<Contacts> book = new ArrayList<>();

          book.add( new Contacts("kalyan", "gurumanchi"," address","hyd", "telangana", 600005, 90000005));
        book.add( new Contacts("tina", "henna"," address","Agra", "delhi", 60008, 985574855));
        book.add( new Contacts("akki", "malla"," address","karimnagar", "telangana", 60005, 900025254));
        book.add( new Contacts("geeta", "grrta"," address","munnar", "maharastra", 600225, 958447452));
        book.add( new Contacts("arivand", "allu"," address","manali", "hp", 605852, 701365587));

        Scanner input = new Scanner(System.in);
        String check = "y";

        while (!check.equalsIgnoreCase("n")) {
            System.out.println("Enter the Operation you want to perform");
            System.out.println("1.Add \n 2.Edit \n 3.Delete \n 4.Search \n 5.view \n 6.count");
            int option = input.nextInt();
            switch (option) {
                case 1:
                    AddressBookOperations.add(book);
                    break;
                case 2:
                    AddressBookOperations.edit(book);
                    break;
                case 3:
                    AddressBookOperations.delete(book);
                    break;
                case 4:
                    AddressBookOperations.search(input, book);
                    break;
                case 5:
                    AddressBookOperations.viewByCityorState(input, book);
                    break;
                case 6:
                    AddressBookOperations.countByCityorState(input,book);
                    break;
                case 7 :
                    Collections.sort(book,(p1, p2)->{
                        return p1.firstName.compareTo(p2.firstName);
                    });
                    book.stream().forEach(n -> System.out.println(n));
            }
            System.out.println("Do you want to perform any other option ?press(y/n)");
            check = input.next();
        }
        book.stream().forEach(n -> System.out.println(n));
    }


}
