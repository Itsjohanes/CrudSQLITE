package com.johannes2002895.notesgw.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.johannes2002895.notesgw.CustomOnItemClickListener;
import com.johannes2002895.notesgw.NoteAddUpdateActivity;
import com.johannes2002895.notesgw.R;
import com.johannes2002895.notesgw.entity.MyNotes;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.NoteViewHolder> {


    private final ArrayList<MyNotes> MyNotes = new ArrayList<>();
    private final Activity activity;

    public adapter(Activity activity){
        this.activity  = activity;
    }

    public ArrayList<MyNotes> getNotes (){
        return MyNotes;
    }
    public void setMyNotes(ArrayList<MyNotes> MyNotes){
        if(MyNotes.size() > 0 ){
            this.MyNotes.clear();
        }
        this.MyNotes.addAll(MyNotes);

        notifyDataSetChanged();

    }
    public void addItem(MyNotes notes){
        this.MyNotes.add(notes);
        notifyItemInserted(MyNotes.size() - 1);
    }
    public void updateItem(int position, MyNotes notes){
        this.MyNotes.set(position,notes);
        notifyItemChanged(position, notes);
    }
    public void removeItem(int position){
        this.MyNotes.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,MyNotes.size());
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notes,parent,false);
        return new NoteViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.tvTitle.setText(MyNotes.get(position).getTitle());
        holder.tvDate.setText(MyNotes.get(position).getDate());
        holder.tvDescription.setText(MyNotes.get(position).getDescription());
        holder.cvNote.setOnClickListener(new CustomOnItemClickListener(position, (view, position1) -> {
            Intent intent = new Intent(activity, NoteAddUpdateActivity.class);
            intent.putExtra(NoteAddUpdateActivity.EXTRA_POSITION, position1);
            intent.putExtra(NoteAddUpdateActivity.EXTRA_NOTE, MyNotes.get(position1));
            activity.startActivityForResult(intent, NoteAddUpdateActivity.REQUEST_UPDATE);
        }));

    }

    @Override
    public int getItemCount() {
        return MyNotes.size();
    }


    static class NoteViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle, tvDescription, tvDate;
        final CardView cvNote;
        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
            tvDate = itemView.findViewById(R.id.tv_item_date);
            cvNote = itemView.findViewById(R.id.cv_item_note);
        }
    }
}
