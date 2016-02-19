package gem.androidtraining3.enterprisenetwork.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import gem.androidtraining3.enterprisenetwork.R;

/**
 * Created by huylv on 17/02/2016.
 */
public class Util {
    public static boolean LOGGED_IN = false;
    public static final String ServerURL = "http://172.16.10.67:8080";

    public static boolean ONBACKPRESS=false;



    public static String getValidString(String str) {
        try {
            if (str == null || str.equals("null")) {
                return "";
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        return str;
    }

    public static boolean networkConnected(Activity activity) {
        if (checkNetwork(activity)) {
            return true;
        } else {
            // Show msg
            showDialogNetworkProblem(activity);
            return false;
        }
    }

    public static void showDialogNetworkProblem(Activity activity) {
        showOkDialog(
                activity,
                activity.getString(R.string.dialog_title_common),
                activity.getString(R.string.dialog_title_content_network_problem),
                        null);
    }

    public static Dialog showOkDialog(Context context, String title,
                                      String message, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("Ok", onClickListener);
        builder.show();
        return builder.create();
    }

    public static Dialog showErrorDialog(Context context,
                                      String message) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Error");
        builder.setMessage(message);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
        return builder.create();
    }

    public static boolean checkNetwork(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (networkInfo != null) {
            if (networkInfo.isConnected()) {
                return true;
            }
        }
        return false;
    }
}
