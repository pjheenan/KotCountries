package com.philheenan.core;

import java.util.*;

/**
 * @author Phil Heenan (pjheenan@gmail.com)
 */
public interface IResourceWrapper {

    Locale getLocale();

    String stringFromId(int resourceId);

    String stringFromName(String name);

    String stringFromName(String name, Object... formatArgs);

    String stringFromPlural(String name, int count, Object... formatArgs);

    Map<String, ?> getAllPrefs();

    String getPreference(String key, String defValue);

    Set<String> getPreference(String key, Set<String> defValues);

    int getPreference(String key, int defValue);

    long getPreference(String key, long defValue);

    float getPreference(String key, float defValue);

    boolean getPreference(String key, boolean defValue);

    Editor prefsEdit();

    public interface Editor {

        void put(String key, String value);

        void put(String key, Set<String> values);

        void put(String key, int value);

        void put(String key, long value);

        void put(String key, float value);

        void put(String key, boolean value);

        void remove(String key);

        void clear();

        boolean commit();

        void apply();
    }

}
