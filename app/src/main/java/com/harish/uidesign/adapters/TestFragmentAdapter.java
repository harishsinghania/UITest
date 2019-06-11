package com.harish.uidesign.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.harish.uidesign.R;


public class TestFragmentAdapter extends PagerAdapter {
    private int[] imgItem = {
            R.drawable.ic_add,
            R.drawable.ic_add,
            R.drawable.ic_add};

    private String[] itemStatus = {
            "Rs. 1 to 49",
            "Rs. 1 to 49",
            "Rs. 1 to 49"};

    private Context context;
    private String[] itemList;

    public TestFragmentAdapter(String[] itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @SuppressLint("RestrictedApi")
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        View itemView = LayoutInflater.from(container.getContext())
                .inflate(R.layout.view_pager_item, container, false);
        RelativeLayout rlRoot = itemView.findViewById(R.id.rl_root);
        TextView tvTitle = itemView.findViewById(R.id.txt_item_title);
        TextView tvStatus = itemView.findViewById(R.id.txt_item_status);
        ImageView imgIcon = itemView.findViewById(R.id.img_item_icon);
        tvTitle.setText(itemList[position]);
        tvStatus.setText(itemStatus[position]);
        imgIcon.setImageResource(imgItem[position]);
        switch (position) {
            case 0:
                rlRoot.setBackgroundResource(R.drawable.card_blue_back);
                break;
            case 1:
                rlRoot.setBackgroundResource(R.drawable.card_red_back);
                break;
            case 2:
                rlRoot.setBackgroundResource(R.drawable.card_green_back);
                break;
            default:
                rlRoot.setBackgroundResource(R.drawable.card_blue_back);
                break;
        }


        container.addView(itemView);

        return itemView;
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return itemList.length;
    }

}