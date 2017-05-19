package cilok.com.lapakjahit.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.android.volley.RequestQueue;

import java.util.ArrayList;

import cilok.com.lapakjahit.callback.GetFavoritesCallback;
import cilok.com.lapakjahit.callback.InboxMessageLoadedListener;
import cilok.com.lapakjahit.entity.InboxMessage;
import cilok.com.lapakjahit.extras.MessageUtils;
import cilok.com.lapakjahit.network.VolleySingleton;

/**
 * Created by Gilbert on 5/14/2017.
 */

public class TaskLoadInboxMessage extends AsyncTask<Void,Void, ArrayList<InboxMessage>> {
    private InboxMessageLoadedListener myComponent;
    private VolleySingleton volleySingleton;
    private RequestQueue requestQueue;
    private ProgressDialog progressDialog;
    public TaskLoadInboxMessage(InboxMessageLoadedListener myComponent, Context context){
        this.myComponent = myComponent;
        volleySingleton = VolleySingleton.getInstance();
        requestQueue = volleySingleton.getRequestQueue();
    }




    @Override
    protected ArrayList<InboxMessage> doInBackground(Void... voids) {
        ArrayList<InboxMessage> listInbox = MessageUtils.loadInboxMessage(requestQueue);
        return listInbox;
    }

    @Override
    protected void onPostExecute(ArrayList<InboxMessage> listinboxMessages) {
        progressDialog.dismiss();
        if (myComponent != null){
            myComponent.onInboxMessageLoadedListener(listinboxMessages);
        }
    }
}
