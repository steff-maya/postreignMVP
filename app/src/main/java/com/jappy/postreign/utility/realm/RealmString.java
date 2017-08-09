package com.jappy.postreign.utility.realm;

import io.realm.RealmObject;

/**
 * Created by jappy on 08-08-17.
 */
public class RealmString extends RealmObject {
    private String val;

    public String getValue() {
        return val;
    }

    public void setValue(String value) {
        this.val = value;
    }
}