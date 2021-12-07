package Genral_Screens_Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.pukaaradmin.*
import com.example.pukaaradmin.databinding.FragmentSettingBinding


class Setting_Fragment : Fragment() {

    private lateinit var settingBinding: FragmentSettingBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val textview : TextView = requireActivity().findViewById<TextView>(R.id.title_toolbar)
        textview.setText("Setting")
        // Inflate the layout for this fragment
        settingBinding = FragmentSettingBinding.inflate(inflater , container , false)


        settingBinding.termOfUseButton.setOnClickListener {
            requireActivity().run{
                startActivity(Intent(this, Terms_And_Conditions::class.java))

        }
        settingBinding.privacyPolicyButton.setOnClickListener {
            requireActivity().run{
                startActivity(Intent(this, Privacy_Policy::class.java))
        }

}
        settingBinding.shareButton.setOnClickListener {
            requireActivity().run{
                startActivity(Intent(this, Share::class.java))
            }
        }
            settingBinding.subscribeButton.setOnClickListener {
                requireActivity().run{
                    startActivity(Intent(this, Subscribe::class.java))
                }
            }

    }
        return settingBinding.root

}}