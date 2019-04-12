package com.example.section1.ui.product.list.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.section1.R;
import com.example.section1.data.dataclasses.ProductModel;

import java.util.List;

public class ProductListAdapter extends ArrayAdapter<ProductModel> {

    private Context context;
    private int layout;
    private List<ProductModel> productModelList;
    private OnClickListener onClickListener;

    public ProductListAdapter(Context context, int layout, List<ProductModel> productModelList) {
        super(context, layout, productModelList);
        this.context = context;
        this.layout = layout;
        this.productModelList = productModelList;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(layout, parent, false);
        TextView tvCategoryName = view.findViewById(R.id.tv_product_name);
        ProductModel productModel = productModelList.get(position);
        if (productModel != null) {
            tvCategoryName.setText(productModel.getName());
            view.setOnClickListener(v -> {
                if (onClickListener != null) {
                    onClickListener.onItemClick(productModel.getId());
                }
            });
        }
        return view;
    }

    public interface OnClickListener {
        void onItemClick(int id);
    }
}