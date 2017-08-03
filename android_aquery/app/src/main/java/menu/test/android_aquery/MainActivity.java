package menu.test.android_aquery;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static int PAGE=1;
    private static int SUCCESS=200;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Data> itemList;
    private AQuery aQuery;
    private static String url = "http://dsm2015.cafe24.com/post/school/notice/list";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutManager = new LinearLayoutManager(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        aQuery = new AQuery(this);
        DataBinding();

    }

    public void DataBinding(){
        aQuery.ajax(url + "?page=" + PAGE, String.class, new AjaxCallback<String>() {
            @Override
            public void callback(String url, String response, AjaxStatus status) {
                //Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                try {

                    JSONArray jsonArray = new JSONArray(response);
                    Log.d("hello world",response);
                    if(status.getCode()==SUCCESS) {
                        itemList = getJSON(jsonArray);
                        recyclerViewAdapter = new RecyclerViewAdapter(getApplicationContext(), (ArrayList<Data>) itemList);
                        recyclerView.setAdapter(recyclerViewAdapter);
                    }else {
                        // 서버등등오류
                        // 처리는 나중에 열심히 하겠습니다!!
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public List<Data> getJSON(JSONArray jsonArray){
        List<Data> arrayList=new ArrayList<>();
        try {

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject noticeObject = jsonArray.getJSONObject(i);
                int category = noticeObject.getInt("Category");
                int number = noticeObject.getInt("Number");
                String title = noticeObject.getString("Title");
                String content = noticeObject.getString("Content");
                String date = noticeObject.getString("Date");
                int homeNumber = noticeObject.getInt("HomeNumber");
                arrayList.add(new Data(title, homeNumber)); //intent로 다음 액티비티에 넘겨줄 honeNumber
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return  arrayList;
    }
}
