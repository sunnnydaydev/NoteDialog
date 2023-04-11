# Dialog

巩固整理下Dialog相关知识点。

# AlertDialog

Dialog类是所有弹窗的父类，官方建议我们不要直接实例化它，建议使用其子类来获取Dialog的实例，AlertDialog是系统提供的一个
直接子类，帮助我们快速构建出不同类型的弹窗。接下来就看下各种类型弹窗的使用。

###### 1、普通对话框

```kotlin
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
        //Neutral按钮，显示在dialog的最左面。
        .setNeutralButton("Neutral", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                Toast.makeText(applicationContext, "Neutral", Toast.LENGTH_SHORT).show()
            }
        })
    val dialog = builder.create()
    dialog.show()
}
```

###### 2、单选对话框

```kotlin
    private fun showSingleChoiceAlertDialog(){
        val subj = arrayOf("android", "linux", "java", "ios", "c", "html")
        val builder = AlertDialog.Builder(this@AlertDialogActivity)
            .setIcon(R.mipmap.ic_launcher)
            .setTitle("单选对话框")
            // 第二个参数为默认选中项 在这里设为第一项
            .setSingleChoiceItems(subj, 0) { dialog, which ->
            Toast.makeText(this@AlertDialogActivity, "我选择" + subj[which] + "这门课", Toast.LENGTH_SHORT)
                .show()
        }.setPositiveButton("提交") { dialog, which ->
            Toast.makeText(this@AlertDialogActivity, "您已经提交您的选择", Toast.LENGTH_SHORT).show()
        }.setNeutralButton("取消"){
                    dialog, which ->
                Toast.makeText(this@AlertDialogActivity, "您点击了取消按钮", Toast.LENGTH_SHORT).show()
            }
        val dialog = builder.create()
        dialog.show()
    }
```

###### 3、多选对话框

```kotlin
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
                        Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(
                        this@AlertDialogActivity,
                        "我不喜欢" + subj[which],
                        Toast.LENGTH_SHORT).show()
                }
            }.setPositiveButton("提交") { dialog, which ->
            Toast.makeText(this@AlertDialogActivity, "您已经提交您的选择", Toast.LENGTH_SHORT).show()
        }.setNeutralButton("取消") { dialog, which ->
                Toast.makeText(this@AlertDialogActivity, "您关闭了弹窗", Toast.LENGTH_SHORT).show()
            }
        val dialog = builder.create()
        dialog.show()
    }
```

###### 4、列表对话框

```kotlin
    /**
     * 列表对话框，内容多了就可滚动。这个dialog感觉没啥用。
     * ps：当单选、多选对话框的内容多了也可滚动。
     * */
    private fun showListAlertDialog() {
        val subj = arrayOf("android", "linux", "java", "ios", "c","kotlin")
        val builder = AlertDialog.Builder(this)
        .setIcon(R.mipmap.ic_launcher)
        .setTitle("列表对话框")
        .setItems(subj) { dialog, which ->
            Toast.makeText(this@AlertDialogActivity, "您选择了" + subj[which], Toast.LENGTH_SHORT).show()
        }
        val dialog = builder.create()
        dialog.show()
    }
```

###### 5、自定义对话框

AlertDialog的UI我们不满意时也是可以稍加定制的。


###### 其他对话框

- ProgressDialog：弃用，使用ProgressBar代替。
- 

# 自定义Dialog

# 参考

[官方文档](https://developer.android.com/develop/ui/views/components/dialogs)