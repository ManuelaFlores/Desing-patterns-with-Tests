package pe.tohure.desingpatternswithtests;

import com.google.gson.Gson;

import org.junit.Test;

import java.io.InputStream;

import pe.tohure.designpatternswithtests.ui.customeraccount.CustomerAccountContract;
import pe.tohure.designpatternswithtests.ui.customeraccount.CustomerAccountInteractorImp;
import pe.tohure.designpatternswithtests.ui.data.model.CustomerAccount;
import pe.tohure.desingpatternswithtests.util.HelperLocalTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class CustomerAccountUnitTest {

    private static final String DUMMY_DATA = "dummy_data.json";

    @Test
    public void readTestFile() throws Exception {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(DUMMY_DATA);

        String s = HelperLocalTest.readTextStream(inputStream);
        assertThat(s, notNullValue());
    }

    @Test
    public void convertGsonClass() throws Exception {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(DUMMY_DATA);
        String s = HelperLocalTest.readTextStream(inputStream);

        Gson gson = new Gson();
        CustomerAccount customerAccount = gson.fromJson(s, CustomerAccount.class);

        assertThat(customerAccount, notNullValue());
    }

    @Test
    public void verifyInteractorRequiredOnlyOnce() {
        CustomerAccountInteractorImp customerAccountInteractor = mock(CustomerAccountInteractorImp.class);
        CustomerAccountContract.Callback callback = mock(CustomerAccountContract.Callback.class);
        verifyNoMoreInteractions(customerAccountInteractor);
        customerAccountInteractor.getAccounts(callback);
        verify(customerAccountInteractor, times(1)).getAccounts(callback);
    }
    
}