package by.bsuir.demo.common;

public class Fine {

    private int id;

    private User user;

    private Location location;

    private BorderSpeed borderSpeed;

    private Car car;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public BorderSpeed getBorderSpeed() {
        return borderSpeed;
    }

    public void setBorderSpeed(BorderSpeed borderSpeed) {
        this.borderSpeed = borderSpeed;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
