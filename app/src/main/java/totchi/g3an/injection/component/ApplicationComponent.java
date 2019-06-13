package totchi.g3an.injection.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import totchi.g3an.data.DataManager;
import totchi.g3an.data.local.SharedPrefencesHelper;
import totchi.g3an.data.remote.G3anService;
import totchi.g3an.injection.modules.ApplicationModule;

/**
 * Created by Fatma on 03/07/2018.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
//    @ApplicationContext
//    Context context();

    Application application();

    SharedPrefencesHelper sharedPrefencesHelper();

    DataManager dataManager();

    G3anService g3anService();
}
