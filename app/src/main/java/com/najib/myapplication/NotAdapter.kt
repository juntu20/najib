package com.najib.myapplication

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class NotAdapter (var List: List<NoteModel>?)
    : RecyclerView.Adapter<NotAdapter.ViewHolder>(){
    class ViewHolder {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context,.inflate
                    R.layout.item_note,
                    parent,
                attachToRoot:false
        )
        )
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onBindViewHolder(holder: NoteAdapter.ViewHolder, position: Int) {
        holder?.bind(position)
    }

    fun parseDatePart(date: String?): ArrayList<String> {
        val locale = Locale("in", "ID")
        val dateFormat: SimpleDateFormat? = SimpleDateFormat("EEE ,
                dd MMM yyyy , hh:mm aaa", locale)
            val listDate: ArrayList<String> = ArrayList()
        val dateParse = dateFormat?.parse(date.toString())
        val fullday = SimpleDat
        eFormat("EEEE",
            locale).format(dateParse)
        listDate.add(fullday)
        val dateNumber = SimpleDateFormat("dd",
            locale).format(dateParse)
        listDate.add(dateNumber)
        val halfMonth = SimpleDateFormat("MMM",
            locale).format(dateParse)
        listDate.add(halfMonth)
        val year = SimpleDateFormat("yyyy", locale).format(dateParse)
        listDate.add(year)
        val time = SimpleDateFormat("hh:mm aaa",
            locale).format(dateParse)
        listDate.add(time)
        return listDate
    }
    fun setListOfNotes(listNote: List<NoteModel>?){
        list = listNote
        notifyDataSetChanged()
    }
}