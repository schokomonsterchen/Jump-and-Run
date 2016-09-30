
public class Score {

    private int time;
    private int level;
    private int distance;
    private int message;
    private int noMessage;

    public Score() {
        time = 0;
        level = 1;
        distance = 0;
        message = 0;
        noMessage = 0;

    }


    public void setTimeUp() {
        time++;
    }

    public int getTime() {
        return time;
    }

    public void setLevelUp() {
        level++;
    }

    public int getLevel() {
        return level;
    }

    public void setDistance(int mileage) {
        distance -= mileage;
    }

    public int getMessage() {
        return message;
    }

    public void setMessageUp() {
        message++;
    }

    public int getNoMessage() {
        return noMessage;
    }

    public void setNoMessageUp() {
        noMessage++;
    }

    public int getDistance() {
        return distance;
    }

    public int getPoints() {
        return distance + (message * 10000) + (level * 10000) - time;
    }

}
