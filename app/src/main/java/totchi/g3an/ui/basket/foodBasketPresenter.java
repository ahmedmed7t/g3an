package totchi.g3an.ui.basket;

import android.support.annotation.MainThread;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import totchi.g3an.data.DataManager;
import totchi.g3an.data.remote.model.addNewOrder.addOrderRequest;
import totchi.g3an.data.remote.model.addNewOrder.addOrderResponse;
import totchi.g3an.data.remote.model.beforeConfirmOrder;
import totchi.g3an.data.remote.model.beforeOrder;
import totchi.g3an.data.remote.model.orderItem;
import totchi.g3an.ui.base.BasePresenter;

/**
 * Created by Medhat on 29/09/2018.
 */

public class foodBasketPresenter extends BasePresenter<foodBasketView>{

   final foodBasketActivity activity = new foodBasketActivity();

   @Inject
    DataManager dataManager;

    public void addToArray(ArrayList<beforeConfirmOrder> arrayList , orderItem item) {

        boolean flag = false;

        if (arrayList.size() == 0) {
            ArrayList<beforeOrder> arr = new ArrayList<beforeOrder>();
            arr.add(item.getOrder());
            arrayList.add(new beforeConfirmOrder(item.getChiefImage(), item.getChiefName(), arr));
        } else {

            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).getChiefName().equals(item.getChiefName())) {
                    arrayList.get(i).getBeforeOrders().add(item.getOrder());
                    flag = true;
                }
            }
            if (!flag) {
                ArrayList<beforeOrder> array = new ArrayList<beforeOrder>();
                array.add(item.getOrder());
                arrayList.add(new beforeConfirmOrder(item.getChiefImage(), item.getChiefName(), array));
            }
        }
        calcTotal();
    }


    public static void calcTotal(){

        foodBasketActivity.totalPrice =0;
        int size = foodBasketActivity.items.size();
        if(size == 0)
        {
            foodBasketActivity.totalPrice = 0;
        }

        for (int i =0 ; i<size ;i++)
        {
            int nsize = foodBasketActivity.items.get(i).getBeforeOrders().size();
            ArrayList<beforeOrder> arr = foodBasketActivity.items.get(i).getBeforeOrders();
            for (int j =0 ; j < nsize ; j++)
            {
                foodBasketActivity.totalPrice += (arr.get(j).getQuantity() * arr.get(j).getPlatePrice());
            }
        }
    }

    public static void filterArray()
    {
        int size = foodBasketActivity.items.size();
        for(int i = 0 ; i< size ; i++)
        {
            int nsize = foodBasketActivity.items.get(i).getBeforeOrders().size();
            for(int j =0 ; j < nsize ; j++)
            {
                if(foodBasketActivity.items.get(i).getBeforeOrders().get(j).isDelete())
                {
                    foodBasketActivity.items.get(i).getBeforeOrders().remove(j);
                    j--;
                    nsize--;
                }
            }

            if(foodBasketActivity.items.get(i).getBeforeOrders().size() ==0)
            {
                foodBasketActivity.items.remove(i);
                i--;
                size--;
            }
        }

        calcTotal();
        foodBasketActivity.presentTotal();
        foodBasketActivity.displayarray();
    }

    public void addOrders(String address){

       int size = foodBasketActivity.items.size();
        for (int i =0 ; i<size ; i++) {

            int nsize = foodBasketActivity.items.get(i).getBeforeOrders().size();
            for(int j =0 ; j<nsize ; j++) {
                dataManager.addOrder(new addOrderRequest(foodBasketActivity.items.get(i).getBeforeOrders().get(j).getId(), foodBasketActivity.userID, foodBasketActivity.items.get(i).getBeforeOrders().get(j).getQuantity(),address))
                        .subscribeOn(Schedulers.single()).observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new SingleObserver<addOrderResponse>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onSuccess(addOrderResponse addOrderResponse) {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        });
            }
        }
    }

    public void checkMultiChief()
    {
        if(foodBasketActivity.items.size()>1)
        {
            getMvpView().showDialog();
        }
    }

}
