# Dialog

巩固整理下Dialog相关知识点。

# AlertDialog

Dialog类是所有弹窗的父类，官方建议我们不要直接实例化他，建议使用其子类来获取Dialog的实例，AlertDialog是系统提供的一个
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
```

###### 2、其他对话框

- ProgressDialog：弃用，使用ProgressBar代替。
- 

# 自定义Dialog

# 参考

[官方文档](https://developer.android.com/develop/ui/views/components/dialogs)