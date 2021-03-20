package models.base.dto;

public class AddressDto {
    public String street;
    public String suite;
    public String city;
    public String zipcode;
    public GeoDto geo;

    public AddressDto(String street, String suite, String city, String zipcode,GeoDto geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }

    public AddressDto() {
        super();
    }
}
