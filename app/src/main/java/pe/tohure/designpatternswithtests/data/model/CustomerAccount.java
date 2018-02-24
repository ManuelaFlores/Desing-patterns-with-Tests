package pe.tohure.designpatternswithtests.data.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tohure on 11/02/18.
 */

public class CustomerAccount {

    private List<CustomeraccountsBean> customeraccounts;

    public List<CustomeraccountsBean> getCustomeraccounts() {
        return customeraccounts;
    }

    public void setCustomeraccounts(List<CustomeraccountsBean> customeraccounts) {
        this.customeraccounts = customeraccounts;
    }

    public static class CustomeraccountsBean implements Serializable {

        private String name;
        private int mount;
        private boolean balanceAvailable;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getMount() {
            return mount;
        }

        public void setMount(int mount) {
            this.mount = mount;
        }

        public boolean isBalanceAvailable() {
            return balanceAvailable;
        }

        public void setBalanceAvailable(boolean balanceAvailable) {
            this.balanceAvailable = balanceAvailable;
        }
    }
}
