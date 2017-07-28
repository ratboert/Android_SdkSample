package com.autel.sdksample.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.autel.common.product.AutelProductType;
import com.autel.sdksample.R;
import com.autel.sdksample.XStarActivity;

import java.util.ArrayList;
import java.util.List;


public class ProductSelector extends PagerAdapter {
    private List<ProductItem> products = new ArrayList<>();
    private List<View> itemViews = new ArrayList<>();
    private Context mContext;
    private int notifyChanged = 0;

    public ProductSelector(Context context) {
        mContext = context;
        ProductItem item = new ProductItem();
        item.type = AutelProductType.X_STAR;
        item.resIcon = R.mipmap.cover_xstar_main;
        products.add(item);
        itemViews.add(LayoutInflater.from(context).inflate(R.layout.product_item, null));

        item = new ProductItem();
        item.type = AutelProductType.PREMIUM;
        item.resIcon = R.mipmap.cover_xstar_pre;
        products.add(item);
        itemViews.add(LayoutInflater.from(context).inflate(R.layout.product_item, null));

        item = new ProductItem();
        item.type = AutelProductType.HANDHELD;
        item.resIcon = R.mipmap.cover_handheld;
        products.add(item);
        itemViews.add(LayoutInflater.from(context).inflate(R.layout.product_item, null));

        item = new ProductItem();
        item.type = AutelProductType.KESTREL;
        item.resIcon = R.mipmap.cover_kestrel;
        products.add(item);
        itemViews.add(LayoutInflater.from(context).inflate(R.layout.product_item, null));
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public void notifyDataSetChanged() {
        notifyChanged = products.size();
        super.notifyDataSetChanged();
    }

    @Override
    public int getItemPosition(Object object) {
        if (notifyChanged > 0) {
            notifyChanged--;
            return POSITION_NONE;
        }
        return super.getItemPosition(object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(itemViews.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = itemViews.get(position);
        ProductItem item = products.get(position);
        container.addView(view);
        TextView type = (TextView) view.findViewById(R.id.productType);
        Button connectState = (Button) view.findViewById(R.id.productConnectState);
        ImageView productIcon = (ImageView) view.findViewById(R.id.productIcon);

        type.setText(item.type.toString());
        connectState.setText(mContext.getResources().getString(item.connectState ? R.string.product_connect : R.string.product_not_connect));
        productIcon.setImageResource(item.resIcon);
        connectState.setTag(position);
        connectState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = (Integer) v.getTag();
                ProductItem target = products.get(index);
                if (target.connectState) {
                    startProduct(target.type);
                }
            }
        });

        return view;
    }

    private void startProduct(AutelProductType productType) {
        Class target = null;
        if (productType == AutelProductType.X_STAR) {
            target = XStarActivity.class;
        } else {
            target = XStarActivity.class;
        }
        mContext.startActivity(new Intent(mContext, target));
    }

    public static class ProductItem {
        AutelProductType type;
        boolean connectState;
        int resIcon;
    }

    public int productConnected(AutelProductType type) {
        int index = 0, target = 0;
        for (ProductItem item : products) {
            item.connectState = type == item.type;
            if (item.connectState) {
                target = index;
            }
            index++;
        }
        notifyDataSetChanged();
        return target;
    }
}
