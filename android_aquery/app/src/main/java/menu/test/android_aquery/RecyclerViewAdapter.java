package menu.test.android_aquery;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dsm2016 on 2017-07-03.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
{

    List<Data> itemList;
    Context context;

    public RecyclerViewAdapter(Context context, ArrayList<Data> itemList)
    {
        this.context=context;
        this.itemList=itemList;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_content_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position)
    {
        holder.textView.setText((position+1)+"번: "+itemList.get(position).getTitle());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,ContentActivity.class);
                intent.putExtra("no",itemList.get(position).getHomeNumber());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount()
    {
        return itemList.size();
    }

    public static class  ViewHolder extends  RecyclerView.ViewHolder
    {
        public TextView textView;
        public CardView cardView;
        public ViewHolder(View v){
            super(v);
            textView=v.findViewById(R.id.textView1);
            cardView=v.findViewById(R.id.cardView);
        }
    }
}
