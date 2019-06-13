package totchi.g3an.data.remote.model;

/**
 * Created by CrazyNet on 26/09/2018.
 */

public class orderItem {

    private String chiefImage , chiefName ;
    private beforeOrder order ;

    public orderItem() {
    }

    public orderItem(String chiefImage, String chiefName, beforeOrder order) {

        this.chiefImage = chiefImage;
        this.chiefName = chiefName;
        this.order = order;
    }

    public String getChiefImage() {
        return chiefImage;
    }

    public void setChiefImage(String chiefImage) {
        this.chiefImage = chiefImage;
    }

    public String getChiefName() {
        return chiefName;
    }

    public void setChiefName(String chiefName) {
        this.chiefName = chiefName;
    }

    public beforeOrder getOrder() {
        return order;
    }

    public void setOrder(beforeOrder order) {
        this.order = order;
    }
}
