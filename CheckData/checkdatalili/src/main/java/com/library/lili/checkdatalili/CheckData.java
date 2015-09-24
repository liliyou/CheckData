package com.library.lili.checkdatalili;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;


import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by lili on 15/6/5.
 */
public class CheckData {
    /**
     * CheckData.checkEmpty(Activity, 欲辨別的欄位, 跳出Ｔitle, 說明）
     */
    public static Boolean checkEmpty(Activity context, String strToCheck, String title, String warm) {
        warm = warm + context.getString(R.string.check_warm_empty);
        if (strToCheck.isEmpty()) {
            DialogOneBtn cdd = new DialogOneBtn(context, title, warm);
            cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            cdd.show();
            return false;
        }
        return true;
    }

    /**
     * CheckData.checkEmpty(Activity, 欲辨別的欄位,若相等的值, 跳出Ｔitle, 說明）
     */
    public static Boolean checkEmpty(Activity context, String strToCheck, String strToCheck2, String title, String warm) {
        warm = warm + context.getString(R.string.check_warm_empty);
        if (strToCheck.isEmpty()) {
            DialogOneBtn cdd = new DialogOneBtn(context, title, warm);
            cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            cdd.show();
            return false;
        }
        return true;
    }

    /**
     * CheckData.checkEmpty(Activity, 欲辨別的欄位）
     */
    public static Boolean checkEmpty(Activity context, String strToCheck) {
        if (strToCheck.isEmpty()) {
            DialogOneBtn cdd = new DialogOneBtn(context, context.getString(R.string.dialog_reminder), "不能為空");
            cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            cdd.show();
            return false;
        }
        return true;
    }

    //VerifyEmail
    public static final Pattern EMAIL_PATTERN = Pattern
            .compile("^\\w+\\.*\\w+@(\\w+\\.){1,5}[a-zA-Z]{2,3}$");

    public static boolean isVerifyEmail(Activity context, String email) {
        boolean result = false;
        if (EMAIL_PATTERN.matcher(email).matches()) {
            result = true;
        } else {
            DialogOneBtn cdd = new DialogOneBtn(context, context.getString(R.string.dialog_reminder), context.getString(R.string.check_email));
            cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            cdd.show();
        }
        return result;
    }

    public static boolean checkPhone(Activity context, String strToCheck) {
        if (CheckData.checkEmpty(context, strToCheck, context.getString(R.string.dialog_reminder), context.getString(R.string.check_mobile))) {
            if (CheckData.checkPhoneisNotTen(context, strToCheck)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkPhoneisNotTen(Activity context, String PhoneNumber) {
//        若填入手機號碼未達10碼或不是09開頭，Alert「手機號碼不正確，請重新輸入」
        String subTest = "";
        if (PhoneNumber.length() > 2) {
            subTest = PhoneNumber.substring(0, 2);
            if (!subTest.equals("09") || PhoneNumber.length() < 10 || PhoneNumber.length() > 10) {
                DialogOneBtn cdd = new DialogOneBtn(context, context.getString(R.string.dialog_reminder), context.getString(R.string.register_dialog_fail_passworld));
                cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                cdd.show();
                return false;
            } else {
                return true;
            }
        } else {

            DialogOneBtn cdd = new DialogOneBtn(context, context.getString(R.string.dialog_reminder), context.getString(R.string.register_dialog_fail_passworld));
            cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            cdd.show();
            return false;
        }
    }

    public static Boolean checkLength(Activity context, String strToCheck, String title, String warm, int startNum, int endNum) {

        if (strToCheck.length() >= startNum && strToCheck.length() <= endNum) {
        } else {
            DialogOneBtn cdd = new DialogOneBtn(context, title, warm);
            cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            cdd.show();
            return false;
        }
        return true;
    }

    public static Boolean checkPassword(Activity context, String strToCheck, String warm, int startNum, int endNum) {
//        String warm = "密碼";
        if (checkLengthPassword(context, strToCheck, context.getString(R.string.dialog_reminder), warm, startNum, endNum)) {
//            if (checkLower(context, strToCheck,warm)) {
//                if (checkUpper(context, strToCheck, warm)) {
//                    if (checkDigit(context, strToCheck, warm)) {
//                        return true;
//                    }
//                }
//            }
            return true;
        }
        return false;
    }

    public static Boolean checkLengthPassword(Activity context, String strToCheck, String title, String warm, int startNum, int endNum) {

        //if (strToCheck.length() < startNum || strToCheck.length() > endNum) {
        if (strToCheck.length() == 0) {
            DialogOneBtn cdd = new DialogOneBtn(context, title, context.getResources().getString(R.string.register_base_remind));
            cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            cdd.show();
            return false;
        } else {
            return true;
        }
    }

    public static Boolean checkLower(Activity context, String strToCheck, String warm) {
        Boolean haveLower = false;
        char[] charArray = strToCheck.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isLowerCase(charArray[i])) {
                haveLower = true;
            }

        }

        if (!haveLower) {
            DialogOneBtn cdd = new DialogOneBtn(context, context.getString(R.string.dialog_reminder), warm + "沒有包含小寫");
            cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            cdd.show();
        }
        return haveLower;
    }

    public static Boolean checkUpper(Activity context, String strToCheck, String warm) {
        Boolean haveUpper = false;
        char[] charArray = strToCheck.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isUpperCase(charArray[i])) {
                haveUpper = true;
            }

        }
        if (!haveUpper) {
            DialogOneBtn cdd = new DialogOneBtn(context, context.getString(R.string.dialog_reminder), warm + "沒有包含大寫");
            cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            cdd.show();
        }
        return haveUpper;
    }

    public static Boolean checkDigit(Activity context, String strToCheck, String warm) {
        Boolean haveDigit = false;
        char[] charArray = strToCheck.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isDigit(charArray[i])) {
                haveDigit = true;
            }

        }
        if (!haveDigit) {
            DialogOneBtn cdd = new DialogOneBtn(context, context.getString(R.string.dialog_reminder), warm + "沒有包含數字");
            cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            cdd.show();
        }
        return haveDigit;
    }

    //    public boolean checKPhoneUnfilled(String PhoneNumber) {
