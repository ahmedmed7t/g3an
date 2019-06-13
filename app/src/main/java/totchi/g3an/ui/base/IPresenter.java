package totchi.g3an.ui.base;

/**
 * Created by Fatma on 03/07/2018.
 */

public interface IPresenter<V extends BaseView> {
    void attachView(V view);

    void detachView();
}
