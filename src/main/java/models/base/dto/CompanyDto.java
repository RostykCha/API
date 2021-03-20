package models.base.dto;

public class CompanyDto {
    public String name;
    public String catchPhrase;
    public String bs;

    public CompanyDto(String name, String catchPhrase, String bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    public CompanyDto() {
        super();
    }
}
