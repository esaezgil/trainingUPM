package com.example.hangdroid;

import java.util.Locale;

import com.example.hangdroid.utilities.ViewHolder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class ScoreListAdapter extends ArrayAdapter<String[]>{


	private String[][] scores;
	//private String[][] data;
	private Context context;
	
	public ScoreListAdapter(Context context, int layout, 
			int layoutText, String[][] data) {
		super(context, layout, layoutText, data);
		this.context = context;
		//this.data = data;
		scores = data;
	}
	
	@SuppressLint("InflateParams")
	@Override
	public View getView(int posicion, View convertView, ViewGroup padre){
		ViewHolder holder;
		
		if(convertView == null){
			LayoutInflater inflater = 
					(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.score_item, null);
			
			holder = new ViewHolder();
			holder.setViewName(convertView);
			holder.setViewRanking(convertView);
			holder.setVistaRatio(convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		Log.d("MYLOG", "the position is: "+posicion);
		int a =  scores.length; 
		Log.d("MYLOG", "the length is: "+ scores.length);
		String name = scores[posicion][0];
		int g = 0;
		holder.setNameValue(scores[posicion][0]);
		holder.setRankingValue(posicion);
		//holder.setNumPointsValue(Integer.valueOf(scores[posicion][1]));
		holder.setNumPointsValue(scores[posicion][1]);
		return convertView;
	}

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
    
    @Override
    public int getCount() {
        return scores.length;
    }

    @Override
    public String[] getItem(int position) {
        return scores[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
