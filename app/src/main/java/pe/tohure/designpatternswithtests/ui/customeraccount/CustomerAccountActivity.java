package pe.tohure.designpatternswithtests.ui.customeraccount;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import pe.tohure.designpatternswithtests.ui.customeraccountdetail.CustomerAccountDetailActivity;
import pe.tohure.designpatternswithtests.ui.data.model.CustomerAccount;
import pe.tohure.designpatternswithtests.util.Constant;
import pe.tohure.desingpatternswithtests.R;

public class CustomerAccountActivity extends Activity implements
        CustomerAccountContract.View,
        CustomerAccountAdapter.OnClickAccountListener {

    private ProgressBar progressBar;
    protected RecyclerView rvCustomerAccount;

    private CustomerAccountAdapter customerAccountAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        //Init UI Elements
        progressBar = findViewById(R.id.progresBar);
        rvCustomerAccount = findViewById(R.id.rvCustomerAccount);
        rvCustomerAccount.setHasFixedSize(true);

        //Initialise presenter
        CustomerAccountPresenterImp customerAccountPresenter = new CustomerAccountPresenterImp();
        customerAccountPresenter.attachedView(this);

        //Init Adapter
        customerAccountAdapter = new CustomerAccountAdapter();
        rvCustomerAccount.setAdapter(customerAccountAdapter);
        customerAccountAdapter.setOnAccountClickListener(this);

        //Init download data (dummy)
        customerAccountPresenter.listCustomerAccounts();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
        rvCustomerAccount.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
        rvCustomerAccount.setVisibility(View.VISIBLE);
    }

    @Override
    public void showAccounts(List<CustomerAccount.CustomeraccountsBean> customerAccountList) {
        customerAccountAdapter.addData(customerAccountList);
    }

    @Override
    public void showAccountError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onAccoutItemClick(CustomerAccount.CustomeraccountsBean customeraccount) {
        Intent intent = new Intent(this, CustomerAccountDetailActivity.class);
        intent.putExtra(Constant.DETAIL_ACCOUNT, customeraccount);
        startActivity(intent);
    }
}
