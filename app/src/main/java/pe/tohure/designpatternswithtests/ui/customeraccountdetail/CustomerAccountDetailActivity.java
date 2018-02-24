package pe.tohure.designpatternswithtests.ui.customeraccountdetail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import pe.tohure.designpatternswithtests.data.model.CustomerAccount;
import pe.tohure.designpatternswithtests.util.Constant;
import pe.tohure.designpatternswithtests.util.Helper;
import pe.tohure.desingpatternswithtests.R;

public class CustomerAccountDetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_account_detail);
        init();
    }

    private void init() {
        //Init UI
        TextView lblName = findViewById(R.id.lblName);
        TextView lblMount = findViewById(R.id.lblMount);
        TextView lblAvailable = findViewById(R.id.lblAvailable);

        //Get intent data
        Intent detailIntent = getIntent();
        CustomerAccount.CustomeraccountsBean customeraccount =
                (CustomerAccount.CustomeraccountsBean) detailIntent
                        .getSerializableExtra(Constant.DETAIL_ACCOUNT);

        //Print data
        lblName.setText(customeraccount.getName());
        lblMount.setText(Helper.getSolesValueMont(customeraccount.getMount()));
        lblAvailable.setText(Helper.getTextBalanceAvailable(customeraccount.isBalanceAvailable()));
    }
}
