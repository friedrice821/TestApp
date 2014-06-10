package com.example.testapp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;

public class HostPref extends Activity {
	String email, pass, name, addr, phone; 
	private DatePicker start, end;
	private int month, day, year, month2, day2, year2;

	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		// TODO Auto-generated method stub 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.fragment_host_pref); 

	} 

	@Override
	protected void onResume() { 
		// TODO Auto-generated method stub 
		super.onResume(); 
		//        SharedPreferences prefs = this.getSharedPreferences(        // http://androidgreeve.blogspot.com/2014/01/How-to-use-Shared-Preferences-and-manage-User-Sessions.html#.U5XHXPldXm4 
		//                "com.example.homestay", Context.MODE_PRIVATE); 
		//        final Editor editor = prefs.edit(); 

		final EditText getEmail = (EditText) findViewById(R.id.prefEmail); 
		final EditText getPass = (EditText) findViewById(R.id.prefPass); 
		final EditText getName = (EditText) findViewById(R.id.prefName); 
		final EditText getAddr = (EditText) findViewById(R.id.prefAddr); 
		final EditText getPhone = (EditText) findViewById(R.id.prefPhone); 
		final CheckBox getSmoke = (CheckBox) findViewById(R.id.prefSmoke);
		final CheckBox getDog = (CheckBox) findViewById(R.id.dogs);
		final CheckBox getCat = (CheckBox) findViewById(R.id.cats);
		final CheckBox getBird = (CheckBox) findViewById(R.id.birds);
		final CheckBox getOther = (CheckBox) findViewById(R.id.other);
		final EditText getDist = (EditText) findViewById(R.id.prefDist); 
		final EditText getBlurb = (EditText) findViewById(R.id.prefBlurb); 
		
		start = (DatePicker) findViewById(R.id.prefStart);
		start.setCalendarViewShown(false);
		final Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);
		start.init(year, month, day, null);
		
		end = (DatePicker) findViewById(R.id.prefEnd);
		end.setCalendarViewShown(false);
		end.init(year, month, day, null);
		
		Button register = (Button) findViewById(R.id.prefReg); 
		register.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				try {

					OutputStreamWriter out= new OutputStreamWriter(openFileOutput(getEmail.getText().toString(), 0));

					out.write(getPass.getText().toString() + "\n0 0\n");
					out.write(getName.getText().toString() + "\n");
					out.write(getAddr.getText().toString() + "\n");
					out.write(getPhone.getText().toString() + "\n");
					out.write(getSmoke.isChecked() + "\n"); 
					out.write(getDog.isChecked() + " " +  getCat.isChecked() + " "+ getBird.isChecked()+ " "+ getOther.isChecked() + "\n"); 
					out.write(getDist.getText().toString() + "\n");
					out.write(start.getMonth() + " " + start.getDayOfMonth() + " " + start.getYear() + "\n");
					out.write(end.getMonth() + " " + end.getDayOfMonth() + " " + end.getYear() + "\n");
					out.write(getBlurb.getText().toString() + "\n");
					
					out.close();	

//					try {
//
//						InputStream in = openFileInput(getEmail.getText().toString());
//						if (in != null) {
//							InputStreamReader tmp=new InputStreamReader(in);
//							BufferedReader reader=new BufferedReader(tmp);
//
//							String str;
//
//							StringBuilder buf=new StringBuilder();
//
//							str = reader.readLine();
//							str = reader.readLine();
//							str = reader.readLine();
//							in.close();
//							getPass.setText(str);
//							//Toast.makeText(this, str, Toast.LENGTH_LONG);
//						}
//
//					} catch (java.io.FileNotFoundException e) {
//
//					}
//					catch (Exception e) {}



				}
				catch (Exception t) {}		
				//saving host to host list
//				try {
//					OutputStreamWriter save= new OutputStreamWriter(new FileOutputStream("hosts", true));
//					BufferedWriter out = new BufferedWriter(save);
//					out.write(getEmail.getText().toString() + "\n");
//					out.close();
//				} catch (Exception t) {}	
//		        try{
//
//		            FileWriter fstream = new FileWriter("hosts",true);
//		            BufferedWriter fbw = new BufferedWriter(fstream);
//		            fbw.write(getEmail.getText().toString());
//		            fbw.newLine();
//		            fbw.close();
//		        }catch (Exception e) {
//		            System.out.println("Error: " + e.getMessage());
//		        }
				try {
					OutputStreamWriter save= new OutputStreamWriter(openFileOutput("hosts", MODE_APPEND));
				BufferedWriter out = new BufferedWriter(save);
				out.write(getEmail.getText().toString() + "\n");
				out.close();
			} catch (Exception t) {}
			}
		});


	}



	public static class DatePickerFragment extends DialogFragment
	implements DatePickerDialog.OnDateSetListener {

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			// Use the current date as the default date in the picker
			final Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);

			// Create a new instance of DatePickerDialog and return it
			return new DatePickerDialog(getActivity(), this, year, month, day);
		}

		public void onDateSet(DatePicker view, int year, int month, int day) {
			// Do something with the date chosen by the user
		}
	}
	
	



} 


