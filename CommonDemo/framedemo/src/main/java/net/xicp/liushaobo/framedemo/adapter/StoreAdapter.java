package net.xicp.liushaobo.framedemo.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import net.xicp.liushaobo.comlib.utils.L;
import net.xicp.liushaobo.framedemo.R;
import net.xicp.liushaobo.framedemo.entity.Store;

import java.util.List;


/**
 * 门店列表适配器
 *
 * @author Administrator
 */
public class StoreAdapter extends MyAdapter<Store> {

    public StoreAdapter(Context ct, List<Store> list) {
        super(ct, list);
        // TODO Auto-generated constructor stub
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_store, null);
            holder = new ViewHolder();
            holder.tv_store_name = (TextView) convertView
                    .findViewById(R.id.tv_store_name);
            holder.tv_store_address = (TextView) convertView
                    .findViewById(R.id.tv_store_address);
            /*holder.iv_store_logo = (ImageView) convertView
					.findViewById(R.id.iv_store_logo);*/
            holder.sdv_store_logo = (SimpleDraweeView) convertView
                    .findViewById(R.id.iv_store_logo);
            holder.iv_coupon_platform = (ImageView) convertView
                    .findViewById(R.id.iv_coupon_platform);
            holder.iv_coupon_store = (ImageView) convertView
                    .findViewById(R.id.iv_coupon_store);
            holder.iv_coupon_bonus = (ImageView) convertView
                    .findViewById(R.id.iv_coupon_bonus);
            holder.iv_store_open = (ImageView) convertView
                    .findViewById(R.id.iv_store_open);
            holder.rb_store_score = (RatingBar) convertView
                    .findViewById(R.id.rb_store_score);
            holder.tv_distance = (TextView) convertView
                    .findViewById(R.id.tv_distance);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        try {
            Store store = data.get(position);
            holder.tv_store_name.setText(store.store_name);
            holder.tv_store_address.setText(store.store_address);
            if (store.store_score_avg == "") {
                store.store_score_avg = "0";
            }
            holder.rb_store_score.setRating(Float
                    .valueOf(store.store_score_avg));
            String distance = String.valueOf(store.distance);
            if (String.valueOf(store.distance).length() > 4) {
                distance = ">10000";
            }
            holder.tv_distance.setText(distance + "米");

            if ("1".equals(store.store_store_used)) {
                holder.iv_coupon_store.setVisibility(View.VISIBLE);
            } else {
                holder.iv_coupon_store.setVisibility(View.GONE);
            }
            if ("1".equals(store.store_platform_used)) {
                holder.iv_coupon_platform.setVisibility(View.VISIBLE);
            } else {
                holder.iv_coupon_platform.setVisibility(View.GONE);
            }
            if ("1".equals(store.store_bonus_used)) {
                holder.iv_coupon_bonus.setVisibility(View.VISIBLE);
            } else {
                holder.iv_coupon_bonus.setVisibility(View.GONE);
            }
            if ("0".equals(store.store_open_type)) {
                holder.iv_store_open.setVisibility(View.VISIBLE);
            } else {
                holder.iv_store_open.setVisibility(View.GONE);
            }
            if (store.store_logo != null) {
                L.v(store.store_logo);
                //Uri.parse(store.store_logo)
                Uri uri = Uri.parse(store.store_logo);
                holder.sdv_store_logo.setImageURI(uri);
                 //MyImageLoader.getLoaer(context).displayImage(store.store_logo,holder.iv_store_logo,MyImageLoader.userIcon(R.drawable.stores_default));
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
        return convertView;
    }

    private class ViewHolder {
        TextView tv_store_name, tv_store_address, tv_distance;
        ImageView iv_store_logo, iv_coupon_platform, iv_coupon_store,
                iv_coupon_bonus, iv_store_open;
        SimpleDraweeView sdv_store_logo;
        RatingBar rb_store_score;
    }

}