////        若未填，Alert「請輸入手機號碼」
//        if (PhoneNumber.equals("")) {
//            DialogOneBtn cdd = new DialogOneBtn(mActivity, mActivity.getString(R.string.register_dialog_passworld_title), mActivity.getString(R.string.register_dialog_inter_passworld));
//            cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//            cdd.show();
//            return true;
//        }
//
//        return false;
//    }
//
//    public boolean checkPhoneisNotTen(String PhoneNumber) {
////        若填入手機號碼未達10碼或不是09開頭，Alert「手機號碼不正確，請重新輸入」
//        String subTest = PhoneNumber.substring(0, 2);
//        if (!subTest.equals("09") || PhoneNumber.length() < 10 || PhoneNumber.length() > 10) {
//            DialogOneBtn cdd = new DialogOneBtn(mActivity, mActivity.getString(R.string.register_dialog_passworld_title), mActivity.getString(R.string.register_dialog_fail_passworld));
//            cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//            cdd.show();
//            return true;
//        }
//        return false;
//    }
    //檢查身份證
    public static boolean checkSocial(Activity context, String str) {

        if (str == null || "".equals(str)) {

            DialogOneBtn cdd = new DialogOneBtn(context, context.getString(R.string.dialog_reminder), context.getString(R.string.dialog_reminder_social_num_wrong));
            cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            cdd.show();
            return false;
        }

        final char[] pidCharArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        // 原身分證英文字應轉換為10~33，這裡直接作個位數*9+10
        final int[] pidIDInt = {1, 10, 19, 28, 37, 46, 55, 64, 39, 73, 82, 2, 11, 20, 48, 29, 38, 47, 56, 65, 74, 83, 21, 3, 12, 30};

        // 原居留證第一碼英文字應轉換為10~33，十位數*1，個位數*9，這裡直接作[(十位數*1) mod 10] + [(個位數*9) mod 10]
        final int[] pidResidentFirstInt = {1, 10, 9, 8, 7, 6, 5, 4, 9, 3, 2, 2, 11, 10, 8, 9, 8, 7, 6, 5, 4, 3, 11, 3, 12, 10};

        // 原居留證第二碼英文字應轉換為10~33，並僅取個位數*6，這裡直接取[(個位數*6) mod 10]
        final int[] pidResidentSecondInt = {0, 8, 6, 4, 2, 0, 8, 6, 2, 4, 2, 0, 8, 6, 0, 4, 2, 0, 8, 6, 4, 2, 6, 0, 8, 4};

        str = str.toUpperCase();// 轉換大寫
        final char[] strArr = str.toCharArray();// 字串轉成char陣列
        int verifyNum = 0;

	/* 檢查身分證字號 */
        if (str.matches("[A-Z]{1}[1-2]{1}[0-9]{8}")) {
            // 第一碼
            verifyNum = verifyNum + pidIDInt[Arrays.binarySearch(pidCharArray, strArr[0])];
            // 第二~九碼
            for (int i = 1, j = 8; i < 9; i++, j--) {
                verifyNum += Character.digit(strArr[i], 10) * j;
            }
            // 檢查碼
            verifyNum = (10 - (verifyNum % 10)) % 10;
            if (verifyNum != Character.digit(strArr[9], 10)) {
                DialogOneBtn cdd = new DialogOneBtn(context, context.getString(R.string.dialog_reminder), context.getString(R.string.dialog_reminder_social_num_wrong));
                cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                cdd.show();
            }
            return verifyNum == Character.digit(strArr[9], 10);
        }

		/* 檢查統一證(居留證)編號 */
        verifyNum = 0;
        if (str.matches("[A-Z]{1}[A-D]{1}[0-9]{8}")) {
            // 第一碼
            verifyNum += pidResidentFirstInt[Arrays.binarySearch(pidCharArray, strArr[0])];
            // 第二碼
            verifyNum += pidResidentSecondInt[Arrays.binarySearch(pidCharArray, strArr[1])];
            // 第三~八碼
            for (int i = 2, j = 7; i < 9; i++, j--) {
                verifyNum += Character.digit(strArr[i], 10) * j;
            }
            // 檢查碼
            verifyNum = (10 - (verifyNum % 10)) % 10;
            if (verifyNum != Character.digit(strArr[9], 10)) {
                DialogOneBtn cdd = new DialogOneBtn(context, context.getString(R.string.dialog_reminder), context.getString(R.string.dialog_reminder_social_num_wrong));
                cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                cdd.show();
            }
            return verifyNum == Character.digit(strArr[9], 10);
        }
        DialogOneBtn cdd = new DialogOneBtn(context, context.getString(R.string.dialog_reminder), context.getString(R.string.dialog_reminder_social_num_wrong));
        cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        cdd.show();
        return false;
    }


}
