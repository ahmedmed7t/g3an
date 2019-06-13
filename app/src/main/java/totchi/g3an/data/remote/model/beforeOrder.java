package totchi.g3an.data.remote.model;

/**
 * Created by CrazyNet on 26/09/2018.
 */

public class beforeOrder {

    private String plateImage , plateName  , plateTime ;
    private int quantity , platePrice , id;
    private boolean delete;

    public beforeOrder() {
    }

    public beforeOrder(String plateImage, String plateName, int platePrice, String plateTime, int quantity) {

        this.plateImage = plateImage;
        this.plateName = plateName;
        this.platePrice = platePrice;
        this.plateTime = plateTime;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public String getPlateImage() {
        return plateImage;
    }

    public void setPlateImage(String plateImage) {
        this.plateImage = plateImage;
    }

    public String getPlateName() {
        return plateName;
    }

    public void setPlateName(String plateName) {
        this.plateName = plateName;
    }

    public int getPlatePrice() {
        return platePrice;
    }

    public void setPlatePrice(int platePrice) {
        this.platePrice = platePrice;
    }

    public String getPlateTime() {
        return plateTime;
    }

    public void setPlateTime(String plateTime) {
        this.plateTime = plateTime;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
