package models.base.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@JsonIgnoreProperties
public class UserDto {

    @JsonProperty(value = "id", access = JsonProperty.Access.READ_WRITE)
    private String id;

    @JsonProperty(value = "name", access = JsonProperty.Access.READ_WRITE)
    private String name;

    @JsonProperty(value = "username", access = JsonProperty.Access.READ_WRITE)
    private String userName;

    @JsonProperty(value = "email", access = JsonProperty.Access.READ_WRITE)
    private String email;

    @JsonProperty(value = "address", access = JsonProperty.Access.READ_WRITE)
    private AddressDto address;

    @JsonProperty(value = "phone", access = JsonProperty.Access.READ_WRITE)
    private String phone;

    @JsonProperty(value = "website", access = JsonProperty.Access.READ_WRITE)
    private String website;

    @JsonProperty(value = "company", access = JsonProperty.Access.READ_WRITE)
    private CompanyDto company;


    public UserDto() {
        super();
    }


    public String getId() {
        return id;
    }

    public UserDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserDto setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public AddressDto getAddress() {
        return address;
    }

    public UserDto setAddress(AddressDto address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserDto setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getWebsite() {
        return website;
    }

    public UserDto setWebsite(String website) {
        this.website = website;
        return this;
    }

    public CompanyDto getCompany() {
        return company;
    }

    public UserDto setCompany(CompanyDto company) {
        this.company = company;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        UserDto userDto = (UserDto) o;

        return new EqualsBuilder().append(id, userDto.id).append(name, userDto.name).append(userName, userDto.userName).append(email, userDto.email).append(address, userDto.address).append(phone, userDto.phone).append(website, userDto.website).append(company, userDto.company).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(name).append(userName).append(email).append(address).append(phone).append(website).append(company).toHashCode();
    }
}
