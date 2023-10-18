package models.specialModels;

public class StatusCount {
    private int present;

    public int getPresent() {
        return present;
    }

    public void setPresent(int present) {
        this.present = present;
    }

    public int getAbsent() {
        return absent;
    }

    public void setAbsent(int absent) {
        this.absent = absent;
    }

    public int getLate() {
        return late;
    }

    public void setLate(int late) {
        this.late = late;
    }

    private int absent;
    private int late;

}
