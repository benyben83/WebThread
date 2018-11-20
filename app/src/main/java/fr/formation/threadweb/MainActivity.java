package fr.formation.threadweb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    HttpClient client;
    WebView web;
    EditText etUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getUrl(View view) {
        etUrl = findViewById(R.id.etUrl);
        client = new HttpClient();
        web =findViewById(R.id.wvPage);
        client.setAdr(etUrl.getText().toString());
        client.start();
        try{
            client.join();
            String reponse = client.getResponse();
            web.loadData(reponse, "text/html", "utf-8");
        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
