import java.io.Serializable;

public class Door implements Serializable {

    private String name;
    private String startTime;
    private String endTime;
    private boolean isChoose;
    private boolean swDoor = true;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public boolean isChoose() {
        return isChoose;
    }

    public void setChoose(boolean choose) {
        isChoose = choose;
    }

    public boolean isSwDoor() {
        return swDoor;
    }

    public void setSwDoor(boolean swDoor) {
        this.swDoor = swDoor;
    }
}
