package com.example.tare22;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ViewHolder> {

    private List<Contacto> lista;

    public ContactoAdapter(List<Contacto> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemcontacto, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contacto c = lista.get(position);
        holder.nombre.setText(c.getNombre());
        holder.correo.setText(c.getCorreo());
        holder.telefono.setText(c.getTelefono());
        holder.tipo.setText(c.getTipo());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, correo, telefono, tipo;

        ViewHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.itemNombre);
            correo = itemView.findViewById(R.id.itemCorreo);
            telefono = itemView.findViewById(R.id.itemTelefono);
            tipo = itemView.findViewById(R.id.itemTipo);
        }
    }
}
