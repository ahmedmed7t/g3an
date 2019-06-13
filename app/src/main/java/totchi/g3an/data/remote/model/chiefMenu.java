package totchi.g3an.data.remote.model;

/**
 * Created by CrazyNet on 03/10/2018.
 */

public class chiefMenu {

    private String plateImage , platePrice , plateName ;

    public chiefMenu() {
    }

    public chiefMenu(String plateImage, String platePrice, String plateName) {

        this.plateImage = plateImage;
        this.platePrice = platePrice;
        this.plateName = plateName;
    }

    public String getPlateImage() {
        return plateImage;
    }

    public void setPlateImage(String plateImage) {
        this.plateImage = plateImage;
    }

    public String getPlatePrice() {
        return platePrice;
    }

    public void setPlatePrice(String platePrice) {
        this.platePrice = platePrice;
    }

    public String getPlateName() {
        return plateName;
    }

    public void setPlateName(String plateName) {
        this.plateName = plateName;
    }
}
