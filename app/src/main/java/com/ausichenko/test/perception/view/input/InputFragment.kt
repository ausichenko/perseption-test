package com.ausichenko.test.perception.view.input

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import com.ausichenko.test.perception.R
import kotlinx.android.synthetic.main.fragment_input.*

class InputFragment : Fragment() {

    private val isSuccessArg = "isSuccess"
    private val millisArg = "millis"

    private var generated: String = ""
    private var millis: Int = 0

    private lateinit var button0: TextView
    private lateinit var button1: TextView
    private lateinit var button2: TextView
    private lateinit var button3: TextView
    private lateinit var button4: TextView
    private lateinit var button5: TextView
    private lateinit var button6: TextView
    private lateinit var button7: TextView
    private lateinit var button8: TextView
    private lateinit var button9: TextView
    private lateinit var resetButton: ImageView
    private lateinit var doneButton: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_input, container, false)

        button0 = view.findViewById(R.id.button_0)
        button1 = view.findViewById(R.id.button_1)
        button2 = view.findViewById(R.id.button_2)
        button3 = view.findViewById(R.id.button_3)
        button4 = view.findViewById(R.id.button_4)
        button5 = view.findViewById(R.id.button_5)
        button6 = view.findViewById(R.id.button_6)
        button7 = view.findViewById(R.id.button_7)
        button8 = view.findViewById(R.id.button_8)
        button9 = view.findViewById(R.id.button_9)
        resetButton = view.findViewById(R.id.reset_button)
        doneButton = view.findViewById(R.id.done_button)

        generated = arguments?.let {
            val safeArgs = InputFragmentArgs.fromBundle(it)
            safeArgs.generated
        }!!
        millis = arguments?.let {
            val safeArgs = InputFragmentArgs.fromBundle(it)
            safeArgs.millis
        }!!

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button0.setOnClickListener { inputTextView.append("0") }
        button1.setOnClickListener { inputTextView.append("1") }
        button2.setOnClickListener { inputTextView.append("2") }
        button3.setOnClickListener { inputTextView.append("3") }
        button4.setOnClickListener { inputTextView.append("4") }
        button5.setOnClickListener { inputTextView.append("5") }
        button6.setOnClickListener { inputTextView.append("6") }
        button7.setOnClickListener { inputTextView.append("7") }
        button8.setOnClickListener { inputTextView.append("8") }
        button9.setOnClickListener { inputTextView.append("9") }

        resetButton.setOnClickListener { inputTextView.text = "" }
        doneButton.setOnClickListener {
            val input = inputTextView.text.toString()
            val args = Bundle()
            args.putBoolean(isSuccessArg, TextUtils.equals(generated, input))
            args.putInt(millisArg, millis)
            Navigation.findNavController(it).navigate(R.id.action_result, args)
        }
    }
}