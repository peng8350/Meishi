package com.peng.meishi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;
import com.peng.meishi.R;
import com.peng.meishi.entity.MeishiInfo;
import com.peng.meishi.entity.ShopInfo;
import com.peng.meishi.utils.FrescoUtils;
import com.peng.meishi.widget.pinnedheaderlistview.SectionedBaseAdapter;

import java.util.List;

/**
 * Created by peng on 16-10-17.
 */
public class SearchAdapter extends SectionedBaseAdapter {

    private List<MeishiInfo> mMeishi;
    private List<ShopInfo> mShops;
    private Context context;

    public SearchAdapter(List<MeishiInfo> mMeishi, List<ShopInfo> mShops, Context context) {
        this.mMeishi = mMeishi;
        this.mShops = mShops;
        this.context = context;
    }

    @Override
    public Object getItem(int section, int position) {
        return null;
    }

    @Override
    public long getItemId(int section, int position) {
        return 0;
    }

    @Override
    public int getSectionCount() {
        return 2;
    }

    @Override
    public int getCountForSection(int section) {
        return section == 0 ? (mMeishi != null && mMeishi.size() > 0 ? mMeishi.size() : 0) : (mShops != null && mShops.size() > 0 ? mShops.size() : 0);
    }


    @Override
    public int getItemViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int section, int position) {
        return section;
    }

    @Override
    public View getItemView(int section, int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            if (section == 0) {
                view = LayoutInflater.from(context).inflate(R.layout.item_meishi, null);
                holder.meishi_image = (SimpleDraweeView) view.findViewById(R.id.item_meishi_image);
                holder.meishi_money = (TextView) view.findViewById(R.id.item_meishi_money);
                holder.meishi_pingjia = (TextView) view.findViewById(R.id.item_Meishi_pingjia);
                holder.meishi_place = (TextView) view.findViewById(R.id.item_meishi_place);
                holder.meishi_rb_score  = (SimpleRatingBar) view.findViewById(R.id.item_meishi_ratingbar);
                holder.meishi_title = (TextView) view.findViewById(R.id.item_meishi_title);
                holder.meishi_score = (TextView) view.findViewById(R.id.item_meishi_score);
            } else {
                view = LayoutInflater.from(context).inflate(R.layout.item_shop_search, null);
                holder.shop_image = (SimpleDraweeView) view.findViewById(R.id.item_shop_search_pic);
                holder.shop_name = (TextView) view.findViewById(R.id.item_shop_search_name);
                holder.shop_phone = (TextView) view.findViewById(R.id.item_shop_search_phone);
                holder.shop_time = (TextView) view.findViewById(R.id.item_shop_search_time);

            }
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        if (section==0){
            MeishiInfo m_info = mMeishi.get(position);
            holder.meishi_money.setText(m_info.getMoney());
            holder.meishi_title.setText(m_info.getTitle());
            holder.meishi_score.setText("("+m_info.getScore()+"分)");
            holder.meishi_place.setText(m_info.getPlace());
            holder.meishi_pingjia.setText(m_info.getPingjia());
            holder.meishi_rb_score.setRating((float)(m_info.getScore()/2));
            FrescoUtils.Display(holder.meishi_image,"res:///"+R.drawable.pic1,220,220,true);
        }
        else{
            ShopInfo shopInfo = mShops.get(position);
            FrescoUtils.Display(holder.shop_image,"res:///"+R.drawable.pic2,220,220,true);
        }

        return view;
    }

    @Override
    public View getSectionHeaderView(int section, View convertView, ViewGroup parent) {
        TextView layout = (TextView) LayoutInflater.from(context).inflate(R.layout.header_list_search, null);
        layout.setText(section == 0 ? "美食" : "店铺");
        return layout;
    }

    class ViewHolder {
        TextView meishi_title, meishi_place, meishi_money, meishi_score, meishi_pingjia, shop_name, shop_phone, shop_time;
        SimpleRatingBar meishi_rb_score;
        SimpleDraweeView meishi_image, shop_image;

    }
}
