package com.sunnyday.notedialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class AlertDialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)
        showNormalAlertDialog()
    }

    /**
     * AlertDialog默认UI样式
     * */
    private fun showNormalAlertDialog() {
        val builder = AlertDialog.Builder(this)
            .setIcon(R.mipmap.ic_launcher)
            .setTitle("Dialog Title")
            .setMessage("Dialog Message")
            .setPositiveButton("确定", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(applicationContext, "确定按钮", Toast.LENGTH_SHORT).show()
                }
            })
            .setNegativeButton("取消", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(applicationContext, "取消按钮", Toast.LENGTH_SHORT).show()
                }
            })
             //中立按钮，显示在dialog的最左面。
            .setNeutralButton("中立", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(applicationContext, "中立按钮", Toast.LENGTH_SHORT).show()
                }
            })
        val dialog = builder.create()
        dialog.show()
    }

    private fun showSingleChoiceAlertDialog(){

    }
}