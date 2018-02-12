package pe.tohure.designpatternswithtests.ui.customeraccount;

import com.google.gson.Gson;

import pe.tohure.designpatternswithtests.ui.data.model.CustomerAccount;
import pe.tohure.designpatternswithtests.util.Helper;

/**
 * Created by tohure on 11/02/18.
 */

public class CustomerAccountInteractorImp implements CustomerAccountContract.Interactor {

    private static final String DUMMY_DATA = "dummy_data.json";

    @Override
    public void getAccounts(CustomerAccountContract.Callback callback) {

        String jsonString = Helper.getAssetsJSON(DUMMY_DATA);

        Gson gson = new Gson();
        CustomerAccount customerAccount = gson.fromJson(jsonString, CustomerAccount.class);

        if (customerAccount.getCustomeraccounts().isEmpty()) {
            callback.getAccountsError("Empty List");
        } else {
            callback.getAccountsSucces(customerAccount.getCustomeraccounts());
        }

    }
}
