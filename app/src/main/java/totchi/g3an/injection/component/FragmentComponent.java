package totchi.g3an.injection.component;


import dagger.Subcomponent;
import totchi.g3an.injection.modules.FragmentModule;
import totchi.g3an.injection.scops.PerFragment;
import totchi.g3an.ui.main.HomeFragment;

/**
 * Created by Fatma on 04/07/2018.
 */
@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {

     void inject(HomeFragment homeFragment);

}
