package models.base.dto;


public class UserDto {
    public String id;

    public String name;

    public String username;

    public String email;

    public AddressDto address;

    public String phone;

    public String website;

    public CompanyDto company;

    public UserDto(String id, String name, String username, String email, AddressDto addressDto, String phone, String website, CompanyDto companyDto) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = addressDto;
        this.phone = phone;
        this.website = website;
        this.company = companyDto;
    }
    public UserDto() {
        super();
    }
}
