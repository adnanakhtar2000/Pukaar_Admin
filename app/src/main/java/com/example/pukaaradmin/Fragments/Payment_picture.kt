package com.example.pukaaradmin.Fragments

import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.pukaaradmin.R
import com.example.pukaaradmin.databinding.FragmentPaymentPictureBinding
import kotlinx.android.synthetic.main.payment_deatils_popup.*


class Payment_picture : Fragment() {

  private lateinit var paymentPictureBinding: FragmentPaymentPictureBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        paymentPictureBinding = FragmentPaymentPictureBinding.inflate(inflater , container , false)
        // Inflate the layout for this fragment

        val pic = paymentPictureBinding.approvedPic
        val strtext = requireArguments().getString("YourKey1")
        val progressDialog = ProgressDialog(requireContext())
        progressDialog.setMessage("Please wait Image is Fetching...")
        progressDialog.setTitle("Iamge Fetching")
        progressDialog.setCancelable(false)
        progressDialog.show()
        Glide.with(requireContext())
            .load("http://pukar.qareeb.com" + strtext).error(R.drawable.ic_pukaar_logo_svg)
            .centerCrop()
            .into(pic)
        progressDialog.dismiss()
        return paymentPictureBinding.root
    }



}