package totchi.g3an.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by Fatma on 23/08/2018.
 */

public class Utils {
   public static String getMAcAddress() {
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo wInfo = wifiManager.getConnectionInfo();
        @SuppressLint("HardwareIds")
        String macAddress = wInfo.getMacAddress();
        return macAddress;
    }
}
