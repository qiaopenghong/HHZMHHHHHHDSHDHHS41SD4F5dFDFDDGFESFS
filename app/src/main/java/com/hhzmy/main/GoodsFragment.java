package com.hhzmy.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by qiao on 2016/11/16.
 */
public class GoodsFragment extends Fragment{

    private TextView ding;
    private TextView address;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return View.inflate(getActivity(),R.layout.goods_item,null);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ding = (TextView)getView().findViewById(R.id.ding);
        address = (TextView) getView().findViewById(R.id.goods_address);

        ding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getActivity(),"hehe",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent();
                intent.setClass(getActivity(),LcationActivity.class);
                int requestcode=0;
                startActivityForResult(intent,requestcode);

            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        address.setText(data.getStringExtra("ding"));
    }
}
