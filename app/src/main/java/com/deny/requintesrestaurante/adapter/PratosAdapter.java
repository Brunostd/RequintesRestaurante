package com.deny.requintesrestaurante.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.deny.requintesrestaurante.R;
import com.deny.requintesrestaurante.model.PratosModel;

import java.util.List;

public class PratosAdapter extends RecyclerView.Adapter<PratosAdapter.MyViewHolder> {

    private List<PratosModel> pratosModels;
    private Context context;

    public PratosAdapter(List<PratosModel> pratosModels, Context context) {
        this.pratosModels = pratosModels;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View prato = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pratos, parent, false);
        return new MyViewHolder( prato );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        PratosModel pratosModel = pratosModels.get(position);

        int     imagem     = Integer.parseInt(String.valueOf(pratosModel.getImagem()));
        String  nome       = String.valueOf(pratosModel.getNome());
        String  quantidade = String.valueOf(pratosModel.getQuantidade());
    }

    @Override
    public int getItemCount() {
        return pratosModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView   imagem;
        private TextView    quantidade;
        private TextView    nome;
        private Button      buttonAdicionar;
        private Button      buttonDiminuir;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imagem          = itemView.findViewById(R.id.imageViewDaComida);
            quantidade      = itemView.findViewById(R.id.textViewQuantidade);
            nome            = itemView.findViewById(R.id.textViewNomeDaComida);
            buttonAdicionar = itemView.findViewById(R.id.buttonAdicionarComida);
            buttonDiminuir  = itemView.findViewById(R.id.buttonDiminuirComida);
        }
    }
}
