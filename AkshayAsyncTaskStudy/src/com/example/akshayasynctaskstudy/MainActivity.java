package com.example.akshayasynctaskstudy;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	TextView tv;

	// Thread t;
	MyAsyncTask mat;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tv = (TextView) findViewById(R.id.textView1);

		// --------->>>> Normal Thread cannot access UI Elements
		// <<<<<<-------------
		// t = new Thread(new Runnable() {
		// @Override
		// public void run() {
		// for (int i = 0; i <= 10; i++) {
		// try {
		// Thread.sleep(1000);
		// } catch (Exception e) {
		// }
		// tv.setText("" + i);
		// }
		// }
		// });
		
		mat = new MyAsyncTask();

	}

	public void startCounting(View v) {
		// t.start();
		mat.execute("");
	}

	public void stopCounting(View v) {
		// t.stop();
		mat.cancel(true);
	}

	class MyAsyncTask extends AsyncTask<String, Integer, String> {

		@Override
		protected String doInBackground(String... params) {
			for (int i = 0; i <= 100; i++) {
				try {
					Thread.sleep(100);
				} catch (Exception e) {
				}

				if (i % 10 == 0) {
					publishProgress(i);
				}

			}

			return "Work Done";
		}

		@Override
		protected void onProgressUpdate(Integer... values) {

			tv.setText("" + values[0]);
			super.onProgressUpdate(values);
		}

		@Override
		protected void onPostExecute(String result) {

			tv.setText("" + result);
			Toast.makeText(getBaseContext(), result, Toast.LENGTH_SHORT).show();
			super.onPostExecute(result);
		}
	}

}
