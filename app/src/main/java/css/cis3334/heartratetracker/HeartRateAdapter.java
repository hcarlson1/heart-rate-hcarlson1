package css.cis3334.heartratetracker;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hcarlson1 on 2/17/2017.
 */

public class HeartRateAdapter extends ArrayAdapter<HeartRate> {
    private Context context;
    private HeartRateList heartRateList;


    public HeartRateAdapter(Context context,
                            int resource,
                            int textViewResourceId,
                            HeartRateList heartRateList) {
        super(context, resource, textViewResourceId, heartRateList.getList());

        this.context = context;
        this.heartRateList = heartRateList;


    }
    public View getView(int position, View convertView, ViewGroup parent){


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.heart_rate_row, null);
        //get the heart rate we are displaying
        TextView tvPulse = (TextView) view.findViewById(R.id.textViewPulse);
        //get the range name
        TextView tvRange = (TextView) view.findViewById(R.id.textViewRangeName);
        //get the range name
        TextView tvDescription = (TextView) view.findViewById(R.id.textViewRangeDescription);

        HeartRate hr = heartRateList.getHeartRate(position);

        tvPulse.setText(hr.getPulse().toString());
        tvRange.setText(hr.getRangeName().toString());
        tvDescription.setText(hr.getRangeDescrtiption().toString());
        tvRange.setTextColor(ContextCompat.getColor(context, hr.getRangeColor()));

        return(view);

    }
}
