package menu.test.android_aquery;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by dsm2016 on 2017-07-06.
 */

public class ContentActivity extends AppCompatActivity {

    private static int SUCCESS=200;
    private String url = "http://dsm2015.cafe24.com/post/school/notice";
    private AQuery aQuery = new AQuery(this);
    private Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Intent intent = getIntent();
        int no = intent.getIntExtra("no",1);


        aQuery.ajax(url + "?no=" + no, String.class, new AjaxCallback<String>() {
            @Override
            public void callback(String url, String response, AjaxStatus status) {
                Log.d("hello world", "callback: "+ url);
                try {
                    WebView webView=(WebView)findViewById(R.id.content);
                    TextView textView=(TextView)findViewById(R.id.title);
                    TextView noticeNumberText=(TextView)findViewById(R.id.noticeNumberText);
                    JSONObject jsonObject=new JSONObject(response);
                    if(status.getCode()==SUCCESS){
                        data=getJSON(jsonObject);
                        textView.setText(data.getTitle());
                        webView.loadData(data.getContent(), "text/html; charset=UTF-8",null);
                        noticeNumberText.setText("제목");
                    }else{
                        //서버오류
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    public Data getJSON(JSONObject jsonObject) throws JSONException{
        int category=jsonObject.getInt("Category");
        int number=jsonObject.getInt("Number");
        String content=jsonObject.getString("Content");
        String title=jsonObject.getString("Title");

        return new Data(title,content);
    }
}
