package com.taptab.dark;

import android.app.Activity;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;
import android.net.Uri;
import android.content.SharedPreferences;
import android.view.View;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.DialogFragment;
import com.taptab.dark.R;

public class MainActivity extends Activity {

	private Timer _timer = new Timer();

	private String text = "";
	private double numtext = 0;
	private double sound = 0;
	private double sec = 0;
	private double door = 0;
	private String activityFontName = "";

	private LinearLayout linear1;
	private LinearLayout linear2;
	private TextView textview2;
	private TextView textview3;

	private TimerTask anim;
	private Intent start = new Intent();
	private SharedPreferences set;
	private SharedPreferences save;

	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}

	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		textview2 = findViewById(R.id.textview2);
		textview3 = findViewById(R.id.textview3);
		set = getSharedPreferences("set", Activity.MODE_PRIVATE);
		save = getSharedPreferences("save", Activity.MODE_PRIVATE);

		textview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if ("".equals(save.getString("lang", ""))) {
					save.edit().putString("lang", "ru").commit();
					textview2.setTextColor(0xFF4CAF50);
					anim = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									start.setClass(getApplicationContext(), MainActivity.class);
									start.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
									startActivityForResult(start, 0);
									overridePendingTransition(0, 0);
								}
							});
						}
					};
					_timer.schedule(anim, (int) (1000));
				}
			}
		});

		textview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if ("".equals(save.getString("lang", ""))) {
					save.edit().putString("lang", "en").commit();
					textview3.setTextColor(0xFF4CAF50);
					anim = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									start.setClass(getApplicationContext(), MainActivity.class);
									start.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
									startActivityForResult(start, 0);
									overridePendingTransition(0, 0);
								}
							});
						}
					};
					_timer.schedule(anim, (int) (1000));
				}
			}
		});
	}

	private void initializeLogic() {
		linear2.setVisibility(View.GONE);
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
		if ("".equals(save.getString("lang", ""))) {
			linear2.setVisibility(View.VISIBLE);
		} else {
			final VideoView vd = new VideoView(MainActivity.this);
			vd.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.MATCH_PARENT, android.widget.LinearLayout.LayoutParams.MATCH_PARENT));
			linear1.addView(vd);
			String path = "android.resource://" + getPackageName() + "/" + R.raw.vid;
			vd.setVideoURI(Uri.parse(path));
			vd.requestFocus();
			vd.start();


			if (set.getString("novid", "").equals("1")) {
				anim = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								start.setClass(getApplicationContext(), Main12Activity.class);
								start.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
								startActivityForResult(start, 0);
								overridePendingTransition(0, 0);
							}
						});
					}
				};
				_timer.schedule(anim, (int) (5200));
			} else {
				start.setClass(getApplicationContext(), Main12Activity.class);
				start.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
				startActivityForResult(start, 0);
				overridePendingTransition(0, 0);
			}
		}
		if ("".equals(set.getString("novid", ""))) {
			set.edit().putString("novid", "1").commit();
		}
		if ("".equals(set.getString("speed", ""))) {
			set.edit().putString("speed", "80").commit();
		}
		if ("".equals(save.getString("save", ""))) {
			save.edit().putString("save", "1").commit();
		}
		_changeActivityFont("pixel");
	}

	@Override
	public void onBackPressed() {

	}

	public void _changeActivityFont(final String _fontname) {
		activityFontName = _fontname.trim();
		if (activityFontName.contains(".ttf")) {
			activityFontName = activityFontName.replace(".ttf", "");
		}
		overrideFonts(this, getWindow().getDecorView());
	}

	private void overrideFonts(final android.content.Context context, final View v) {
		try {
			Typeface activityTypeFace = Typeface.createFromAsset(getAssets(), "fonts/" + activityFontName + ".ttf");
			if ((v instanceof ViewGroup)) {
				ViewGroup activityFontGroup = (ViewGroup) v;
				for (int i = 0;
					 i < activityFontGroup.getChildCount();
					 i++) {
					View child = activityFontGroup.getChildAt(i);
					overrideFonts(context, child);
				}
			} else {
				if ((v instanceof TextView)) {
					((TextView) v).setTypeface(activityTypeFace);
				} else {
					if ((v instanceof EditText)) {
						((EditText) v).setTypeface(activityTypeFace);
					} else {
						if ((v instanceof Switch)) {
							((Switch) v).setTypeface(activityTypeFace);
						} else {
							if ((v instanceof CheckBox)) {
								((CheckBox) v).setTypeface(activityTypeFace);
							} else {
								if ((v instanceof Button)) {
									((Button) v).setTypeface(activityTypeFace);
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
		}
	}
}
