package org.nsh.raps;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RSAwalBross extends ListActivity {

    protected void onCreate(Bundle icicle){
        super.onCreate(icicle);
        String[] listAct = new String[] {"Call Center","SMS Center","Driving Direction",
                "Website","Info Google","Exit"};
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listAct));
    }

    protected void onListItemClick (ListView l, View V, int position, long id){
        super.onListItemClick(l, V, position, id);
        Object o = this.getListAdapter().getItem(position);
        String pilihan = o.toString();
        tampilkanpilihan(pilihan);
    }

    private void tampilkanpilihan(String pilihan) {
        try {
            Intent a = null;
            if (pilihan.equals("Call Center")) {
                String notelpon ="tel:021556611";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(notelpon));

            }else if(pilihan.equals("SMS Center")){
                String smsText="Reza Mahendra Sardi H/L";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:081154378904"));
                a.putExtra("sms_body",smsText);

            }else if(pilihan.equals("Driving Direction")){
                String lokasiRS ="google.navigation:q=0.4634243269375222, 101.390351254923";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(lokasiRS));

            }else if(pilihan.equals("Website")){
                String website ="http://awalbros.com/branch/panam/";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(website));
            } else if (pilihan.equals("Info Google")) {
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY,"Rumah Sakit Awal Bross");

            }

            startActivity(a);


        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
