package com.example.androidelementary.mydialogfragment

import android.app.Dialog
import android.content.DialogInterface
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity

/**
 * Created by ypp on 2020/12/31
 */
abstract class BaseDialogFragment : DialogFragment() {

    var isViewValid = false
        protected set

    protected lateinit var dialogParams: DialogParams

    abstract fun createParams(): DialogParams

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isViewValid = false
        dialogParams = createParams().also {
            setStyle(it.dialogStyle, it.dialogTheme)
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState).apply {
            requestWindowFeature(dialogParams.windowFeature)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(dialogParams.layoutId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isViewValid = true
        //业务逻辑
        dialog?.setOnKeyListener { _: DialogInterface?, keyCode: Int, event: KeyEvent ->
            // Events will trigger action_down and action_up, so filter them.
            if (KeyEvent.KEYCODE_BACK == keyCode && KeyEvent.ACTION_UP == event.action) {
                onBackPressed()
                return@setOnKeyListener false
            }
            false
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.apply {
            setCanceledOnTouchOutside(dialogParams.canceledOnTouchOutside)
            window?.apply {
                setBackgroundDrawable(dialogParams.backgroundDrawable)
                attributes = attributes.apply {
                    dimAmount = dialogParams.dimAmount
                    width = dialogParams.width
                    height = dialogParams.height
                    gravity = dialogParams.gravity
                    softInputMode = dialogParams.softInputMode
                }
            }
        }
    }

    override fun onDestroyView() {
        isViewValid = false
        super.onDestroyView()
    }

    class DialogParams(var layoutId: Int) {
        var dialogStyle = STYLE_NO_TITLE
        var dialogTheme = -1
        var windowFeature = Window.FEATURE_NO_TITLE
        var canceledOnTouchOutside = true
        var dimAmount = 0.5f
        var gravity = 0
        var width = WindowManager.LayoutParams.MATCH_PARENT
        var height = Int.MIN_VALUE
        var backgroundDrawable: Drawable = ColorDrawable(0)
        var softInputMode = WindowManager.LayoutParams.SOFT_INPUT_STATE_UNSPECIFIED
    }

    protected open fun onBackPressed(): Boolean = false

    override fun dismiss() = dismissAllowingStateLoss()

    override fun onCancel(dialog: DialogInterface) {
        if (isViewValid) {
            dismissAllowingStateLoss()
        }
    }

    companion object {
        @JvmStatic
        fun show(fragmentActivity: FragmentActivity?, dialogFragment: BaseDialogFragment?) {
            fragmentActivity?.let {
                dialogFragment?.show(it.supportFragmentManager, dialogFragment.javaClass.canonicalName ?: "")
            }
        }
    }

}