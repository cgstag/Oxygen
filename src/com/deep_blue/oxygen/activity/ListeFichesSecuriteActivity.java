package com.deep_blue.oxygen.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.deep_blue.oxygen.R;
import com.deep_blue.oxygen.dao.FicheSecuriteDao;
import com.deep_blue.oxygen.listener.ListeFichesSecuriteOnClickListener;
import com.deep_blue.oxygen.model.EnumEtat;
import com.deep_blue.oxygen.model.FicheSecurite;
import com.deep_blue.oxygen.model.ListeFichesSecurite;
import com.deep_blue.oxygen.model.Utilisateur;
import com.deep_blue.oxygen.thread.SynchThread;
import com.deep_blue.oxygen.util.DateStringUtils;
import com.deep_blue.oxygen.util.IntentKey;

public class ListeFichesSecuriteActivity extends Activity {

	private Utilisateur utilisateur;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);

		Intent intent = getIntent();
		utilisateur = (Utilisateur) intent
				.getParcelableExtra(IntentKey.UTILISATEUR_COURANT.toString());

		TableLayout tableLayout = (TableLayout) findViewById(R.id.tableLayout1);
		FicheSecuriteDao ficheSecuriteDao = new FicheSecuriteDao(this);
		ListeFichesSecurite listeFiche = ficheSecuriteDao.getAll();

		int i = 0;
		for (FicheSecurite ficheSecurite : listeFiche) {

			TableRow row = new TableRow(this);
			TableRow.LayoutParams lp = new TableRow.LayoutParams(
					TableRow.LayoutParams.WRAP_CONTENT);
			row.setLayoutParams(lp);
			ImageView ivIcon = new ImageView(this);
			if (ficheSecurite.getEtat().equals(EnumEtat.SYNCHRONISE)) {
				ivIcon.setMaxWidth(40);
				ivIcon.setPadding(2, 2, 2, 2);
				ivIcon.setAdjustViewBounds(true);
				ivIcon.setImageDrawable(getResources().getDrawable(
						R.drawable.inprogressstatus));
				// ivIcon.setPadding(5, 25, 5, 25);
			} else if (ficheSecurite.getEtat().equals(EnumEtat.VALIDE)) {
				ivIcon.setImageDrawable(getResources().getDrawable(
						R.drawable.closedstatus));
				ivIcon.setAdjustViewBounds(true);
				// ivIcon.setPadding(5, 25, 5, 25);
			}

			TextView tvDescription = new TextView(this);
			String dateString = DateStringUtils.timestampsToDate(ficheSecurite
					.getTimestamp());
			String hourString = DateStringUtils.timestampsToHeure(ficheSecurite
					.getTimestamp());

			String textDescription = "Plong�" + (ficheSecurite.getSite() != null ? " � "+ficheSecurite.getSite().getNom(): "")
					+ " le " + dateString + " � " + hourString;
			tvDescription.setText(textDescription);
			// tvDescription.setPadding(15, 0, 15, 0);

			// Coloration selon la parit� de la row
			if (i % 2 == 0)
				row.setBackgroundResource(R.drawable.list_item_background_1);
			else
				row.setBackgroundResource(R.drawable.list_item_background_2);

			// Clik listener sur la row
			row.setOnClickListener(new ListeFichesSecuriteOnClickListener(
					ficheSecurite, utilisateur, this));

			// Ajout du contenu de la row et ajout de la row dans la table
			row.addView(ivIcon);
			row.addView(tvDescription);
			tableLayout.addView(row, i);

			i++;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.liste_fiches_securite, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId()) {

		case R.id.itemParam:
			Intent intent = new Intent(ListeFichesSecuriteActivity.this,
					ParametreActivity.class);
			startActivity(intent);
			return true;

		case R.id.itemSync:
			Thread synchThread = new SynchThread(this, utilisateur);
			synchThread.start();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}