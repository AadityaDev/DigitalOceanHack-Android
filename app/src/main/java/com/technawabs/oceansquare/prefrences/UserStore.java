package com.technawabs.oceansquare.prefrences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.technawabs.oceansquare.constant.Constant;

public class UserStore {

    private final String TAG = this.getClass().getSimpleName();
    private static final int PRIVATE_MODE = 0;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public UserStore(@NonNull Context context) {
        sharedPreferences = context.getSharedPreferences(TAG, PRIVATE_MODE);
    }

    public void saveName(@NonNull String name) {
        editor = sharedPreferences.edit();
        editor.putString(Constant.UserStore.USER_NAME, name);
        editor.apply();
    }

    public void saveEmail(@NonNull String email) {
        editor = sharedPreferences.edit();
        editor.putString(Constant.UserStore.USER_EMAIL, email);
        editor.apply();
    }

    public void saveMobile(@NonNull String mobile) {
        editor = sharedPreferences.edit();
        editor.putString(Constant.UserStore.USER_MOBILE, mobile);
        editor.apply();
    }

    public void saveToken(@NonNull String token) {
        editor = sharedPreferences.edit();
        editor.putString(Constant.UserStore.USER_TOKEN, token);
        editor.apply();
    }

    public String getName() {
        return sharedPreferences.getString(Constant.UserStore.USER_NAME, Constant.UserStore.EMPTY_STRING);
    }

    public String getToken() {
        return sharedPreferences.getString(Constant.UserStore.USER_TOKEN, Constant.UserStore.EMPTY_STRING);
    }

    public String getEmail() {
        return sharedPreferences.getString(Constant.UserStore.USER_EMAIL, Constant.UserStore.EMPTY_STRING);
    }
}
