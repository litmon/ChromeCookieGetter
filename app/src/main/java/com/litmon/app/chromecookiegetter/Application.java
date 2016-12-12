package com.litmon.app.chromecookiegetter;

import com.facebook.stetho.Stetho;

/**
 * Created by fukuo on 西暦16/12/12.
 */

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
