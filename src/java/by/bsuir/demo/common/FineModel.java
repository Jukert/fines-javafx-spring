package by.bsuir.demo.common;

public class FineModel {

    private String fio;

    private String car;

    private String phone;

    private String region;

    private String speed;

    public FineModel(String fio, String car, String phone, String region, String speed) {
        this.fio = fio;
        this.car = car;
        this.phone = phone;
        this.region = region;
        this.speed = speed;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
}
