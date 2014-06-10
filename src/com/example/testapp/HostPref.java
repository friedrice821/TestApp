package com.example.testapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HostPref extends Activity {
    String email, pass, name, addr, phone; 
    
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
        SharedPreferences prefs = this.getSharedPreferences(        // http://androidgreeve.blogspot.com/2014/01/How-to-use-Shared-Preferences-and-manage-User-Sessions.html#.U5XHXPldXm4 
                "com.example.homestay", Context.MODE_PRIVATE); 
        final Editor editor = prefs.edit(); 
          
        final EditText getEmail = (EditText) findViewById(R.id.prefEmail); 
        final EditText getPass = (EditText) findViewById(R.id.prefPass); 
        final EditText getName = (EditText) findViewById(R.id.prefName); 
        final EditText getAddr = (EditText) findViewById(R.id.prefAddr); 
        final EditText getPhone = (EditText) findViewById(R.id.prefAddr); 
          
        Button register = (Button) findViewById(R.id.prefReg); 
          
        register.setOnClickListener(new View.OnClickListener(){ 
  
            @Override
            public void onClick(View v) { 
                // TODO Auto-generated method stub 
                editor.putString("email", getEmail.getText().toString()); 
                editor.putString("pass", getPass.getText().toString()); 
                editor.putString("name", getName.getText().toString()); 
                editor.putString("addr", getAddr.getText().toString()); 
                editor.putString("phone", getPhone.getText().toString()); 
            } 
              
        }); 
          
  
  
  
    } 
  
} 
