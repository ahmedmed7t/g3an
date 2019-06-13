package totchi.g3an.injection.modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import totchi.g3an.data.DataManager;
import totchi.g3an.data.local.SharedPrefencesHelper;
import totchi.g3an.data.remote.G3anService;

/**
 * Created by Fatma on 04/07/2018.
 */
@Module
public class ApplicationModule {
    Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }


    @Provides
    Context provideContext() {
        return application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }

    @Provides
    SharedPrefencesHelper provideSharedPrefencesHelper(Context context) {
        return new SharedPrefencesHelper(context);
    }

    @Singleton
    @Provides
    G3anService provideService() {
        return G3anService.Creator.newIHelpService();
    }

    @Provides
    DataManager provideDatamanger(SharedPrefencesHelper sharedPrefencesHelper, G3anService service) {
        return new DataManager(sharedPrefencesHelper, service);
    }
}
