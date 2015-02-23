package com.example.hangdroid.utilities;

import com.example.hangdroid.R;

import android.view.View;
import android.widget.TextView;

public class ViewHolder{
	private TextView ranking;
	private TextView name;
	private TextView points;
	
	public int getRanking(){
		return Integer.valueOf(ranking.getText().toString());
	}
	
	public String getName(){
		return name.getText().toString();
	}
	
	public double getPoints(){
		return Integer.valueOf(points.getText().toString());
	}
	
	public void setViewRanking(View v){
		ranking = (TextView) v.findViewById(R.id.textViewRankingg);
	}
	
	public void setViewName(View v){
		name = (TextView) v.findViewById(R.id.textViewNamee);
	}
	
	public void setVistaRatio(View v){
		points = (TextView) v.findViewById(R.id.textViewNumPointss);
	}	
	
	public void setRankingValue(int value){
		ranking.setText(String.valueOf(value));
	}
	
	public void setNameValue(String namePlayer){
		name.setText(namePlayer);
	}
	
	public void setNumPointsValue(String scores){
		points.setText((scores));
	}	
}
