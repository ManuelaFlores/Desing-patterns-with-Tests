package pe.tohure.designpatternswithtests.util;

import java.io.IOException;
import java.io.InputStream;

import pe.tohure.designpatternswithtests.app.DesignPatternApplication;
import pe.tohure.desingpatternswithtests.R;

/**
 * Created by tohure on 11/02/18.
 */

public class Helper {

    private Helper() {
        throw new IllegalStateException("Helper Class");
    }

    public static String getAssetsJSON(String fileName) {
        String json = null;
        try {
            InputStream inputStream = DesignPatternApplication.getAppContext().getAssets().open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }

    public static String getSolesValueMont(int value) {
        return String.format(
                DesignPatternApplication.getAppContext().getString(R.string.mount_account),
                value);
    }

    public static int getTextBalanceAvailable(boolean isBalanceAvailable) {
        if (isBalanceAvailable) {
            return R.string.balance_available;
        } else {
            return R.string.balance_not_available;
        }
    }

}
