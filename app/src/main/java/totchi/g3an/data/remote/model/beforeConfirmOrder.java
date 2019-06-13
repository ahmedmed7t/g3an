package totchi.g3an.data.remote.model;

import java.util.ArrayList;

/**
 * Created by Medhat on 19/09/2018.
 */

public class beforeConfirmOrder {

    private String chiefImage , chiefName ;
    private ArrayList<beforeOrder> beforeOrders;

    public beforeConfirmOrder(String chiefImage, String chiefName, ArrayList<beforeOrder> beforeOrders) {
        this.chiefImage = chiefImage;
        this.chiefName = chiefName;
        this.beforeOrders = beforeOrders;
    }

    public beforeConfirmOrder() {
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

    public ArrayList<beforeOrder> getBeforeOrders() {
        return beforeOrders;
    }

    public void setBeforeOrders(ArrayList<beforeOrder> beforeOrders) {
        this.beforeOrders = beforeOrders;
    }

    public void addOrder(beforeOrder beforeOrder)
    {
        this.beforeOrders.add(beforeOrder);
    }
}
