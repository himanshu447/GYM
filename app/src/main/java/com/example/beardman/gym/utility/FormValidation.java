package com.example.beardman.gym.utility;

import android.widget.EditText;

/**
 * Created by Beard Man on 2/16/2018.
 */

public class FormValidation {
    public static boolean isEditTextEmpty(EditText editTextUserName) {
        return editTextUserName.getText().toString().isEmpty();
    }
}
