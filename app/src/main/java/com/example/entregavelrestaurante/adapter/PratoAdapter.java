package com.example.entregavelrestaurante.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.entregavelrestaurante.R;
import com.example.entregavelrestaurante.interfaces.RecycleOnClick;
import com.example.entregavelrestaurante.interfaces.RecyleOnClickPrato;
import com.example.entregavelrestaurante.model.Prato;
import com.example.entregavelrestaurante.model.RestauranteModelo;
import com.example.entregavelrestaurante.views.activitys.DetalheRestauranteActivity;

import java.util.List;

public class PratoAdapter extends RecyclerView.Adapter<PratoAdapter.ViewHolder> {
    private List<Prato> pratoList;
    private RecyleOnClickPrato recyleOnClickPrato;

    public PratoAdapter(List<Prato> pratoList1, DetalheRestauranteActivity listener){
        this.pratoList = pratoList1;
        this.recyleOnClickPrato = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.modelo_prato, viewGroup,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull PratoAdapter.ViewHolder holder, int position) {
        final Prato prato = pratoList.get(position);
        holder.onBind((Prato) prato);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyleOnClickPrato.onClickDois( prato);

            }
        });
    }

    @Override
    public int getItemCount() {
        return pratoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView PratoNome;
        private ImageView FotoPrato;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            PratoNome = itemView.findViewById(R.id.NomePrato);
            FotoPrato = itemView.findViewById(R.id.imagemPrato);
        }

        public void onBind(Prato prato) {
            Drawable drawable = itemView.getResources().getDrawable(prato.getFotoPrato());
            FotoPrato.setImageDrawable(drawable);
            PratoNome.setText(prato.getNomePrato());
        }
    }
}
