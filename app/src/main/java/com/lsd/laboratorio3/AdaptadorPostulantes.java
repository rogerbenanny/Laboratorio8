package com.lsd.laboratorio3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorPostulantes extends RecyclerView.Adapter<AdaptadorPostulantes.ViewHolderPostulantes>{

    ArrayList<Postulante> listaPostulantes;

    public AdaptadorPostulantes(ArrayList<Postulante> listaPostulantes) {
        this.listaPostulantes = listaPostulantes;
    }

    @NonNull
    @Override
    public ViewHolderPostulantes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_postulantes,null,false);
        return new ViewHolderPostulantes(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPostulantes holder, int position) {
        holder.asignarDatos(listaPostulantes.get(position));
    }

    @Override
    public int getItemCount() {
        return listaPostulantes.size();
    }

    public class ViewHolderPostulantes extends RecyclerView.ViewHolder {

        TextView etiNombre, etiInformacion;

        public ViewHolderPostulantes(@NonNull View itemView) {
            super(itemView);
            etiNombre =(TextView) itemView.findViewById(R.id.idNombre);
            etiInformacion =(TextView) itemView.findViewById(R.id.idInfo);

        }

        public void asignarDatos(Postulante postulante) {
            etiNombre.setText(postulante.getNombre());
            etiInformacion.setText(postulante.getCarrera());
        }
    }
}
