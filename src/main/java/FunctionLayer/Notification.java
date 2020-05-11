package FunctionLayer;

public class Notification {

    private int brugerID;
    private int notificationID;
    private String beskrivelse;
    private Boolean ny;

    public Notification(int brugerID, String beskrivelse) {
        this.brugerID = brugerID;
        this.beskrivelse = beskrivelse;
        this.ny = true;
    }


    public int getBrugerID() {
        return brugerID;
    }

    public int getNotificationID() {
        return notificationID;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setNotificationID(int notificationID) {
        this.notificationID = notificationID;
    }

    public Boolean getNy() {
        return ny;
    }

    public void setNy(Boolean ny) {
        this.ny = ny;
    }
}
