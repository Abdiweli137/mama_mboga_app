package com.example.cat1work

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SocialsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_socials, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewSocials)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val socialsList = listOf(
            SocialItem(
                id = 1,
                name = "WhatsApp",
                detail = "+254 712 345 678",
                iconResId = R.drawable.whatsapp,
                url = ""
            ),
            SocialItem(
                id = 2,
                name = "Instagram",
                detail = "@mamamboga_fresh",
                iconResId = R.drawable.instagram,
                url = ""
            ),
            SocialItem(
                id = 3,
                name = "Facebook",
                detail = "Mama Mboga Fresh Market",
                iconResId = R.drawable.facebook,
                url = ""
            ),
            SocialItem(
                id = 4,
                name = "Twitter (X)",
                detail = "@mamamboga_ke",
                iconResId = R.drawable.twitter,
                url = ""
            )
        )

        recyclerView.adapter = SocialsAdapter(socialsList)
    }
}