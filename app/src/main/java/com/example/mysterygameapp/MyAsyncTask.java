package com.example.mysterygameapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mysterygameapp.modelsDB.Item;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MyAsyncTask extends AppCompatActivity {

    private TextView tvAsync;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_async_task);

        ListView listView = (ListView) findViewById(R.id.lv);

        tvAsync = (TextView) findViewById(R.id.tvAsync);
        Button btnAsync = (Button) findViewById(R.id.btnAsync);

        btnAsync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new JsonTask().execute("https://api.myjson.com/bins/2ktot");
            }
        });
    }

    public class JsonTask extends AsyncTask<String, String, ArrayList<Item>> {

        @Override
        protected ArrayList<Item> doInBackground(String... params) {

            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]); //1
                connection = (HttpURLConnection) url.openConnection();//2
                connection.connect();

                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();

                String line = "";
                while ( (line=reader.readLine()) != null ){
                    buffer.append(line);
                }

                String jsonResult = buffer.toString();
                //ArrayList<Item> itemList = new ArrayList<>();
                //itemList= new JsonToObject().toItem(jsonResult);

                JSONObject parentObj = new JSONObject(jsonResult); //3
                JSONArray parentArray = parentObj.getJSONArray("items");

                ArrayList<Item> itemList = new ArrayList<>();

                for (int i=0; i<parentArray.length(); i++){
                    JSONObject object = parentArray.getJSONObject(i);

                    Item item = new Item();
                    item.setId(object.getInt("id"));
                    item.setName(object.getString("name"));
                    item.setLat(object.getDouble("lat"));
                    item.setLng(object.getDouble("lng"));

                    itemList.add(item);
                }

                return itemList;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if (connection != null){
                    connection.disconnect();
                }
                try {
                    if (reader != null){
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            return null;
        }

        @Override
        protected void onPostExecute(ArrayList<Item> result) {
            super.onPostExecute(result);

            //use result list of items
            //tvAsync.setText(result);
        }
    }


}


