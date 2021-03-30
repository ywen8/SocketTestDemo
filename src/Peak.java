import java.io.Serializable;

public class Peak implements Serializable {
    private String name;
    private String startTime;
    private String endTime;
    private boolean isChoose;
    private int useTypeIndex;
    private int type;//1:上班打卡 2:下班打卡

    public int getUseTypeIndex() {
        return useTypeIndex;
    }

    public void setUseTypeIndex(int useTypeIndex) {
        this.useTypeIndex = useTypeIndex;
    }

    public boolean isChoose() {
        return isChoose;
    }

    public void setChoose(boolean choose) {
        isChoose = choose;
    }

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
}
