package com.ms.module.impl.utils.impl;

import android.content.Context;
import android.content.SharedPreferences;

import com.ms.module.supers.client.Modules;

/**
 * @author maohuawei created in 2018/12/17
 * <p>
 * UMID
 */
public class UMIDUtils {
    public  String getUmid() {
        SharedPreferences sharedPreferences = Modules.getDataModule().getAppData().getApplication().getSharedPreferences("com.ms.module.mta.umid", Context.MODE_PRIVATE);
        String umid = sharedPreferences.getString("umid", "");
        if (umid == null || umid.equals("")) {
            String s = Modules.getUtilsModule().getMd5Utils().md5(Modules.getUtilsModule().getMd5Utils().md5(Modules.getUtilsModule().getMd5Utils().md5(
                    Modules.getUtilsModule().getSystemUtils().getMac())));
            sharedPreferences.edit().putString("umid", s).commit();
            return s;
        }
        return umid;
    }
}