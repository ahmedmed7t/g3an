package totchi.g3an.ui.main;

import java.util.ArrayList;

import totchi.g3an.data.remote.model.showChiefs.chiefResponse;
import totchi.g3an.ui.base.BaseView;

/**
 * Created by CrazyNet on 06/09/2018.
 */

public interface searchFragmentView extends BaseView {

    public void sendArrayToView(ArrayList<chiefResponse> arrayList);

}
