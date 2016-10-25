package recycler.xhf.asus.myrecyclerview.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import recycler.xhf.asus.myrecyclerview.R;
import recycler.xhf.asus.myrecyclerview.bean.Data;

/**
 * Created by Administrator on 2016/10/24.
 */
public class Fragment1adapter extends BaseAdapter{

    private  Context context;
    private List<Data.DataEntity.ForumListEntity> forum_list;

    public Fragment1adapter(Context context, List<Data.DataEntity.ForumListEntity> forum_list) {

        this.context=context;
        this.forum_list=forum_list;

    }

    @Override
    public int getCount() {
        return forum_list.size();
    }

    @Override
    public Object getItem(int position) {
        return forum_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View converView = View.inflate(context, R.layout.layout_text,null);
        TextView tv = (TextView) converView.findViewById(R.id.tv);
        tv.setText(forum_list.get(position).name);
        return converView;
    }
}
