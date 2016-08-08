package com.example.pedro.inyecciondependencias.otherviews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.example.pedro.inyecciondependencias.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**clase ejemplo inyección en otros contextos butter knife (aplicable también a fragments por ejemplo)*/
public class CustomAdapter extends ArrayAdapter<String> {

    @BindView(R.id.button5)
    Button button;
    @Nullable
    @BindView(R.id.button) Button button1;

    private List<String> list;

    public CustomAdapter(Context context, int resource) {
        super(context, resource);
    }

    public CustomAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        this.list = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View view = layoutInflater.inflate(R.layout.inflate_lv, null);
        ButterKnife.bind(this, view);
        button.setText(list.get(position));
        return view;
    }
}
