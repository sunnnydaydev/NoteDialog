package com.sunnyday.notedialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class AlertDialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)
        // showNormalAlertDialog()
        // showSingleChoiceAlertDialog()
        // showMultipleChoiceAlertDialog()
       // showListAlertDialog()
        showCustomAlertDialog()
    }

    /**
     * AlertDialog默认UI样式
     * */
    private fun showNormalAlertDialog() {
        val builder = AlertDialog.Builder(this)
            .setIcon(R.mipmap.ic_launcher)
            .setTitle("Dialog Title")
            .setMessage("Dialog Message")
            .setPositiveButton("Sure", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(applicationContext, "Sure", Toast.LENGTH_SHORT).show()
                }
            })
            .setNegativeButton("Cancel", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(applicationContext, "Cancel", Toast.LENGTH_SHORT).show()
                }
            })
            //中立按钮，显示在dialog的最左面。
            .setNeutralButton("Neutral", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(applicationContext, "Neutral", Toast.LENGTH_SHORT).show()
                }
            })
        val dialog = builder.create()
        dialog.show()
    }

    private fun showSingleChoiceAlertDialog() {
        val subj = arrayOf("android", "linux", "java", "ios", "c", "html")
        val builder = AlertDialog.Builder(this@AlertDialogActivity)
            .setIcon(R.mipmap.ic_launcher)
            .setTitle("单选对话框")
            // 第二个参数为默认选中项 在这里设为第一项
            .setSingleChoiceItems(subj, 0) { dialog, which ->
                Toast.makeText(
                    this@AlertDialogActivity,
                    "我选择" + subj[which] + "这门课",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }.setPositiveButton("提交") { dialog, which ->
                Toast.makeText(this@AlertDialogActivity, "您已经提交您的选择", Toast.LENGTH_SHORT).show()
            }.setNeutralButton("取消") { dialog, which ->
                Toast.makeText(this@AlertDialogActivity, "您点击了取消按钮", Toast.LENGTH_SHORT).show()
            }
        val dialog = builder.create()
        dialog.show()
    }

    private fun showMultipleChoiceAlertDialog() {
        val subj = arrayOf("android", "linux", "java", "ios", "c")
        val builder = AlertDialog.Builder(this)
            .setIcon(R.mipmap.ic_launcher)
            .setTitle("多选对话框")
            .setMultiChoiceItems(subj, null) { dialog, which, isChecked ->
                if (isChecked) {
                    Toast.makeText(
                        this@AlertDialogActivity,
                        "我喜欢" + subj[which],
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this@AlertDialogActivity,
                        "我不喜欢" + subj[which],
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }.setPositiveButton("提交") { dialog, which ->
                Toast.makeText(this@AlertDialogActivity, "您已经提交您的选择", Toast.LENGTH_SHORT).show()
            }.setNeutralButton("取消") { dialog, which ->
                Toast.makeText(this@AlertDialogActivity, "您关闭了弹窗", Toast.LENGTH_SHORT).show()
            }
        val dialog = builder.create()
        dialog.show()
    }

    /**
     * 列表对话框，内容多了就可滚动。这个dialog感觉没啥用。
     * ps：当单选、多选对话框的内容多了也可滚动。
     * */
    private fun showListAlertDialog() {
        val subj = arrayOf("android", "linux", "java", "ios", "c", "kotlin")
        val builder = AlertDialog.Builder(this)
            .setIcon(R.mipmap.ic_launcher)
            .setTitle("列表对话框")
            .setItems(subj) { dialog, which ->
                Toast.makeText(this@AlertDialogActivity, "您选择了" + subj[which], Toast.LENGTH_SHORT)
                    .show()
            }
        val dialog = builder.create()
        dialog.show()
    }

    /**
     * 基于AlertDialog进行自定义对话框
     * 标题、title的UI格式已经被定制过了，我们可以定义其下方区域的ui
     * */
    private fun showCustomAlertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setIcon(R.mipmap.ic_launcher)
        builder.setTitle("Custom AlertDialog")
        val inflater = LayoutInflater.from(this)
        val v: View = inflater.inflate(R.layout.layout_custom_alert_dialog, null)
        builder.setView(v)
        val dialog = builder.create()
        dialog.show()
    }

}