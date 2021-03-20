package models.base.dto;

public class GeoDto {
    public String lat;
    public String lng;

    public GeoDto(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public GeoDto() {
        super();
    }
}
