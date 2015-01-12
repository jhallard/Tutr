//package com.ucsc.teamtutor.tutr.Model;
//
//import android.content.Context;
//import android.os.AsyncTask;
//import android.util.Pair;
//import android.widget.Toast;
//
//import com.tutr.libtutr.Model.*;
//import com.ucsc.teamtutor.tutrappengine.backEndNodeApi.BackEndNodeApi;
//import com.google.api.client.extensions.android.http.AndroidHttp;
//import com.google.api.client.extensions.android.json.AndroidJsonFactory;
//import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
//import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
//
//
//import java.io.IOException;
//
///**
// * Created by jhallard on 1/11/15.
// */
//public class EndPointAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
//    private static BackEndNodeApi myApiService = null;
//    private Context context;
//
//    @Override
//    protected String doInBackground(Pair<Context, String>... params) {
//        if(myApiService == null) {  // Only do this once
//            BackEndNodeApi.Builder builder = new BackEndNodeApi.Builder(AndroidHttp.newCompatibleTransport(),
//                    new AndroidJsonFactory(), null)
//                    // options for running against local devappserver
//                    // - 10.0.2.2 is localhost's IP address in Android emulator
//                    // - turn off compression when running against local devappserver
//                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
//                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
//                        @Override
//                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
//                            abstractGoogleClientRequest.setDisableGZipContent(true);
//                        }
//                    });
//            // end options for devappserver
//
//            myApiService = builder.build();
//        }
//
//        context = params[0].first;
//        String name = params[0].second;
//
//        try {
//            return myApiService.verifyUserInfo(name,"").execute().getData();
//        } catch (IOException e) {
//            return e.getMessage();
//        }
//        return "";
//    }
//
//    @Override
//    protected void onPostExecute(String result) {
//        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
//    }
//}