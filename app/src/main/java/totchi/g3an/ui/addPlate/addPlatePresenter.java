package totchi.g3an.ui.addPlate;

import javax.inject.Inject;

import totchi.g3an.data.DataManager;
import totchi.g3an.ui.base.BasePresenter;

/**
 * Created by CrazyNet on 03/10/2018.
 */

public class addPlatePresenter extends BasePresenter<addPlateView> {

    DataManager dataManager;

    @Inject
    public addPlatePresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public void addPlate(){}
}
