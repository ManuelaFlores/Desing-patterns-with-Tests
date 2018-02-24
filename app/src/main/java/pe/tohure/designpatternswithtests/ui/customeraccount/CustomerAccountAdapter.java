package pe.tohure.designpatternswithtests.ui.customeraccount;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pe.tohure.designpatternswithtests.app.DesignPatternApplication;
import pe.tohure.designpatternswithtests.data.model.CustomerAccount;
import pe.tohure.designpatternswithtests.util.Helper;
import pe.tohure.desingpatternswithtests.R;

/**
 * Created by tohure on 11/02/18.
 */

public class CustomerAccountAdapter extends
        RecyclerView.Adapter<CustomerAccountAdapter.CustomerAccountItemViewHolder> {

    //Listener for event clicks
    public interface OnClickAccountListener {
        void onAccoutItemClick(CustomerAccount.CustomeraccountsBean customeraccount);
    }

    private OnClickAccountListener listener;

    void setOnAccountClickListener(OnClickAccountListener listener) {
        this.listener = listener;
    }

    private List<CustomerAccount.CustomeraccountsBean> customerAccountList;
    private Context context;

    CustomerAccountAdapter() {
        this.customerAccountList = new ArrayList<>();
        this.context = DesignPatternApplication.getAppContext();
    }

    void addData(List<CustomerAccount.CustomeraccountsBean> customerAccountList) {
        this.customerAccountList.addAll(customerAccountList);
        notifyDataSetChanged();
    }

    @Override
    public CustomerAccountItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_customer_account, parent, false);

        return new CustomerAccountItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomerAccountItemViewHolder holder, int position) {
        holder.lblName.setText(customerAccountList.get(position).getName());
        holder.lblMount.setText(Helper.getSolesValueMont(customerAccountList.get(position).getMount()));
        holder.lblAvailable.setText(Helper.getTextBalanceAvailable(customerAccountList.get(position).isBalanceAvailable()));
    }

    @Override
    public int getItemCount() {
        return customerAccountList.size();
    }

    class CustomerAccountItemViewHolder
            extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private TextView lblName;
        private TextView lblMount;
        private TextView lblAvailable;

        CustomerAccountItemViewHolder(View itemView) {
            super(itemView);
            lblName = itemView.findViewById(R.id.lblName);
            lblMount = itemView.findViewById(R.id.lblMount);
            lblAvailable = itemView.findViewById(R.id.lblAvailable);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (listener != null) {
                listener.onAccoutItemClick(customerAccountList.get(getAdapterPosition()));
            }
        }
    }
}
