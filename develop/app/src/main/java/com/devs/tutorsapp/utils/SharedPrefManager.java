package com.devs.tutorsapp.utils;

import android.content.Context;
import android.content.SharedPreferences;
public class SharedPrefManager {

    private static final String PREF_NAME = "teachme_prefs";

    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";
    private static final String KEY_ALUMNO_ID = "alumnoId";
    private static final String KEY_ALUMNO_NOMBRE = "alumnoNombre";
    private static final String KEY_ALUMNO_EMAIL = "alumnoEmail";
    private static final String KEY_FIRST_TIME = "firstTime";

    private static SharedPrefManager instance;
    private final SharedPreferences prefs;

    private SharedPrefManager(Context context) {
        prefs = context.getApplicationContext()
                .getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPrefManager(context);
        }
        return instance;
    }

    public void saveLogin(int alumnoId, String nombre, String email) {
        prefs.edit()
                .putBoolean(KEY_IS_LOGGED_IN, true)
                .putInt(KEY_ALUMNO_ID, alumnoId)
                .putString(KEY_ALUMNO_NOMBRE, nombre)
                .putString(KEY_ALUMNO_EMAIL, email)
                .apply();
    }

    public boolean isLoggedIn() {
        return prefs.getBoolean(KEY_IS_LOGGED_IN, false);
    }

    public int getAlumnoId() {
        return prefs.getInt(KEY_ALUMNO_ID, -1);
    }

    public String getAlumnoNombre() {
        return prefs.getString(KEY_ALUMNO_NOMBRE, "");
    }

    public String getAlumnoEmail() {
        return prefs.getString(KEY_ALUMNO_EMAIL, "");
    }

    public AlumnoSession getAlumnoSession() {
        return new AlumnoSession(getAlumnoId(), getAlumnoNombre(), getAlumnoEmail());
    }

    public boolean hasValidUser() {
        return isLoggedIn() && getAlumnoId() != -1;
    }

    public void logout() {
        prefs.edit().clear().putBoolean(KEY_FIRST_TIME, false).apply();
    }

    public boolean isFirstTime() {
        return prefs.getBoolean(KEY_FIRST_TIME, true);
    }

    public void setFirstTimeFalse() {
        prefs.edit().putBoolean(KEY_FIRST_TIME, false).apply();
    }
}
