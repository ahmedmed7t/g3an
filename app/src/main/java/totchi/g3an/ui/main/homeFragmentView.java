package totchi.g3an.ui.main;

import java.util.ArrayList;

import totchi.g3an.data.remote.model.showAllPosts.post;
import totchi.g3an.ui.base.BaseView;

/**
 * Created by CrazyNet on 02/09/2018.
 */

public interface homeFragmentView extends BaseView{

    public void fillArray(ArrayList<post> arrayList);
}
