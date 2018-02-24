package pe.tohure.designpatternswithtests.ui.customeraccount;

import java.util.List;

import pe.tohure.designpatternswithtests.data.model.CustomerAccount;
import pe.tohure.designpatternswithtests.util.BasePresenter;

/**
 * Created by tohure on 11/02/18.
 */

public interface CustomerAccountContract {

    interface View {

        void showLoading();

        void hideLoading();

        void showAccounts(List<CustomerAccount.CustomeraccountsBean> customerAccountList);

        void showAccountError(String error);

    }

    interface Presenter extends BasePresenter<View> {

        void listCustomerAccounts();

    }

    interface Interactor {

        void getAccounts(Callback callback);
    }

    interface Callback {

        void getAccountsSucces(List<CustomerAccount.CustomeraccountsBean> customerAccountList);

        void getAccountsError(String error);
    }

}
