package resources;

import java.io.Serializable;

public class ResourcePool implements Serializable {

    public int doctors;
    public int nurses;
    public int rooms;

    public ResourcePool(int doctors, int nurses, int rooms) {
        this.doctors = doctors;
        this.nurses = nurses;
        this.rooms = rooms;
    }

    public boolean allocate() {
        if (doctors > 0 && nurses > 0 && rooms > 0) {
            doctors--;
            nurses--;
            rooms--;
            return true;
        }
        return false;
    }

    public void release() {
        doctors++;
        nurses++;
        rooms++;
    }
}