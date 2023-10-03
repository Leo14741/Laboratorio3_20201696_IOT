package com.example.laboratorio3_20201696;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapEvent extends RecyclerView.Adapter<ListAdapEvent.ViewHolder> {
    private List<listElement> mData;
    private LayoutInflater mInflater;
    private Context context;
    public ListAdapEvent(List<listElement> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData=itemList;
    }
    @Override
    public int getItemCount(){return mData.size();}
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.list_element,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position){
        holder.binData(mData.get(position));
    }
    public void setItems (List<listElement> items){mData=items;}
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,first,last,genero,ciudad,pais,email,phone;
        ViewHolder(View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.titulo);
            first = itemView.findViewById(R.id.first);
            last = itemView.findViewById(R.id.last);
            genero = itemView.findViewById(R.id.genero);
            ciudad = itemView.findViewById(R.id.ciudad);
            pais = itemView.findViewById(R.id.pais);
            email = itemView.findViewById(R.id.email);
            phone = itemView.findViewById(R.id.phone);
        }
        void binData(final listElement item){
            title.setText(item.getTitulo());
            first.setText(item.getFirst());
            last.setText(item.getLast());
            genero.setText(item.getGenero());
            ciudad.setText(item.getCiudad());
            pais.setText(item.getPais());
            email.setText(item.getEmail());
            phone.setText(item.getTelefono());
        }
    }
}
