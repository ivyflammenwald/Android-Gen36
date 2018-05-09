import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dell.misintetizador_17.R;

public class FraseAdapter extends RecyclerView.Adapter<FraseAdapter.ViewHolder>
{


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView fraseTextView;


            public ViewHolder(View itemView) {

                super(itemView);

                fraseTextView = (TextView) itemView.findViewById( R.id.frase_n);

            }
        }
}
