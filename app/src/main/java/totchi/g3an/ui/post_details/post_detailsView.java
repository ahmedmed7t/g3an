package totchi.g3an.ui.post_details;

import totchi.g3an.data.remote.model.showPostDetails.postDetails;
import totchi.g3an.ui.base.BaseView;

/**
 * Created by CrazyNet on 10/09/2018.
 */

public interface post_detailsView extends BaseView {

     void presentData(postDetails postDetails);
     void fillorder(postDetails postDetails);
}
