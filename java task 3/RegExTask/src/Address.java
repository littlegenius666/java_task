/**
 * This class expresses physical address;
 *
 * @author Yelyzaveta Horbachenko
 */
public class Address {
    private String index;
    private String city;
    private String street;
    private String houseNumber;
    private int apartmentNumber;

    public Address() {
    }

    /**
     * Constructor with parameters. All input parameters are String.
     * ApartmentNumber will be converted into int.
     *
     * @param index           expresses index.
     * @param city            expresses name of the city.
     * @param street          expresses name of the street.
     * @param houseNumber     expresses number of the house.
     * @param apartmentNumber expresses number of the apartment.
     */
    public Address(String index, String city, String street, String houseNumber,
                   String apartmentNumber) {
        this.index = index;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = Integer.parseInt(apartmentNumber);
    }

    @Override
    public String toString() {
        return "Index=" + index + ", City=" + city + ", Street=" + street
                + ", HouseNumber=" + houseNumber + ", ApartmentNumber="
                + apartmentNumber + "";
    }

}
