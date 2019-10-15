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
import com.example.entregavelrestaurante.model.Prato;
import com.example.entregavelrestaurante.model.RestauranteModelo;
import com.example.entregavelrestaurante.views.activitys.DetalheRestauranteActivity;

import java.util.List;


public class RestauranteAdapter extends RecyclerView.Adapter<RestauranteAdapter.ViewHolder> {
    private List<RestauranteModelo> ListaDeRestaurantes;
    private RecycleOnClick recycleOnClick;

    public RestauranteAdapter(List<RestauranteModelo> listaDeRestaurantes, RecycleOnClick listener){
        this.ListaDeRestaurantes = listaDeRestaurantes;
        this. recycleOnClick = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.modelo_restaurante, viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final RestauranteModelo restauranteModelo = ListaDeRestaurantes.get(position);
        holder.onBind(restauranteModelo);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recycleOnClick.onClick(restauranteModelo);

            }
        });
    }

    @Override
    public int getItemCount() {
        return ListaDeRestaurantes.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nomeRestau;
        private TextView endRestau;
        private TextView horarioRestau;
        private ImageView fotoRestau;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nomeRestau = itemView.findViewById(R.id.NomeRestaurante);
            endRestau = itemView.findViewById(R.id.EnderecoRestaurante);
            horarioRestau = itemView.findViewById(R.id.HorarioDeFuncionamento);
            fotoRestau = itemView.findViewById(R.id.imageView2);


        }

        public void onBind(RestauranteModelo restauranteModelo) {
            Drawable drawable = itemView.getResources().getDrawable(restauranteModelo.getFotoRest());
            fotoRestau.setImageDrawable(drawable);
            nomeRestau.setText( restauranteModelo.getNomeRest());
            endRestau.setText( restauranteModelo.getEndRrest());
            horarioRestau.setText( restauranteModelo.getFuncionamentoRest());

        }
    }
}
