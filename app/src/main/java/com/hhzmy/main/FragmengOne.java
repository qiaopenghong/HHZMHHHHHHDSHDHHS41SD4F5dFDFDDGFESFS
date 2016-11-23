package com.hhzmy.main;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.*;
import android.view.*;
import android.widget.*;
import com.hhzmy.main.com.hhzmy.adapter.*;
import com.hhzmy.main.com.hhzmy.bean.Data;
import com.hhzmy.main.com.hhzmy.com.hhzmy.listtner.RecyclerViewClickListener;
import com.hhzmy.main.com.hhzmy.okhttp.*;
import com.hhzmy.main.com.hhzmy.util.ImageLoaderUtils;
import com.nostra13.universalimageloader.core.*;
import java.io.IOException;
import java.util.*;
import okhttp3.*;
/**
 * Created by qiao on 2016/11/9.
 */
public class FragmengOne extends Fragment {
    private ViewPager home_vp;
    private String path = "http://mock.eoapi.cn/success/jSWAxchCQfuhI6SDlIgBKYbawjM3QIga";
    private LinearLayout ll;
    private List<Data.DataBean> d;
    private RecyclerView mrecyclerview, mrecyclerview1, mrecyclerview2, mrecyclerview3, mrecyclerview4;
    private RecyclerView mrecyclerview5, mrecyclerview6, mrecyclerview7, mrecyclerview8, mrecyclerview9, mrecyclerview10, mrecyclerview11;
    private HomeOneAdapter mAdapter1;
    private HomeAdapter mAdapter;
    private HomeFiveAdapter mAdapter5;
    private HomeSixAdapter mAdapter6;
    private ImageView home_title;
    private DisplayImageOptions options;
    private ImageView i;
    private ImageView home_aojiao,home_muyin,home_haiwai,home_bighui,home_lianghui,home_bie,home_lama,hl_one,hl_two,hl_three,hl_four,hl_five,hl_more,home_scan;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        DisplayImageOptions options = ImageLoaderUtils.initOptions();
        return View.inflate(getActivity(), R.layout.fragment_home, null);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        home_scan = (ImageView) getView().findViewById(R.id.home_scan);
        home_vp = (ViewPager) getView().findViewById(R.id.home_vp);//母婴主页导航页
        ll = (LinearLayout) getView().findViewById(R.id.home_vp_ll);//导航小圆点
        mrecyclerview = (RecyclerView) getView().findViewById(R.id.recyclserview);//签到领钱GridView
        mrecyclerview.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        mrecyclerview1 = (RecyclerView) getView().findViewById(R.id.recyclserview1); //10点秒杀GridView
        GridLayoutManager llm = new GridLayoutManager(getActivity(), 1);
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        mrecyclerview1.setLayoutManager(llm);
        home_aojiao = (ImageView) getView().findViewById(R.id.home_aojiao);
        //秒杀
        i = (ImageView) getView().findViewById(R.id.i);
        mrecyclerview5 = (RecyclerView) getView().findViewById(R.id.recyclserview5);
        mrecyclerview5.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mrecyclerview6 = (RecyclerView) getView().findViewById(R.id.recyclserview6);
        mrecyclerview6.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        home_title = (ImageView) getView().findViewById(R.id.home_title);
        home_muyin = (ImageView) getView().findViewById(R.id.home_myin);
        home_haiwai = (ImageView) getView().findViewById(R.id.home_haiwai);
        home_lianghui = (ImageView) getView().findViewById(R.id.home_lianghui);
        home_bie = (ImageView) getView().findViewById(R.id.home_bie);
        home_bighui = (ImageView) getView().findViewById(R.id.home_bighui);
        home_lama = (ImageView) getView().findViewById(R.id.home_lama);
        hl_one = (ImageView) getView().findViewById(R.id.hl_one);
        hl_two = (ImageView) getView().findViewById(R.id.hl_two);
        hl_three = (ImageView) getView().findViewById(R.id.hl_three);
        hl_four = (ImageView) getView().findViewById(R.id.hl_four);
        hl_five = (ImageView) getView().findViewById(R.id.hl_five);
        hl_more = (ImageView) getView().findViewById(R.id.hl_more);
        OkhttpHelper.getInstance().get(path, new BaseCallBack<Data>() {
            private List<Data.DataBean.TagBean> tag;
            @Override
            public void onRequsetBefore(Request request) {
            }
            @Override
            public void onFailure(Call call, IOException e) {
            }
            @Override
            public void onSuccess(Response response, Data data) {
                d = data.getData();
                //viewpager
                home_vp.setAdapter(new MyHomeAdapter(getActivity(), d));
                tu();
                mrecyclerview.setAdapter(mAdapter = new HomeAdapter(d));
                ImageLoader.getInstance().displayImage("http://image1.suning.cn" + d.get(2).getTag().get(0).getPicUrl(), i);
                mrecyclerview1.setAdapter(mAdapter1 = new HomeOneAdapter(d.get(2).getTag()));
                for (int num = 0; num < d.size(); num++) {
                    if (num == 5) {
                        tag = d.get(num).getTag();
                        mrecyclerview2 = (RecyclerView) getView().findViewById(R.id.recyclserview2);
                        mrecyclerview2.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                        mrecyclerview2.setAdapter(new HomeTwoAdapter(getContext(), tag));
                        intentJump(mrecyclerview2, num);
                    } else if (num == 6) {
                        tag = d.get(num).getTag();
                        mrecyclerview3 = (RecyclerView) getView().findViewById(R.id.recyclserview3);
                        mrecyclerview3.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                        mrecyclerview3.setAdapter(new HomeTwoAdapter(getContext(), tag));
                        intentJump(mrecyclerview3, num);
                    } else if (num == 7) {
                        tag = d.get(num).getTag();
                        mrecyclerview4 = (RecyclerView) getView().findViewById(R.id.recyclserview4);
                        mrecyclerview4.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                        mrecyclerview4.setAdapter(new HomeTwoAdapter(getContext(), tag));
                        intentJump(mrecyclerview4, num);
                    } else if (num == 15) {
                        tag = d.get(num).getTag();
                        LinearLayoutManager gr = new LinearLayoutManager(getActivity());
                        gr.setOrientation(gr.HORIZONTAL);
                        mrecyclerview7 = (RecyclerView) getView().findViewById(R.id.recyclserview7);
                        mrecyclerview7.setLayoutManager(gr);
                        mrecyclerview7.setAdapter(new HomeSameAdapter(getContext(), tag));
                        IntentJump1(mrecyclerview7,num);
                    } else if (num == 17) {
                        tag = d.get(num).getTag();
                        mrecyclerview8 = (RecyclerView) getView().findViewById(R.id.recyclserview8);
                        LinearLayoutManager gr_one = new LinearLayoutManager(getActivity());
                        gr_one.setOrientation(gr_one.HORIZONTAL);
                        mrecyclerview8.setLayoutManager(gr_one);
                        mrecyclerview8.setAdapter(new HomeSameAdapter(getContext(), tag));
                        IntentJump1(mrecyclerview8,num);
                    } else if (num == 19) {
                        tag = d.get(num).getTag();
                        mrecyclerview9 = (RecyclerView) getView().findViewById(R.id.recyclserview9);
                        LinearLayoutManager gr_two = new LinearLayoutManager(getActivity());
                        gr_two.setOrientation(gr_two.HORIZONTAL);
                        mrecyclerview9.setLayoutManager(gr_two);
                        mrecyclerview9.setAdapter(new HomeSameAdapter(getContext(), tag));
                        IntentJump1(mrecyclerview9,num);
                    } else if (num == 21) {
                        tag = d.get(num).getTag();
                        mrecyclerview10 = (RecyclerView) getView().findViewById(R.id.recyclserview10);
                        LinearLayoutManager gr_three = new LinearLayoutManager(getActivity());
                        gr_three.setOrientation(gr_three.HORIZONTAL);
                        mrecyclerview10.setLayoutManager(gr_three);
                        mrecyclerview10.setAdapter(new HomeSameAdapter(getContext(), tag));
                        IntentJump1(mrecyclerview10,num);
                    }
                }
                ImageLoader.getInstance().displayImage("http://image1.suning.cn" + d.get(4).getTag().get(0).getPicUrl(), home_aojiao, options);
                ImageLoader.getInstance().displayImage("http://image1.suning.cn" + d.get(9).getTag().get(0).getPicUrl(), home_muyin, options);
                mrecyclerview5.setAdapter(mAdapter5 = new HomeFiveAdapter(d));
                mrecyclerview6.setAdapter(mAdapter6 = new HomeSixAdapter(d));
                ImageLoader.getInstance().displayImage("http://image1.suning.cn" + d.get(13).getTag().get(0).getPicUrl(), home_title, options);
                ImageLoader.getInstance().displayImage("http://image1.suning.cn" + d.get(14).getTag().get(0).getPicUrl(), home_haiwai, options);
                ImageLoader.getInstance().displayImage("http://image1.suning.cn" + d.get(16).getTag().get(0).getPicUrl(), home_bighui, options);
                ImageLoader.getInstance().displayImage("http://image1.suning.cn" + d.get(18).getTag().get(0).getPicUrl(), home_lianghui, options);
                ImageLoader.getInstance().displayImage("http://image1.suning.cn" + d.get(20).getTag().get(0).getPicUrl(), home_bie, options);
                ImageLoader.getInstance().displayImage("http://image1.suning.cn" + d.get(23).getTag().get(0).getPicUrl(), home_lama, options);
                ImageLoader.getInstance().displayImage("http://image1.suning.cn" + d.get(24).getTag().get(0).getPicUrl(), hl_one, options);
                ImageLoader.getInstance().displayImage("http://image1.suning.cn" + d.get(26).getTag().get(0).getPicUrl(), hl_two, options);
                ImageLoader.getInstance().displayImage("http://image1.suning.cn" + d.get(28).getTag().get(0).getPicUrl(), hl_three, options);
                ImageLoader.getInstance().displayImage("http://image1.suning.cn" + d.get(30).getTag().get(0).getPicUrl(), hl_four, options);
                ImageLoader.getInstance().displayImage("http://image1.suning.cn" + d.get(32).getTag().get(0).getPicUrl(), hl_five, options);
                ImageLoader.getInstance().displayImage("http://image1.suning.cn" + d.get(33).getTag().get(0).getPicUrl(), hl_more, options);
            }
            @Override
            public void onError(Response response, int code, Exception e) {
            }
        });
        home_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ScanActivity.class);
                startActivity(intent);
            }
        });
        mrecyclerview.addOnItemTouchListener(new RecyclerViewClickListener(getActivity(), new RecyclerViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("qiandao", d.get(1).getTag().get(position).getLinkUrl());
                getActivity().startActivity(intent);
            }
            @Override
            public void onItemLongClick(View view, int position) {

            }
        }));
        mrecyclerview1.addOnItemTouchListener(new RecyclerViewClickListener(getActivity(), new RecyclerViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(),GoodsActivity.class);
                getActivity().startActivity(intent);
            }
            @Override
            public void onItemLongClick(View view, int position) {
            }
        }));
        mrecyclerview5.addOnItemTouchListener(new RecyclerViewClickListener(getActivity(), new RecyclerViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("zunying", d.get(10).getTag().get(position).getLinkUrl());
                getActivity().startActivity(intent);
            }
            @Override
            public void onItemLongClick(View view, int position) {

            }
        }));
        mrecyclerview6.addOnItemTouchListener(new RecyclerViewClickListener(getActivity(), new RecyclerViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("zunying", d.get(11).getTag().get(position).getLinkUrl());
                getActivity().startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        }));
        home_haiwai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("haiwai", d.get(14).getTag().get(0).getLinkUrl());
                getActivity().startActivity(intent);
            }
        });
        home_bighui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("bighui", d.get(16).getTag().get(0).getLinkUrl());
                getActivity().startActivity(intent);
            }
        });
        home_lianghui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("lianghui", d.get(18).getTag().get(0).getLinkUrl());
                getActivity().startActivity(intent);
            }
        });
        home_bie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("bie", d.get(20).getTag().get(0).getLinkUrl());
                getActivity().startActivity(intent);
            }
        });
        hl_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("hl_one", d.get(24).getTag().get(0).getLinkUrl());
                getActivity().startActivity(intent);
            }
        });
        hl_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("hl_two", d.get(26).getTag().get(0).getLinkUrl());
                getActivity().startActivity(intent);
            }
        });
        hl_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("hl_three", d.get(28).getTag().get(0).getLinkUrl());
                getActivity().startActivity(intent);
            }
        });
        hl_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("hl_four", d.get(30).getTag().get(0).getLinkUrl());
                getActivity().startActivity(intent);
            }
        });
        hl_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("hl_five", d.get(32).getTag().get(0).getLinkUrl());
                getActivity().startActivity(intent);
            }
        });
        hl_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("more", d.get(33).getTag().get(0).getLinkUrl());
                getActivity().startActivity(intent);
            }
        });
    }

    public void tu() {
        // 写一个计时器
        Timer tt = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        int index = home_vp.getCurrentItem();
                        home_vp.setCurrentItem(++index);
                    }
                });
            }
        };
        tt.schedule(task, 3000, 3000);
        home_vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int arg0) {
                // TODO Auto-generated method stub
                // 将arg0换算到viewList的索引范围之内
                int position = arg0 % d.get(0).getTag().size();
                // 遍历所有的点对应的ImageView ，判断点的索引是否跟ViewPager当前的索引一致
                for (int i = 0; i < ll.getChildCount(); i++) {
                    ImageView image = (ImageView) ll.getChildAt(i);
                    if (i == position) {
                        image.setSelected(true);
                    } else {
                        image.setSelected(false);
                    }
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub
            }
        });
        // 添加下面的圆点
        for (int i = 0; i < d.get(0).getTag().size(); i++) {
            // 动态实例化ImageView对象，添加到LinearLayout里面
            ImageView imageview = new ImageView(getActivity());
            // 手动代码设置间距
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(3, 8, 3, 0);
            // 将当前属性设置给ImageView
            imageview.setLayoutParams(params);
            // 给ImageView设置显示资源
            imageview.setBackgroundResource(R.drawable.item_selector1);
            // 将ImageView添加到LinearLayout里面
            ll.addView(imageview);
            // 设置默认选中第一个
            if (i == 0) {
                imageview.setSelected(true);
            }
        }
    }
    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
        private List<Data.DataBean> d;

        public HomeAdapter(List<Data.DataBean> d) {
            this.d = d;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    getActivity()).inflate(R.layout.item_home, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tv.setText(d.get(1).getTag().get(position).getElementName());
            ImageLoader.getInstance().displayImage("http://image1.suning.cn" + d.get(1).getTag().get(position).getPicUrl(), holder.iv);
        }

        @Override
        public int getItemCount() {
            return d.get(1).getTag().size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tv;
            ImageView iv;

            public MyViewHolder(View view) {
                super(view);
                tv = (TextView) view.findViewById(R.id.id_num);
                iv = (ImageView) view.findViewById(R.id.home_recy_iv);
            }
        }
    }
    class HomeOneAdapter extends RecyclerView.Adapter<HomeOneAdapter.MyViewHolder> {
        private List<Data.DataBean.TagBean> d;
        public HomeOneAdapter(List<Data.DataBean.TagBean> d) {
            this.d = d;
            d.remove(0);
        }
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder1 = new MyViewHolder(LayoutInflater.from(
                    getActivity()).inflate(R.layout.home_item1, parent,
                    false));
            return holder1;
        }
        @Override
        public void onBindViewHolder(MyViewHolder holder1, int position) {
            ImageLoader.getInstance().displayImage("http://image1.suning.cn" + d.get(position).getPicUrl(), holder1.iv);
        }

        @Override
        public int getItemCount() {

            return d.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView iv;

            public MyViewHolder(View view) {
                super(view);
                iv = (ImageView) view.findViewById(R.id.home_recy_iv1);
            }
        }
    }
    class HomeFiveAdapter extends RecyclerView.Adapter<HomeFiveAdapter.MyViewHolder> {
        private List<Data.DataBean> d;

        public HomeFiveAdapter(List<Data.DataBean> d) {
            this.d = d;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder5 = new MyViewHolder(LayoutInflater.from(
                    getActivity()).inflate(R.layout.home_item5, parent,
                    false));
            return holder5;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder5, int position) {
            ImageLoader.getInstance().displayImage("http://image1.suning.cn" + d.get(10).getTag().get(position).getPicUrl(), holder5.iv);
        }

        @Override
        public int getItemCount() {
            return d.get(10).getTag().size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView iv;

            public MyViewHolder(View view) {
                super(view);
                iv = (ImageView) view.findViewById(R.id.h_iv_five);
            }
        }
    }
    class HomeSixAdapter extends RecyclerView.Adapter<HomeSixAdapter.MyViewHolder> {
        private List<Data.DataBean> d;

        public HomeSixAdapter(List<Data.DataBean> d) {
            this.d = d;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder6 = new MyViewHolder(LayoutInflater.from(
                    getActivity()).inflate(R.layout.home_item6, parent,
                    false));
            return holder6;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder6, int position) {
            ImageLoader.getInstance().displayImage("http://image1.suning.cn" + d.get(11).getTag().get(position).getPicUrl(), holder6.iv);
        }

        @Override
        public int getItemCount() {
            return d.get(11).getTag().size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView iv;

            public MyViewHolder(View view) {
                super(view);
                iv = (ImageView) view.findViewById(R.id.h_iv_six);
            }
        }
    }
    private void intentJump(RecyclerView mrecyclerview, int a) {
        final int num = a;
        mrecyclerview.addOnItemTouchListener(new RecyclerViewClickListener(getActivity(), new RecyclerViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("zhuyong", d.get(num).getTag().get(position).getLinkUrl());
                getActivity().startActivity(intent);
            }
            @Override
            public void onItemLongClick(View view, int position) {
            }
        }));
    }
    private void IntentJump1(RecyclerView mrecyclerview, int b){
        final int num = b;
        mrecyclerview.addOnItemTouchListener(new RecyclerViewClickListener(getActivity(), new RecyclerViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(),GoodsActivity.class);
                getActivity().startActivity(intent);
            }
            @Override
            public void onItemLongClick(View view, int position) {
            }
        }));
    }
}


