package org.npenn.gifted.aacpecsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class CommonPhraseAdapter extends BaseAdapter {

    private Context activity;

    public CommonPhraseAdapter(Context activity) {
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return IntellitalkState.INSTANCE.data.commonWords.size();
    }

    @Override
    public Object getItem(int position) {
        return IntellitalkState.INSTANCE.data.commonWords.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(activity).inflate(R.layout.word_layout, parent, false);
        }
        Word w = IntellitalkState.INSTANCE.data.commonWords.get(position);
        ImageView imageView = (ImageView) view.findViewById(R.id.item_image);
        TextView textView = (TextView) view.findViewById(R.id.item_text);
        if (w.image != null) {
            imageView.setImageBitmap(w.image);
            imageView.setVisibility(View.VISIBLE);
            textView.setVisibility(View.INVISIBLE);
        } else {
            textView.setText(w.displayText);
            textView.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.INVISIBLE);
        }
        return view;
    }
}
