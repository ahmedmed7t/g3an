package totchi.g3an.injection.component;


import dagger.Component;
import totchi.g3an.injection.modules.ActivityModule;
import totchi.g3an.injection.modules.FragmentModule;
import totchi.g3an.injection.scops.ConfigPersistent;

/**
 * Created by Fatma on 04/07/2018.
 */
@ConfigPersistent
@Component(dependencies = ApplicationComponent.class)
public interface ConfigPersistentComponent {
    FragmentComponent fragmentComponent(FragmentModule fragmentModule);

    ActivityComponent activityComponent(ActivityModule activityModule);
}
