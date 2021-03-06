package recycler.xhf.asus.myrecyclerview.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import recycler.xhf.asus.myrecyclerview.R;
import recycler.xhf.asus.myrecyclerview.adapter.Fragment1adapter;
import recycler.xhf.asus.myrecyclerview.bean.Data;

/**
 * Created by Administrator on 2016/10/24.
 */
public class fragment1 extends Fragment {

    private String path = "http://open.qyer.com/qyer/bbs/entry?client_id=qyer_android&client_secret=9fcaae8aefc4f9ac4915";
    private GridView gv;
    private View view;
    private List<Data.DataEntity.ForumListEntity> forum_list;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //适配器
            gv.setAdapter(new Fragment1adapter(getActivity(),forum_list));
        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.layout_grid,null);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //获取数据
        getshuju();
        //获取控件
        gv = (GridView) view.findViewById(R.id.gv);


    }

    public void getshuju() {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(path).build();
        client.newCall(request).enqueue(new Callback() {



            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(getActivity(), "网络加载失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e("数据是========",string);
                Gson gson = new Gson();
                Data bean = gson.fromJson(string, Data.class);
                forum_list = bean.data.forum_list;
                Message msg = Message.obtain();
                msg.obj=forum_list;
                handler.sendMessage(msg);
            }
        });

    }

}
