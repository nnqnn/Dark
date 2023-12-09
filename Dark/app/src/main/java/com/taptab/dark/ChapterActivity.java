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
import android.graphics.Typeface;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.DialogFragment;

public class ChapterActivity extends Activity {

	private Timer _timer = new Timer();

	private double num = 0;
	private String text = "";
	private String activityFontName = "";

	private LinearLayout linear2;
	private LinearLayout linear1;
	private TextView textview1;
	private TextView textview2;
	private TextView textview5;
	private TextView textview3;

	private TimerTask anim;
	private Intent win = new Intent();
	private TimerTask anim2;
	private SharedPreferences save;

	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.chapter);
		initialize(_savedInstanceState);
		initializeLogic();
	}

	private void initialize(Bundle _savedInstanceState) {
		linear2 = findViewById(R.id.linear2);
		linear1 = findViewById(R.id.linear1);
		textview1 = findViewById(R.id.textview1);
		textview2 = findViewById(R.id.textview2);
		textview5 = findViewById(R.id.textview5);
		textview3 = findViewById(R.id.textview3);
		save = getSharedPreferences("save", Activity.MODE_PRIVATE);
	}

	private void initializeLogic() {
		_changeActivityFont("pixel");
		_in();
		anim2 = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						_out();
					}
				});
			}
		};
		_timer.schedule(anim2, (int) (8));
		textview1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/pixel.ttf"), 0);
		textview2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/pixel.ttf"), 0);
		textview3.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/pixel.ttf"), 0);
		if (getIntent().getStringExtra("end").equals("true")) {
			textview1.setTextColor(0xFF4CAF50);
			text = getIntent().getStringExtra("chapter");
			anim = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							_decoder(textview1, text, num);
							if (num > text.length()) {
								_end(anim, num);
								text = getIntent().getStringExtra("retitle");
								anim = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												_decoder(textview2, text, num);
												if (num > text.length()) {
													_end(anim, num);
													if (save.getString("lang", "").equals("ru")) {
														text = "В Меню";
													} else {
														text = "On the menu";
													}
													anim = new TimerTask() {
														@Override
														public void run() {
															runOnUiThread(new Runnable() {
																@Override
																public void run() {
																	_decoder(textview3, text, num);
																	if (num > text.length()) {
																		_end(anim, num);
																		textview3.setOnClickListener(new View.OnClickListener() {
																			@Override
																			public void onClick(View _view) {
																				_off();
																				final AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
																				final AlphaAnimation fadeOut = new AlphaAnimation(1.0f, 0.0f);

																				linear1.startAnimation(fadeIn);
																				linear1.startAnimation(fadeOut);
																				fadeIn.setDuration(1000);
																				fadeIn.setFillAfter(true);
																				fadeOut.setDuration(1000);
																				fadeOut.setFillAfter(true);
																				fadeOut.setStartOffset(10 + fadeIn.getStartOffset());
																				anim2 = new TimerTask() {
																					@Override
																					public void run() {
																						runOnUiThread(new Runnable() {
																							@Override
																							public void run() {
																								win.setClass(getApplicationContext(), Main12Activity.class);
																								startActivity(win);
																							}
																						});
																					}
																				};
																				_timer.schedule(anim2, (int) (1001));
																			}
																		});
																	}
																}
															});
														}
													};
													_timer.scheduleAtFixedRate(anim, (int) (1000), (int) (100));
												}
											}
										});
									}
								};
								_timer.scheduleAtFixedRate(anim, (int) (500), (int) (80));
							}
						}
					});
				}
			};
			_timer.scheduleAtFixedRate(anim, (int) (500), (int) (100));
		} else {
			save.edit().putString("save", getIntent().getStringExtra("chap")).commit();
			text = getIntent().getStringExtra("chapter");
			anim = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							textview1.setText(text.substring((int) (0), (int) (num)));
							num++;
							if (num > text.length()) {
								_end(anim, num);
								text = getIntent().getStringExtra("retitle");
								anim = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												_decoder(textview2, text, num);
												if (num > text.length()) {
													_end(anim, num);
													if (getIntent().getStringExtra("end").equals("gl")) {
														anim = new TimerTask() {
															@Override
															public void run() {
																runOnUiThread(new Runnable() {
																	@Override
																	public void run() {
																		final AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
																		final AlphaAnimation fadeOut = new AlphaAnimation(1.0f, 0.0f);

																		linear1.startAnimation(fadeIn);
																		linear1.startAnimation(fadeOut);
																		fadeIn.setDuration(1000);
																		fadeIn.setFillAfter(true);
																		fadeOut.setDuration(1000);
																		fadeOut.setFillAfter(true);
																		fadeOut.setStartOffset(10 + fadeIn.getStartOffset());
																		anim = new TimerTask() {
																			@Override
																			public void run() {
																				runOnUiThread(new Runnable() {
																					@Override
																					public void run() {
																						win.putExtra("chapter", getIntent().getStringExtra("chap"));
																						win.setClass(getApplicationContext(), Main1Activity.class);
																						win.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
																						startActivityForResult(win, 0);
																						overridePendingTransition(0, 0);
																					}
																				});
																			}
																		};
																		_timer.schedule(anim, (int) (1001));
																	}
																});
															}
														};
														_timer.schedule(anim, (int) (1000));
													} else {
														if (save.getString("lang", "").equals("ru")) {
															text = "Продолжить";
														} else {
															text = "Continue";
														}
														anim = new TimerTask() {
															@Override
															public void run() {
																runOnUiThread(new Runnable() {
																	@Override
																	public void run() {
																		_decoder(textview5, text, num);
																		if (num > text.length()) {
																			_end(anim, num);
																			textview5.setOnClickListener(new View.OnClickListener() {
																				@Override
																				public void onClick(View _view) {
																					_off();
																					final AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
																					final AlphaAnimation fadeOut = new AlphaAnimation(1.0f, 0.0f);

																					linear1.startAnimation(fadeIn);
																					linear1.startAnimation(fadeOut);
																					fadeIn.setDuration(1000);
																					fadeIn.setFillAfter(true);
																					fadeOut.setDuration(1000);
																					fadeOut.setFillAfter(true);
																					fadeOut.setStartOffset(10 + fadeIn.getStartOffset());
																					anim2 = new TimerTask() {
																						@Override
																						public void run() {
																							runOnUiThread(new Runnable() {
																								@Override
																								public void run() {
																									win.putExtra("chapter", "Chapter ".concat(getIntent().getStringExtra("chap")));
																									win.putExtra("chap", getIntent().getStringExtra("chap"));
																									win.putExtra("retitle", "Entanglement");
																									win.putExtra("end", "gl");
																									win.setClass(getApplicationContext(), ChapterActivity.class);
																									startActivity(win);
																									finish();
																								}
																							});
																						}
																					};
																					_timer.schedule(anim2, (int) (1001));
																				}
																			});
																			if (save.getString("lang", "").equals("ru")) {
																				text = "В Меню";
																			} else {
																				text = "On the menu";
																			}
																			anim = new TimerTask() {
																				@Override
																				public void run() {
																					runOnUiThread(new Runnable() {
																						@Override
																						public void run() {
																							_decoder(textview3, text, num);
																							if (num > text.length()) {
																								_end(anim, num);
																								textview3.setOnClickListener(new View.OnClickListener() {
																									@Override
																									public void onClick(View _view) {
																										_off();
																										final AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
																										final AlphaAnimation fadeOut = new AlphaAnimation(1.0f, 0.0f);

																										linear1.startAnimation(fadeIn);
																										linear1.startAnimation(fadeOut);
																										fadeIn.setDuration(1000);
																										fadeIn.setFillAfter(true);
																										fadeOut.setDuration(1000);
																										fadeOut.setFillAfter(true);
																										fadeOut.setStartOffset(10 + fadeIn.getStartOffset());
																										anim2 = new TimerTask() {
																											@Override
																											public void run() {
																												runOnUiThread(new Runnable() {
																													@Override
																													public void run() {
																														win.setClass(getApplicationContext(), Main12Activity.class);
																														startActivity(win);
																													}
																												});
																											}
																										};
																										_timer.schedule(anim2, (int) (1001));
																									}
																								});
																							}
																						}
																					});
																				}
																			};
																			_timer.scheduleAtFixedRate(anim, (int) (1000), (int) (100));
																		}
																	}
																});
															}
														};
														_timer.scheduleAtFixedRate(anim, (int) (1000), (int) (100));
													}
												}
											}
										});
									}
								};
								_timer.scheduleAtFixedRate(anim, (int) (500), (int) (100));
							}
						}
					});
				}
			};
			_timer.scheduleAtFixedRate(anim, (int) (500), (int) (100));
		}
	}

	@Override
	public void onBackPressed() {

	}

	public void _decoder(final TextView _view, final String _text, final double _num) {
		_view.setText(_text.substring((int) (0), (int) (_num)));
		num++;
	}


	public void _end(final TimerTask _anim, final double _num) {
		_anim.cancel();
		num = 0;
	}


	public void _in() {
		final AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
		final AlphaAnimation fadeOut = new AlphaAnimation(1.0f, 0.0f);

		linear1.startAnimation(fadeIn);
		linear1.startAnimation(fadeOut);
		fadeIn.setDuration(1);
		fadeIn.setFillAfter(true);
		fadeOut.setDuration(1);
		fadeOut.setFillAfter(true);
		fadeOut.setStartOffset(10 + fadeIn.getStartOffset());
	}


	public void _out() {
		final AlphaAnimation fadeIn = new AlphaAnimation(1.0f, 0.0f);
		final AlphaAnimation fadeOut = new AlphaAnimation(0.0f, 1.0f);

		linear1.startAnimation(fadeIn);
		linear1.startAnimation(fadeOut);
		fadeIn.setDuration(1000);
		fadeIn.setFillAfter(true);
		fadeOut.setDuration(1000);
		fadeOut.setFillAfter(true);
		fadeOut.setStartOffset(10 + fadeIn.getStartOffset());
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


	public void _off() {
		textview1.setEnabled(false);
		textview2.setEnabled(false);
		textview5.setEnabled(false);
		textview3.setEnabled(false);
	}
}