package totchi.g3an.data.remote.model;

/**
 * Created by CrazyNet on 01/10/2018.
 */

public class orderHint {

    private String plateName , plateImage , date ;

    public orderHint() {
    }

    public orderHint(String plateName, String plateImage, String date) {

        this.plateName = plateName;
        this.plateImage = plateImage;
        this.date = date;
    }

    public String getPlateName() {
        return plateName;
    }

    public void setPlateName(String plateName) {
        this.plateName = plateName;
    }

    public String getPlateImage() {
        return plateImage;
    }

    public void setPlateImage(String plateImage) {
        this.plateImage = plateImage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
