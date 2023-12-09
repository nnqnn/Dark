package com.taptab.dark;

import android.app.Activity;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.graphics.*;
import android.view.animation.*;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.SeekBar;
import android.content.SharedPreferences;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;
import android.widget.CompoundButton;
import android.view.View;

public class SettingsActivity extends Activity {

	private Timer _timer = new Timer();

	private String activityFontName = "";
	private double nums = 0;
	private boolean show = false;
	private double speed = 0;
	private double uu = 0;

	private LinearLayout linear1;
	private ImageView imageview1;
	private CheckBox checkbox1;
	private LinearLayout linear4;
	private TextView textview8;
	private TextView textview5;
	private SeekBar seekbar1;
	private LinearLayout linear3;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private TextView textview6;
	private TextView textview7;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private TextView textview2;
	private TextView textview3;
	private TextView textview4;
	private TextView textview9;
	private LinearLayout linear9;
	private TextView textview11;

	private SharedPreferences set;
	private SharedPreferences save;
	private TimerTask timer;
	private Intent i = new Intent();

	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.settings);
		initialize(_savedInstanceState);
		initializeLogic();
	}

	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		imageview1 = findViewById(R.id.imageview1);
		checkbox1 = findViewById(R.id.checkbox1);
		linear4 = findViewById(R.id.linear4);
		textview8 = findViewById(R.id.textview8);
		textview5 = findViewById(R.id.textview5);
		seekbar1 = findViewById(R.id.seekbar1);
		linear3 = findViewById(R.id.linear3);
		linear5 = findViewById(R.id.linear5);
		linear6 = findViewById(R.id.linear6);
		textview6 = findViewById(R.id.textview6);
		textview7 = findViewById(R.id.textview7);
		linear7 = findViewById(R.id.linear7);
		linear8 = findViewById(R.id.linear8);
		textview2 = findViewById(R.id.textview2);
		textview3 = findViewById(R.id.textview3);
		textview4 = findViewById(R.id.textview4);
		textview9 = findViewById(R.id.textview9);
		linear9 = findViewById(R.id.linear9);
		textview11 = findViewById(R.id.textview11);
		set = getSharedPreferences("set", Activity.MODE_PRIVATE);
		save = getSharedPreferences("save", Activity.MODE_PRIVATE);

		checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					set.edit().putString("novid", "1").commit();
				} else {
					set.edit().putString("novid", "0").commit();
				}
			}
		});

		seekbar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (!(uu == 0)) {
					textview2.setText(String.valueOf((long) (_progressValue + 50)));
					set.edit().putString("speed", String.valueOf((long) (_progressValue + 50))).commit();
					speed = _progressValue + 50;
				}
				uu++;
			}

			@Override
			public void onStartTrackingTouch(SeekBar _param1) {

			}

			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				try {
					if (show) {
						seekbar1.setEnabled(false);
						nums = 0;
						timer = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										show = false;
										if (nums > "Меня поглощает тьма".length()) {
											seekbar1.setEnabled(true);
											timer.cancel();
											show = true;
										} else {
											textview8.setText("Меня поглощает тьма".substring((int) (0), (int) (nums)));
											nums++;
										}
									}
								});
							}
						};
						_timer.scheduleAtFixedRate(timer, (int) (500), (int) (speed));
					}
				} catch (Exception e) {
				}
			}
		});

		textview6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				save.edit().putString("save", "1").commit();
				_out();
				timer = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								final AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
								final AlphaAnimation fadeOut = new AlphaAnimation(1.0f, 0.0f);

								textview7.startAnimation(fadeIn);
								textview7.startAnimation(fadeOut);
								fadeIn.setDuration(1000);
								fadeIn.setFillAfter(true);
								fadeOut.setDuration(1000);
								fadeOut.setFillAfter(true);
								fadeOut.setStartOffset(10 + fadeIn.getStartOffset());
							}
						});
					}
				};
				_timer.schedule(timer, (int) (1001));
			}
		});

		textview9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!save.getString("lang", "").equals("ru")) {
					save.edit().putString("lang", "ru").commit();
					i.setClass(getApplicationContext(), Main12Activity.class);
					i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(i);
					finish();
				}
			}
		});

		textview11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!save.getString("lang", "").equals("en")) {
					save.edit().putString("lang", "en").commit();
					i.setClass(getApplicationContext(), Main12Activity.class);
					i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(i);
					finish();
				}
			}
		});
	}

	private void initializeLogic() {
		uu = 0;
		_changeActivityFont("pixel");
		_in();
		if (set.getString("novid", "").equals("1")) {
			checkbox1.setChecked(true);
		}
		seekbar1.setProgress((int) Double.parseDouble(set.getString("speed", "")) - 50);
		textview2.setText(set.getString("speed", ""));
		show = true;
		if (save.getString("lang", "").equals("en")) {
			checkbox1.setText("Starting screensaver");
			textview5.setText("Text output speed in milliseconds (ms)");
			textview6.setText("Reset save");
			textview7.setText("Save reset successfully!");
			textview8.setText("darkness consumes me");
		}
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


	public void _in() {
		final AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
		final AlphaAnimation fadeOut = new AlphaAnimation(1.0f, 0.0f);

		textview7.startAnimation(fadeIn);
		textview7.startAnimation(fadeOut);
		fadeIn.setDuration(1);
		fadeIn.setFillAfter(true);
		fadeOut.setDuration(1);
		fadeOut.setFillAfter(true);
		fadeOut.setStartOffset(10 + fadeIn.getStartOffset());
	}


	public void _out() {
		final AlphaAnimation fadeIn = new AlphaAnimation(1.0f, 0.0f);
		final AlphaAnimation fadeOut = new AlphaAnimation(0.0f, 1.0f);

		textview7.startAnimation(fadeIn);
		textview7.startAnimation(fadeOut);
		fadeIn.setDuration(1000);
		fadeIn.setFillAfter(true);
		fadeOut.setDuration(1000);
		fadeOut.setFillAfter(true);
		fadeOut.setStartOffset(10 + fadeIn.getStartOffset());
	}
}
