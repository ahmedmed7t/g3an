package totchi.g3an.data.local;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by Fatma on 03/07/2018.
 */

public class SharedPrefencesHelper {
    private final SharedPreferences mSharedPrefernce;
    SharedPreferences.Editor editor;
    private Gson gson;

    @Inject
    public SharedPrefencesHelper(Context context) {
        mSharedPrefernce = PreferenceManager.getDefaultSharedPreferences(context);
        editor = mSharedPrefernce.edit();

    }

    public void clear() {
        editor.clear().commit();
    }

    public void remove(String key) {
        editor.remove(key).commit();
    }

    public void put(String key, Object object) {
        gson = new Gson();
        if (object == null) {
            throw new IllegalArgumentException("object is null");
        }

        if (key.equals("") || key == null) {
            throw new IllegalArgumentException("key is empty or null");
        }

        editor.putString(key, gson.toJson(object)).commit();
    }

    public void putSingleString(String key, String value) {
        editor.putString(key, value);
    }

    public String getValue(String key) {
        String result = mSharedPrefernce.getString(key, null);
        return result;
    }

    public <T> Single<T> getObject(final String key, final Class<T> a) {
        return Single.fromCallable(new Callable<T>() {

            @Override
            public T call() throws Exception {
                if (gson == null)
                    gson = new Gson();

                try {
                    String result = mSharedPrefernce.getString(key, null);
                    return gson.fromJson(result, a);
                } catch (Exception e) {
                    throw new IllegalArgumentException("Object storaged with key " + key + " is instanceof other class");
                }

            }
        });

    }
}
