package pe.tohure.designpatternswithtests.util;

/**
 * Created by tohure on 11/02/18.
 */

public interface BasePresenter<V> {

    void attachedView(V view);

    void detachView();
}
