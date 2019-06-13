package totchi.g3an.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.LongSparseArray;

import java.util.concurrent.atomic.AtomicLong;

import totchi.g3an.G3anApplication;
import totchi.g3an.injection.component.ConfigPersistentComponent;
import totchi.g3an.injection.component.DaggerConfigPersistentComponent;
import totchi.g3an.injection.component.FragmentComponent;
import totchi.g3an.injection.modules.FragmentModule;

/**
 * Created by Fatma on 04/07/2018.
 */

public class BaseFragment extends Fragment {

    FragmentComponent mFragmentComponent;
    private static final String KEY_ACTIVITY_ID = "KEY_ACTIVITY_ID";
    private static final AtomicLong NEXT_ID = new AtomicLong(0);
    private static final LongSparseArray<ConfigPersistentComponent>
            sComponentsMap = new LongSparseArray<>();

    private long mFragmentId;

    @Override
    public void onDestroy() {
        if (!getActivity().isChangingConfigurations()) {
            sComponentsMap.remove(mFragmentId);
        }
        super.onDestroy();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentId = savedInstanceState != null ?
                savedInstanceState.getLong(KEY_ACTIVITY_ID) : NEXT_ID.getAndIncrement();

        ConfigPersistentComponent configPersistentComponent = sComponentsMap.get(mFragmentId, null);

        if (configPersistentComponent == null) {
            configPersistentComponent = DaggerConfigPersistentComponent.builder()
                    .applicationComponent(G3anApplication.get(getActivity()).getApplicationComponent())
                    .build();
            sComponentsMap.put(mFragmentId, configPersistentComponent);
        }
        mFragmentComponent = configPersistentComponent.fragmentComponent(new FragmentModule());

    }


    public FragmentComponent fragmentComponent() {
        return mFragmentComponent;
    }
}
