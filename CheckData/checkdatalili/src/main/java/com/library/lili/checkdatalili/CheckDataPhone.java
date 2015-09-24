package com.library.lili.checkdatalili;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by lili on 15/6/5.
 */
public class CheckDataPhone {
    //LiLi
    //checkPhone(Context,strToCheck,callBackPhoneCheck);
    //is real =true
    //is error =false and error code.

    public static boolean checkPhone(Context context, String strToCheck, CallBackPhoneCheck callBackPhoneCheck) {
        if (CheckDataPhone.checkEmpty(context, strToCheck, callBackPhoneCheck)) {
            if (CheckDataPhone.checkPhoneisNotTen(context, strToCheck, callBackPhoneCheck)) {
                return true;
            }
        }
        return false;
    }

    private static Boolean checkEmpty(Context context, String strToCheck, CallBackPhoneCheck callBackPhoneCheck) {
        if (strToCheck.isEmpty()) {
            callBackPhoneCheck.errorString("手機號碼"+context.getString(R.string.check_warm_empty));
            callBackPhoneCheck.errorCode(0);
            return false;
        }
        return true;
    }

    private static boolean checkPhoneisNotTen(Context context, String PhoneNumber, CallBackPhoneCheck callBackPhoneCheck) {
//        若填入手機號碼未達10碼或不是09開頭，Alert「手機號碼不正確，請重新輸入」
        String subTest = "";
        if (PhoneNumber.length() == 10) {
            subTest = PhoneNumber.substring(0, 2);
            if (!subTest.equals("09")) {
                callBackPhoneCheck.errorString(context.getString(R.string.check_warm_format));
                callBackPhoneCheck.errorCode(2);
                return false;
            } else {
                return true;
            }
        } else {
            callBackPhoneCheck.errorString(context.getString(R.string.check_warm_length));
            callBackPhoneCheck.errorCode(1);
            return false;
        }
    }

    public interface CallBackPhoneCheck {

        void errorString(String warm);

        void errorCode(int warmCode);

    }

}
