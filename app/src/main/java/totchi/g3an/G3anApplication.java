package totchi.g3an;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import totchi.g3an.injection.component.ApplicationComponent;
import totchi.g3an.injection.component.DaggerApplicationComponent;
import totchi.g3an.injection.modules.ApplicationModule;

/**
 * Created by Fatma on 20/07/2018.
 */

public class G3anApplication extends MultiDexApplication {
    static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public ApplicationComponent getApplicationComponent() {
        if (applicationComponent == null)
            applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
        return applicationComponent;
    }

    public static G3anApplication get(Context context) {
        return (G3anApplication) context.getApplicationContext();
    }
}