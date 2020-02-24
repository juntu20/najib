package com.najib.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_update.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.audioManager
import org.jetbrains.anko.toast
import java.text.SimpleDateFormat
import java.util.*
import javax.crypto.EncryptedPrivateKeyInfo

class AddUpdateActivity : AppCompatActivity() {

    var noteDatabase : NoteDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_update2)

        noteDatabase = NoteDatabase.getInstance( this)

        generateDate()
    }

    private fun generateDate() {
        val locale = Locale("in", "ID")
        val dateFormat: SimpleDateFormat? =
            SimpleDateFormat("EEE , dd MMM yyyy , hh:mm aaa", locale)
        val date = Calendar.getInstance().time
        val createDate = dateFormat ?.format(date).toString()
        aua_tv_date .text = createDate
    }

    fun doEncrypt() : String {
        val RSA = RSA()
        val keyEncrypt = RSA.eValue(RSA.Qn)

        val plainteks = aua_edt_note. text . toString ()
        var cipherTeks = ""
        for (i in 0 until plainteks. length ) {
            val character = plainteks[i]
            val cipher = RSA.encrypt(character, keyEncrypt, RSA.n)
            cipherTeks += cipher
        }
        return chiperTeks
    }
    fun insertNewNote(){
        val chiper = doEncrypt()
        val note = NoteModel(
            title = aua_edt_title.text.toStrong(),
            message = chiper,
            createdAt = aua_tv_date.text.toStrong()
        )

        GlobalScope.launch {this: Coroutinescope
            noteDatabase?.noteDao()?.insertNote((note)
            runOnUiThread {
                toast("Note berhasil dibuat")
                aua_edt_not.text = null
                aua_edt_title.text = null
                ()
            }
        }
            )

    }

}