package pe.tohure.designpatternswithtests.ui.customeraccount;

import java.util.List;

import pe.tohure.designpatternswithtests.data.model.CustomerAccount;

/**
 * Created by tohure on 11/02/18.
 */

public class CustomerAccountPresenterImp implements
        CustomerAccountContract.Presenter,
        CustomerAccountContract.Callback {

    private CustomerAccountInteractorImp customerAccountInteractor;
    private CustomerAccountContract.View customerAccountView;

    CustomerAccountPresenterImp() {
        this.customerAccountInteractor = new CustomerAccountInteractorImp();
    }

    @Override
    public void attachedView(CustomerAccountContract.View customerAccountView) {
        this.customerAccountView = customerAccountView;
    }

    @Override
    public void detachView() {
        customerAccountView = null;
    }

    @Override
    public void listCustomerAccounts() {
        customerAccountView.showLoading();
        customerAccountInteractor.getAccounts(this);
    }

    @Override
    public void getAccountsSucces(List<CustomerAccount.CustomeraccountsBean> customerAccountList) {
        customerAccountView.showAccounts(customerAccountList);
        customerAccountView.hideLoading();
    }

    @Override
    public void getAccountsError(String error) {
        customerAccountView.showAccountError(error);
        customerAccountView.hideLoading();
    }

}
