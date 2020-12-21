package com.only.aquahack.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.only.aquahack.Models.Device;
import com.only.aquahack.R;
import java.util.List;



public class DeviceRecyclerViewAdapter extends RecyclerView.Adapter<DeviceRecyclerViewAdapter.ViewHolder>{



    private Context context;
    private List<Device> deviceList;

    public DeviceRecyclerViewAdapter(Context context, List<Device> devices) {
        this.context = context;
        deviceList = devices;
    }

    @Override
    public DeviceRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.device_row, parent, false);



        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(DeviceRecyclerViewAdapter.ViewHolder holder, int position) {

        Device device = deviceList.get(position);


holder.code.setText( device.getCode());
String alma = "Borc : " + device.getDebt()+" AZN";
holder.debt.setText(alma);

alma = "Son Yenilənmə : "+device.getLast_sync().substring(0,10);
holder.last_sync.setText(alma);
holder.location.setText("Adres : "+device.getLocation());

if(device.getType().equals("Ehali")){

    holder.tip.setBackgroundResource(R.drawable.home);

}
else
{
    holder.tip.setBackgroundResource(R.drawable.factory);
}

    }

    @Override
    public int getItemCount() {
        return deviceList.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {

        TextView code;
        TextView debt;
        TextView last_sync;
        TextView location;
        ImageView tip;


        public ViewHolder(View itemView, final Context ctx) {
            super(itemView);
            context = ctx;

            code =  itemView.findViewById(R.id.abonentKodu);
            tip =  itemView.findViewById(R.id.abonentTipi);
            last_sync =  itemView.findViewById(R.id.synDate);
            debt =  itemView.findViewById(R.id.borc);
            location = itemView.findViewById(R.id.location);


        }


    }
}
